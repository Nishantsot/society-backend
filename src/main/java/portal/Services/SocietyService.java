package portal.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portal.Dto.SocietyCardDTO;
import portal.Dto.SocietyDetailDTO;
import portal.Entity.Society;
import portal.Entity.User;
import portal.Repository.SocietyRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SocietyService {

    private final SocietyRepository repo;

    public List<SocietyCardDTO> getMySocieties(String email) {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        List<Society> societies = repo.findAll();

        return societies.stream()
                .map(s -> {

                    List<String> memberNames = s.getMembers() != null
                            ? s.getMembers().stream()
                                .map(User::getName)
                                .limit(5)
                                .collect(Collectors.toList())
                            : List.of();

                    return SocietyCardDTO.builder()
                            .id(s.getId())
                            .name(s.getName())
                            .description(s.getDescription())
                            .logoUrl(s.getLogoUrl())
                            .instagram(s.getInstagram())
                            .adminName(
                                    s.getAdmin() != null ? s.getAdmin().getName() : "N/A"
                            )
                            .members(memberNames)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public SocietyDetailDTO getSocietyDetails(Long id) {

        Society s = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Society not found"));

        Map<String, List<String>> coreTeamMap = Map.of(

                "ROBOGYAN", List.of(
                        "Amogh Saxena – President",
                        "Aditya Goel – Vice President",
                        "Abhishek Singh Chauhan – IoT Lead",
                        "Dev Chandra – Robotics Lead",
                        "Ayush Kumar Jha – Firmware Lead",
                        "Pranav Bisht – Embedded Lead",
                        "Aditya Aggarwal – 3D Design Lead",
                        "Sneha Mukherjee – Control Systems Lead"
                ),

                "AVANT GARDE", List.of(
                        "Yug Bhagat – President",
                        "Anoop Arpan – Vice President",
                        "Pallavi Verma – General Secretary",
                        "Gautam Saini – Graphics Head",
                        "Vivek – Social Media Head",
                        "Riya Kumar – Creative Head",
                        "Parth Verma – Marketing Head",
                        "Devansh – Content Head"
                ),

                "CONFLUENZ", List.of(
                        "Nikhil Sood – President",
                        "Vansh Madan – Vice President",
                        "Lakshit Bharadwaj – General Secretary",
                        "Akshat – Graphics Head",
                        "Ali Imam – Cinematography Head",
                        "Vivek – Media Head",
                        "Pranay – Advisory Head",
                        "Maneesh – Advisory Head"
                )
        );

        List<String> coreTeam = coreTeamMap.getOrDefault(
                s.getName().toUpperCase(),
                List.of()
        );

        List<String> memberList = s.getMembers() != null
                ? s.getMembers().stream()
                        .map(User::getName)
                        .collect(Collectors.toList())
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
                .members(memberList)   
                .coreTeam(coreTeam)
                .build();
    }
}