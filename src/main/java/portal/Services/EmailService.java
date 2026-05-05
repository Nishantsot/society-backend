package portal.Services;

import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${brevo.api.key}")
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient();

    private final String SENDER_EMAIL = "adgipsportal@gmail.com"; // must be verified in Brevo

    public void sendOtp(String to, String otp) {
        sendEmail(to, "Society Portal - OTP Verification",
                "Your OTP is: " + otp + "\nValid for 5 minutes.");
    }

    public void sendResetOtp(String to, String otp) {
        sendEmail(to, "Society Portal - Password Reset OTP",
                "Your OTP is: " + otp + "\nValid for 5 minutes.");
    }

    private void sendEmail(String to, String subject, String bodyText) {
        try {
                    System.out.println("API KEY: " + apiKey);

            System.out.println("🔥 Sending email to: " + to);

            String json = "{"
                    + "\"sender\":{\"email\":\"" + SENDER_EMAIL + "\"},"
                    + "\"to\":[{\"email\":\"" + to + "\"}],"
                    + "\"subject\":\"" + subject + "\","
                    + "\"textContent\":\"" + bodyText + "\""
                    + "}";

            RequestBody body = RequestBody.create(
                    json, MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url("https://api.brevo.com/v3/smtp/email")
                    .post(body)
        .addHeader("api-key", apiKey.replaceAll("\\s+", "")) // 🔥 FIX HERE

                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();

            System.out.println("✅ Email sent! Status: " + response.code());

        } catch (Exception e) {
            System.out.println("❌ Email Failed to: " + to);
            e.printStackTrace();
        }
    }
}