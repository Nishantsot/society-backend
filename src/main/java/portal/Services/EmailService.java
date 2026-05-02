package portal.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class EmailService {

    @Value("${BREVO_API_KEY}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private void sendEmail(String to, String subject, String text) {

        System.out.println("🔥 Sending email to: " + to);

        String url = "https://api.brevo.com/v3/smtp/email";

        HttpHeaders headers = new HttpHeaders();

        // ✅ IMPORTANT FIX (use add instead of set)
headers.add("api-key", apiKey.replaceAll("\\s+", ""));

        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();

        // ✅ Sender (must be verified in Brevo)
        Map<String, String> sender = new HashMap<>();
        sender.put("email", "adgipsportal@gmail.com");
        sender.put("name", "Society Portal");

        body.put("sender", sender);

        // ✅ Recipient
        List<Map<String, String>> toList = new ArrayList<>();
        Map<String, String> toEmail = new HashMap<>();
        toEmail.put("email", to);
        toList.add(toEmail);

        body.put("to", toList);

        body.put("subject", subject);
        body.put("textContent", text);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.postForEntity(url, request, String.class);

            System.out.println("✅ Email Sent: " + response.getStatusCode());

        } catch (Exception e) {
            System.out.println("❌ Email Failed");
            e.printStackTrace();
        }
    }

    // 🔢 OTP Email
    public void sendOtp(String to, String otp) {
        sendEmail(
                to,
                "Society Portal - OTP Verification",
                "Your OTP is: " + otp + "\nValid for 5 minutes."
        );
    }

    // 🔁 Reset Password
    public void sendResetOtp(String to, String otp) {
        sendEmail(
                to,
                "Password Reset OTP",
                "Your OTP is: " + otp
        );
    }
}