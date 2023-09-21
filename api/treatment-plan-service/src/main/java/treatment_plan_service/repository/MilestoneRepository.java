package treatment_plan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.generic.GenericRepository;

public interface MilestoneRepository extends GenericRepository<Milestone,Long> {
}
