package treatment_plan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.generic.GenericRepository;

public interface TreatmentRepository extends GenericRepository<Treatment,Long> {
}
