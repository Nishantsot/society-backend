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

    private final String SENDER_EMAIL = "adgipsportal@gmail.com";
    private final String SENDER_NAME = "Society Portal";

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
            System.out.println("🔥 Sending email to: " + to);
            System.out.println("API Key Length: " + (apiKey != null ? apiKey.length() : 0));

            // 🔥 FIX: escape newline properly
            String safeText = bodyText.replace("\n", "\\n");

            String json = """
                    {
                      "sender": {
                        "name": "%s",
                        "email": "%s"
                      },
                      "to": [{"email": "%s"}],
                      "subject": "%s",
                      "textContent": "%s"
                    }
                    """.formatted(
                            SENDER_NAME,
                            SENDER_EMAIL,
                            to,
                            subject,
                            safeText
                    );

            RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url("https://api.brevo.com/v3/smtp/email")
                    .post(body)
                    .addHeader("api-key", apiKey.replaceAll("\\s+", "")) // 🔥 remove all whitespace
                    .addHeader("Content-Type", "application/json")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                String responseBody = response.body() != null ? response.body().string() : "";

                System.out.println("✅ Email sent! Status: " + response.code());

                if (response.code() != 201) {
                    System.out.println("❌ Response Body: " + responseBody);
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Email Failed to: " + to);
            e.printStackTrace();
        }
    }
}