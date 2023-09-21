package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.entity.AppointmentTreatmentKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentTreatmentDTO {

    private AppointmentTreatmentKey id;
    private AppointmentDTO appointment;
    private TreatmentDTO treatment;
}
