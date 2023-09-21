package treatment_plan_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentTreatmentKey implements Serializable {
    @Column(name = "appointment_id")
    private Long appointmentId;
    @Column(name = "treatment_id")
    private Long treatmentId;
}
