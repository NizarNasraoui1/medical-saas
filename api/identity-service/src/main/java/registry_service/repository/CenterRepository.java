package registry_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registry_service.entity.Center;

public interface CenterRepository extends JpaRepository<Center,Long> {
}
