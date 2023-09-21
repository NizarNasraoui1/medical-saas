package treatment_plan_service.repository;

import org.springframework.stereotype.Repository;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.generic.GenericRepository;

@Repository
public interface AppointmentMilestoneRepository extends GenericRepository<AppointmentMilestone,Long> {
}
