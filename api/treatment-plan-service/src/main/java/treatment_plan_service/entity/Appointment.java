package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.enumeration.AppointmentStatusEnum;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private AppointmentStatusEnum status = AppointmentStatusEnum.UNDONE;
    @ManyToOne
    @JoinColumn(name="treatment_plan_id",referencedColumnName = "id")
    private TreatmentPlan treatmentPlan;

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentTreatment> treatments;

}
