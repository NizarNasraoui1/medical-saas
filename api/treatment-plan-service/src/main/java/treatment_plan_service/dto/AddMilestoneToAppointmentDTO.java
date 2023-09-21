package treatment_plan_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddMilestoneToAppointmentDTO {
    private Long milestoneId;
    private Long appointmentId;
    private String description;
}
