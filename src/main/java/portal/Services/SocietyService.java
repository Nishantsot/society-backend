package portal.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portal.Dto.SocietyCardDTO;
import portal.Dto.SocietyDetailDTO;
import portal.Entity.Society;
import portal.Repository.SocietyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SocietyService {

    private final SocietyRepository repo;

    public List<SocietyCardDTO> getMySocieties(String email) {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        return repo.findAll().stream()
                .map(s -> SocietyCardDTO.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .description(s.getDescription())
                        .logoUrl(s.getLogoUrl())
                        .instagram(s.getInstagram())
                        .adminName(
                                s.getAdmin() != null ? s.getAdmin().getName() : "N/A"
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }

    public SocietyDetailDTO getSocietyDetails(Long id) {

        Society s = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Society not found"));

        List<String> coreTeam = s.getCoreTeam() != null
                ? s.getCoreTeam()
                : List.of();

        return SocietyDetailDTO.builder()
                .id(s.getId())
                .name(s.getName())
                .description(s.getDescription())
                .vision(s.getVision())
                .mission(s.getMission())
                .recentEvent(s.getRecentEvent())
                .achievements(s.getAchievements())
                .instagram(s.getInstagram())
                .website(s.getWebsite())
                .youtube(s.getYoutube())
                .linkedin(s.getLinkedin())
                .logoUrl(s.getLogoUrl())
                .adminName(
                        s.getAdmin() != null ? s.getAdmin().getName() : "N/A"
                )
                .coreTeam(coreTeam)
                            .images(s.getImages())

                .build();
    }

    public List<SocietyCardDTO> getAllSocieties() {

        return repo.findAll().stream()
                .map(s -> SocietyCardDTO.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .description(s.getDescription())
                        .logoUrl(s.getLogoUrl())
                        .instagram(s.getInstagram())
                        .adminName(
                                s.getAdmin() != null ? s.getAdmin().getName() : "N/A"
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }
}