package portal.Dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocietyCardDTO {

    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    private String instagram;

    private String adminName;
    private List<String> members; // only names
}