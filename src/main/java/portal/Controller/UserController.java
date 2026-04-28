package portal.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import portal.Dto.SocietyCardDTO;
import portal.Dto.SocietyDetailDTO;
import portal.Services.SocietyService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final SocietyService service;

    // 🔥 NEW: ALL SOCIETIES (FOR EVERYONE)
// 🔥 NEW: ALL SOCIETIES (PUBLIC)
@GetMapping("/societies")
public ResponseEntity<?> getAllSocieties() {
    try {
        List<SocietyCardDTO> societies = service.getAllSocieties();
        return ResponseEntity.ok(societies);
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Failed to fetch societies");
    }
}

    // 🔥 MEMBER DASHBOARD (OPTIONAL - future use)
    @GetMapping("/my-societies")
    public ResponseEntity<?> getMySocieties(@RequestParam String email) {
        try {
            List<SocietyCardDTO> societies = service.getMySocieties(email);
            return ResponseEntity.ok(societies);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to fetch societies");
        }
    }

    // 🔥 DETAIL PAGE (KEEP SAME)
    @GetMapping("/society/{id}")
    public ResponseEntity<?> getSociety(@PathVariable Long id) {
        try {
            SocietyDetailDTO society = service.getSocietyDetails(id);
            return ResponseEntity.ok(society);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to fetch society details");
        }
    }
}