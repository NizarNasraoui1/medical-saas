package treatment_plan_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter @Setter
public class AppointmentTreatmentKey implements Serializable {
    @Column(name = "appointment_id")
    private Long appointmentId;
    @Column(name = "treatment_id")
    private Long treatmentId;
    private String description;
}
