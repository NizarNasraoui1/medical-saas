package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.entity.AppointmentTreatment;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.enumeration.AppointmentStatusEnum;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private String name;
    private AppointmentStatusEnum status;

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate date;
//    private String desciption;
//    private String name;
//    private OperationStatusEnum status;
}
