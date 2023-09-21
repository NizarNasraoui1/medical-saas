package treatment_plan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import treatment_plan_service.entity.TreatmentPlan;
import org.springframework.stereotype.Repository;
import treatment_plan_service.generic.GenericRepository;

@Repository
public interface TreatmentPlanRepository extends GenericRepository<TreatmentPlan,Long> {
}
