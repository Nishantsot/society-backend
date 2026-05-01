package portal.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class EmailService {

    @Value("${RESEND_API_KEY}")
    private String apiKey;

    @Value("${RESEND_FROM}")
    private String from;

    private final RestTemplate restTemplate = new RestTemplate();

    private void sendEmail(String to, String subject, String text) {

        String url = "https://api.resend.com/emails";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{"
                + "\"from\":\"" + from + "\","
                + "\"to\":[\"" + to + "\"],"
                + "\"subject\":\"" + subject + "\","
                + "\"text\":\"" + text + "\""
                + "}";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        try {
            restTemplate.postForEntity(url, request, String.class);
            System.out.println("✅ Resend Email Sent");
        } catch (Exception e) {
            System.out.println("❌ Resend Failed");
            e.printStackTrace();
        }
    }

    public void sendOtp(String to, String otp) {
        sendEmail(to,
                "Society Portal - OTP Verification",
                "Your OTP is: " + otp + "\nValid for 5 minutes.");
    }

    public void sendResetOtp(String to, String otp) {
        sendEmail(to,
                "Society Portal - Password Reset OTP",
                "Your reset OTP is: " + otp + "\nValid for 5 minutes.");
    }
}