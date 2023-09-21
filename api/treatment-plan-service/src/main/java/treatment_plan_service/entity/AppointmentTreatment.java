package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "appointment_treatment")
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentTreatment {
    @EmbeddedId
    private AppointmentTreatmentKey id;
    @ManyToOne
    @MapsId("appointmentId")
    private Appointment appointment;

    @ManyToOne
    @MapsId("treatmentId")
    private Treatment treatment;

    private String description;
}
