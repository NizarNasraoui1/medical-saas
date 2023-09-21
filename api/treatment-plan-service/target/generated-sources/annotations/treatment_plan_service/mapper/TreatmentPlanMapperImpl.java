package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.AppointmentMilestoneDTO;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.entity.TreatmentPlan;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T01:01:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class TreatmentPlanMapperImpl implements TreatmentPlanMapper {

    @Override
    public List<TreatmentPlanDTO> toDtos(List<TreatmentPlan> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TreatmentPlanDTO> list = new ArrayList<TreatmentPlanDTO>( dtos.size() );
        for ( TreatmentPlan treatmentPlan : dtos ) {
            list.add( toDto( treatmentPlan ) );
        }

        return list;
    }

    @Override
    public List<TreatmentPlan> toBos(List<TreatmentPlanDTO> bos) {
        if ( bos == null ) {
            return null;
        }

        List<TreatmentPlan> list = new ArrayList<TreatmentPlan>( bos.size() );
        for ( TreatmentPlanDTO treatmentPlanDTO : bos ) {
            list.add( toBo( treatmentPlanDTO ) );
        }

        return list;
    }

    @Override
    public TreatmentPlanDTO toDto(TreatmentPlan bo) {
        if ( bo == null ) {
            return null;
        }

        TreatmentPlanDTO treatmentPlanDTO = new TreatmentPlanDTO();

        treatmentPlanDTO.setId( bo.getId() );
        treatmentPlanDTO.setName( bo.getName() );
        treatmentPlanDTO.setPatientName( bo.getPatientName() );
        treatmentPlanDTO.setDescription( bo.getDescription() );
        treatmentPlanDTO.setDate( bo.getDate() );
        treatmentPlanDTO.setAppointments( appointmentListToAppointmentDTOList( bo.getAppointments() ) );

        return treatmentPlanDTO;
    }

    @Override
    public TreatmentPlan toBo(TreatmentPlanDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TreatmentPlan treatmentPlan = new TreatmentPlan();

        treatmentPlan.setId( dto.getId() );
        treatmentPlan.setName( dto.getName() );
        treatmentPlan.setPatientName( dto.getPatientName() );
        treatmentPlan.setDescription( dto.getDescription() );
        treatmentPlan.setDate( dto.getDate() );
        treatmentPlan.setAppointments( appointmentDTOListToAppointmentList( dto.getAppointments() ) );

        return treatmentPlan;
    }

    @Override
    public TreatmentPlan fillBo(TreatmentPlanDTO dto, TreatmentPlan bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );
        bo.setPatientName( dto.getPatientName() );
        bo.setDescription( dto.getDescription() );
        bo.setDate( dto.getDate() );
        if ( bo.getAppointments() != null ) {
            List<Appointment> list = appointmentDTOListToAppointmentList( dto.getAppointments() );
            if ( list != null ) {
                bo.getAppointments().clear();
                bo.getAppointments().addAll( list );
            }
            else {
                bo.setAppointments( null );
            }
        }
        else {
            List<Appointment> list = appointmentDTOListToAppointmentList( dto.getAppointments() );
            if ( list != null ) {
                bo.setAppointments( list );
            }
        }

        return bo;
    }

    protected MilestoneDTO milestoneToMilestoneDTO(Milestone milestone) {
        if ( milestone == null ) {
            return null;
        }

        MilestoneDTO milestoneDTO = new MilestoneDTO();

        milestoneDTO.setId( milestone.getId() );
        milestoneDTO.setName( milestone.getName() );

        return milestoneDTO;
    }

    protected AppointmentMilestoneDTO appointmentMilestoneToAppointmentMilestoneDTO(AppointmentMilestone appointmentMilestone) {
        if ( appointmentMilestone == null ) {
            return null;
        }

        AppointmentMilestoneDTO appointmentMilestoneDTO = new AppointmentMilestoneDTO();

        appointmentMilestoneDTO.setMilestone( milestoneToMilestoneDTO( appointmentMilestone.getMilestone() ) );

        return appointmentMilestoneDTO;
    }

    protected List<AppointmentMilestoneDTO> appointmentMilestoneListToAppointmentMilestoneDTOList(List<AppointmentMilestone> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentMilestoneDTO> list1 = new ArrayList<AppointmentMilestoneDTO>( list.size() );
        for ( AppointmentMilestone appointmentMilestone : list ) {
            list1.add( appointmentMilestoneToAppointmentMilestoneDTO( appointmentMilestone ) );
        }

        return list1;
    }

    protected AppointmentDTO appointmentToAppointmentDTO(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId( appointment.getId() );
        appointmentDTO.setName( appointment.getName() );
        appointmentDTO.setStatus( appointment.getStatus() );
        appointmentDTO.setMilestones( appointmentMilestoneListToAppointmentMilestoneDTOList( appointment.getMilestones() ) );

        return appointmentDTO;
    }

    protected List<AppointmentDTO> appointmentListToAppointmentDTOList(List<Appointment> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentDTO> list1 = new ArrayList<AppointmentDTO>( list.size() );
        for ( Appointment appointment : list ) {
            list1.add( appointmentToAppointmentDTO( appointment ) );
        }

        return list1;
    }

    protected Milestone milestoneDTOToMilestone(MilestoneDTO milestoneDTO) {
        if ( milestoneDTO == null ) {
            return null;
        }

        Milestone milestone = new Milestone();

        milestone.setId( milestoneDTO.getId() );
        milestone.setName( milestoneDTO.getName() );

        return milestone;
    }

    protected AppointmentMilestone appointmentMilestoneDTOToAppointmentMilestone(AppointmentMilestoneDTO appointmentMilestoneDTO) {
        if ( appointmentMilestoneDTO == null ) {
            return null;
        }

        AppointmentMilestone appointmentMilestone = new AppointmentMilestone();

        appointmentMilestone.setMilestone( milestoneDTOToMilestone( appointmentMilestoneDTO.getMilestone() ) );

        return appointmentMilestone;
    }

    protected List<AppointmentMilestone> appointmentMilestoneDTOListToAppointmentMilestoneList(List<AppointmentMilestoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentMilestone> list1 = new ArrayList<AppointmentMilestone>( list.size() );
        for ( AppointmentMilestoneDTO appointmentMilestoneDTO : list ) {
            list1.add( appointmentMilestoneDTOToAppointmentMilestone( appointmentMilestoneDTO ) );
        }

        return list1;
    }

    protected Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId( appointmentDTO.getId() );
        appointment.setName( appointmentDTO.getName() );
        appointment.setStatus( appointmentDTO.getStatus() );
        appointment.setMilestones( appointmentMilestoneDTOListToAppointmentMilestoneList( appointmentDTO.getMilestones() ) );

        return appointment;
    }

    protected List<Appointment> appointmentDTOListToAppointmentList(List<AppointmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Appointment> list1 = new ArrayList<Appointment>( list.size() );
        for ( AppointmentDTO appointmentDTO : list ) {
            list1.add( appointmentDTOToAppointment( appointmentDTO ) );
        }

        return list1;
    }
}
