package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "appointment_milestone")
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentMilestone {
    @EmbeddedId
    private AppointmentMilestoneKey id;

    @ManyToOne
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @MapsId("milestoneId")
    private Milestone milestone;

    private String description;
}
