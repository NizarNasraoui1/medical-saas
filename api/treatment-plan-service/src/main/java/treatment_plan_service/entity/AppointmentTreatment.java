package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "appointment_treatment")
public class AppointmentTreatment {
    @EmbeddedId
    private AppointmentTreatmentKey id;
    @ManyToOne
    @MapsId("appointmentId")
    private Appointment appointment;

    @ManyToOne
    @MapsId("treatmentId")
    private Treatment treatment;
}
