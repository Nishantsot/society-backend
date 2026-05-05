package portal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtp(String to, String otp) {
        try {
            System.out.println("🔥 Sending email to: " + to);

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("adgipsportal@gmail.com"); // must be verified in Mailjet
            msg.setTo(to);
            msg.setSubject("Society Portal - OTP Verification");
            msg.setText("Your OTP is: " + otp + "\nValid for 5 minutes.");

            mailSender.send(msg);

            System.out.println("✅ OTP Email Sent");

        } catch (Exception e) {
            System.out.println("❌ Email Failed");
            e.printStackTrace();
        }
    }

    public void sendResetOtp(String to, String otp) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("adgipsportal@gmail.com");
            msg.setTo(to);
            msg.setSubject("Password Reset OTP");
            msg.setText("Your OTP is: " + otp);

            mailSender.send(msg);

            System.out.println("✅ Reset Email Sent");

        } catch (Exception e) {
            System.out.println("❌ Reset Email Failed");
            e.printStackTrace();
        }
    }
}