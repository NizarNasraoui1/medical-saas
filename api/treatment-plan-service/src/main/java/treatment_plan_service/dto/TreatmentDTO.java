package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.AppointmentTreatment;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDTO {

    private Long id;

    String name;

    //private List<AppointmentDTO> appointments;

    private List<MilestoneDTO> milestones;

}
