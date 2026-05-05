package portal.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendOtp(String to, String otp) {
        sendEmail(to, "Society Portal - OTP Verification",
                "Your OTP is: " + otp + "\nValid for 5 minutes.");
    }

    public void sendResetOtp(String to, String otp) {
        sendEmail(to, "Password Reset OTP",
                "Your OTP is: " + otp);
    }

    private void sendEmail(String to, String subject, String body) {
        try {
            System.out.println("🔥 Sending email to: " + to);

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("adgipsportal@gmail.com"); // MUST match Gmail
            msg.setTo(to);
            msg.setSubject(subject);
            msg.setText(body);

            mailSender.send(msg);

            System.out.println("✅ Email Sent Successfully");

        } catch (Exception e) {
            System.out.println("❌ Email Failed");
            e.printStackTrace();
        }
    }
}