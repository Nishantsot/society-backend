package portal.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
    try {
        SimpleMailMessage message = new SimpleMailMessage();

        // ✅ ADD THIS LINE (very important)
        message.setFrom("Adgips Portal <adgipsportal@gmail.com>");

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        System.out.println("✅ Email sent to: " + to);

    } catch (Exception e) {
        System.out.println("❌ Email failed: " + e.getMessage());
    }
}
    

    public void sendOtp(String email, String otp) {

        String subject = "🔐 OTP Verification - Society Portal";

        String body = "Hello,\n\n"
                + "Your OTP is: " + otp + "\n\n"
                + "⏳ Valid for 5 minutes.\n\n"
                + "⚠️ Do not share this OTP.\n\n"
                + "Regards,\nSociety Portal Team";

        System.out.println("OTP for " + email + " = " + otp);

        sendEmail(email, subject, body);
    }

    public void sendResetOtp(String email, String otp) {

        String subject = "🔁 Password Reset OTP";

        String body = "Hello,\n\n"
                + "Use this OTP to reset your password:\n\n"
                + "OTP: " + otp + "\n\n"
                + "Valid for 5 minutes.\n\n"
                + "If you didn’t request this, ignore it.";

        System.out.println("Reset OTP for " + email + " = " + otp);

        sendEmail(email, subject, body);
    }
}