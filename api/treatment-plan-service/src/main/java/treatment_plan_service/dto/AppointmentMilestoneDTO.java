package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.Milestone;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentMilestoneDTO {
    private MilestoneDTO milestone;
}