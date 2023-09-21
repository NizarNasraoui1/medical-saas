package treatment_plan_service.repository;

import org.springframework.stereotype.Repository;
import treatment_plan_service.entity.AppointmentTreatment;
import treatment_plan_service.entity.AppointmentTreatmentKey;
import treatment_plan_service.generic.GenericRepository;

@Repository
public interface AppointmentTreatmentRepository extends GenericRepository<AppointmentTreatment, AppointmentTreatmentKey> {
}
