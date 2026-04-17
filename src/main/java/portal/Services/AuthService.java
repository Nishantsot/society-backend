package portal.Services;

import lombok.RequiredArgsConstructor;
import portal.Util.JwtUtil;
import portal.Entity.User;
import portal.Enum.Role;
import portal.Repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final EmailService emailService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    // 🔢 OTP Generator
    private String generateOtp(){
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    // 🔐 REGISTER (UPDATED 🔥)
    public String register(User user){

        User existingUser = repo.findByEmail(user.getEmail()).orElse(null);

        // 👉 If email already exists
        if(existingUser != null){

            // ❌ If already verified → block
            if(Boolean.TRUE.equals(existingUser.getVerified())){
                throw new IllegalArgumentException("Email already exists. Please login.");
            }

            // 🔁 If NOT verified → resend OTP
            String otp = generateOtp();
            existingUser.setOtp(otp);
            repo.save(existingUser);

            emailService.sendOtp(existingUser.getEmail(), otp);

            return "OTP resent. Please verify your email.";
        }

        // 👉 New User
        String otp = generateOtp();

        user.setOtp(otp);
        user.setVerified(false);

        if(user.getRole() == null){
            user.setRole(Role.MEMBER);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repo.save(user);
        emailService.sendOtp(user.getEmail(), otp);

        return "OTP sent to email";
    }

    // 🔢 VERIFY OTP
    public String verify(String email,String otp){

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(user.getOtp() != null && user.getOtp().equals(otp)){
            user.setVerified(true);
            user.setOtp(null);
            repo.save(user);
            return "Account verified";
        }

        throw new IllegalArgumentException("Invalid OTP");
    }

    // 🔐 LOGIN
    public Map<String,Object> login(User login){

        User user = repo.findByEmail(login.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(!Boolean.TRUE.equals(user.getVerified())){
            throw new IllegalArgumentException("Please verify your email first");
        }

        if(!passwordEncoder.matches(login.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        Map<String,Object> response = new HashMap<>();
        response.put("token", token);
        response.put("role", user.getRole().name());
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("branch", user.getBranch());
        response.put("year", user.getYear());

        return response;
    }

    public String forgotPassword(String email){

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String otp = generateOtp();

        user.setOtp(otp);
        repo.save(user);

        emailService.sendResetOtp(email, otp);

        return "OTP sent for password reset";
    }

    public String resetPassword(String email,String otp,String newPassword){

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(user.getOtp() != null && user.getOtp().equals(otp)){
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setOtp(null);
            repo.save(user);
            return "Password updated successfully";
        }

        throw new IllegalArgumentException("Invalid OTP");
    }

    public String resendOtp(String email){

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String otp = generateOtp();

        user.setOtp(otp);
        repo.save(user);

        emailService.sendOtp(email, otp);

        return "OTP resent successfully";
    }
}