package portal.Entity;

import jakarta.persistence.*;
import lombok.*;
import portal.Enum.Branch;
import portal.Enum.Role;
import portal.Enum.Year;

@Entity
@Table(name = "users")   // ✅ ADD THIS LINE
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String otp;

    private Long otpExpiry;   

private Boolean verified;
    @Enumerated(EnumType.STRING)
    private Year year;

    @Enumerated(EnumType.STRING)
    private Branch branch;
}