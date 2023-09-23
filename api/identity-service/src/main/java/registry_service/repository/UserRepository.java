package registry_service.repository;

import org.springframework.data.jpa.repository.Query;
import registry_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByName(String username);

    boolean existsByName(String name);

    @Query(value = "select role.name from User user join Role role on user.role = role and user.name=:username")
    String getUserRoleName(String username);

}
