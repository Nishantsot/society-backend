package portal.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Society {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    @Column(length = 1000)
    private String vision;

    @Column(length = 1500)
    private String mission;

    @Column(length = 1500)
    private String recentEvent;

    @Column(length = 1500)
    private String achievements;

    @ElementCollection
    private List<String> images;

    // ✅ ADD THIS
    @ElementCollection
    @CollectionTable(name = "society_core_team", joinColumns = @JoinColumn(name = "society_id"))
    @Column(name = "member")
    private List<String> coreTeam;

    private String instagram;
    private String website;
    private String youtube;
    private String linkedin;

    private String logoUrl; 

    @ManyToOne
    private User admin;

    @ManyToMany
    private List<User> members;
    
}