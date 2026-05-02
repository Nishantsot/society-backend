package portal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // 🔢 OTP Email
    public void sendOtp(String to, String otp) {

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("Society Portal <nishantkumar8604@gmail.com>");
            msg.setTo(to);
            msg.setSubject("Society Portal - OTP Verification");
            msg.setText(
                    "Hello,\n\n" +
                    "Your OTP is: " + otp + "\n" +
                    "Valid for 5 minutes.\n\n" +
                    "Regards,\nSociety Portal"
            );

            mailSender.send(msg);

            System.out.println("✅ OTP Email Sent");

        } catch (Exception e) {
            System.out.println("❌ Email Failed");
            e.printStackTrace();
        }
    }

    // 🔁 Reset Password
    public void sendResetOtp(String to, String otp) {

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("Society Portal <nishantkumar8604@gmail.com>");
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