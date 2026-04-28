package portal.Controller;

import lombok.RequiredArgsConstructor;
import portal.Entity.User;
import portal.Services.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthService service;

    // 🔐 REGISTER (UPDATED LOGIC)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            String response = service.register(user);

            // 👉 Custom handling based on message
            if (response.contains("resent")) {
                return ResponseEntity.status(200).body(response); // OTP resend case
            }

            return ResponseEntity.ok(response); // New user
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // verified email case
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Registration failed");
        }
    }

    // 🔢 VERIFY OTP
    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody Map<String, String> request) {
        try {
            return ResponseEntity.ok(
                service.verify(request.get("email"), request.get("otp"))
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 🔁 RESEND OTP
    @PostMapping("/resend-otp")
    public ResponseEntity<?> resendOtp(@RequestBody Map<String, String> request) {
        try {
            return ResponseEntity.ok(service.resendOtp(request.get("email")));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 🔐 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            return ResponseEntity.ok(service.login(user));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    // 🔁 FORGOT PASSWORD
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
        try {
            return ResponseEntity.ok(service.forgotPassword(request.get("email")));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 🔑 RESET PASSWORD
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        try {
            return ResponseEntity.ok(
                service.resetPassword(
                    request.get("email"),
                    request.get("otp"),
                    request.get("newPassword")
                )
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}