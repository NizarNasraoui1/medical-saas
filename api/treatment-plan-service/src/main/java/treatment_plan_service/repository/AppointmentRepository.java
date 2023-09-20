package treatment_plan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericRepository;

@Repository
public interface AppointmentRepository extends GenericRepository<Appointment,Long> {
}
