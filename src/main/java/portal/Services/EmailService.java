package portal.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Value("${RESEND_API_KEY}")
    private String apiKey;

    @Value("${RESEND_FROM}")
    private String from;

    private final RestTemplate restTemplate = new RestTemplate();

    // 🔥 Common method to send email
    private void sendEmail(String to, String subject, String text) {

        System.out.println("🔥 Sending email to: " + to);

        String url = "https://api.resend.com/emails";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // ✅ SAFE JSON BODY (no manual string)
        Map<String, Object> body = new HashMap<>();
        body.put("from", from);
        body.put("to", new String[]{to});
        body.put("subject", subject);
        body.put("text", text);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.postForEntity(url, request, String.class);

            System.out.println("✅ Resend Email Sent | Status: " + response.getStatusCode());

        } catch (Exception e) {
            System.out.println("❌ Resend Failed");
            e.printStackTrace();
        }
    }

    // 🔢 OTP Email
    public void sendOtp(String to, String otp) {
        sendEmail(
                to,
                "Society Portal - OTP Verification",
                "Hello,\n\n"
                        + "Your OTP is: " + otp + "\n"
                        + "This OTP is valid for 5 minutes.\n\n"
                        + "Do not share this OTP with anyone.\n\n"
                        + "Regards,\nSociety Portal"
        );
    }

    // 🔁 Reset Password OTP
    public void sendResetOtp(String to, String otp) {
        sendEmail(
                to,
                "Society Portal - Password Reset OTP",
                "Hello,\n\n"
                        + "Your password reset OTP is: " + otp + "\n"
                        + "Valid for 5 minutes.\n\n"
                        + "Regards,\nSociety Portal"
        );
    }
}