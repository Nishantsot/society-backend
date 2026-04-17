package portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portal.Entity.User;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // 🔐 Login / Auth
    Optional<User> findByEmail(String email);
 boolean existsByEmail(String email);

    // 🎓 Filter by branch + year (for admin dashboard)
    List<User> findByBranchAndYear(String branch, int year);

}