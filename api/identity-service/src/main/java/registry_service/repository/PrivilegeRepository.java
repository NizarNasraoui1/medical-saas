package registry_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registry_service.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
}
