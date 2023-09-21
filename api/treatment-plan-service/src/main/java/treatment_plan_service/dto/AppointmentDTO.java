package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.enumeration.AppointmentStatusEnum;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private String name;
    private AppointmentStatusEnum status = AppointmentStatusEnum.UNDONE;
    private List<AppointmentMilestoneDTO> milestones;

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate date;
//    private String desciption;
//    private String name;
//    private OperationStatusEnum status;
}
