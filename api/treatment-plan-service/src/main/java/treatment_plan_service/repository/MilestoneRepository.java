package treatment_plan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import treatment_plan_service.entity.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone,Long> {
}
