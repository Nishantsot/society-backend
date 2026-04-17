package portal.Dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocietyDetailDTO {

    private Long id;
    private String name;
    private String description;
    private String vision;
    private String mission;
    private String recentEvent;
    private String achievements;

    private String instagram;
    private String website;
    private String youtube;
    private String linkedin;

    private String logoUrl;

    private String adminName;

    // 🔥 ADD THIS
    private List<String> members;

    // 🔥 ALREADY ADDED
    private List<String> coreTeam;
}