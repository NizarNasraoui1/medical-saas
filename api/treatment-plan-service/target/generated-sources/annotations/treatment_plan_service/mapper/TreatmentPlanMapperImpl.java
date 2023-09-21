package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.entity.TreatmentPlan;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-21T19:03:26+0200",
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
        milestoneDTO.setTreatment( treatmentToTreatmentDTO( milestone.getTreatment() ) );

        return milestoneDTO;
    }

    protected List<MilestoneDTO> milestoneListToMilestoneDTOList(List<Milestone> list) {
        if ( list == null ) {
            return null;
        }

        List<MilestoneDTO> list1 = new ArrayList<MilestoneDTO>( list.size() );
        for ( Milestone milestone : list ) {
            list1.add( milestoneToMilestoneDTO( milestone ) );
        }

        return list1;
    }

    protected TreatmentDTO treatmentToTreatmentDTO(Treatment treatment) {
        if ( treatment == null ) {
            return null;
        }

        TreatmentDTO treatmentDTO = new TreatmentDTO();

        treatmentDTO.setId( treatment.getId() );
        treatmentDTO.setName( treatment.getName() );
        treatmentDTO.setMilestones( milestoneListToMilestoneDTOList( treatment.getMilestones() ) );

        return treatmentDTO;
    }

    protected List<TreatmentDTO> treatmentListToTreatmentDTOList(List<Treatment> list) {
        if ( list == null ) {
            return null;
        }

        List<TreatmentDTO> list1 = new ArrayList<TreatmentDTO>( list.size() );
        for ( Treatment treatment : list ) {
            list1.add( treatmentToTreatmentDTO( treatment ) );
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
        appointmentDTO.setTreatmentPlan( toDto( appointment.getTreatmentPlan() ) );
        appointmentDTO.setTreatments( treatmentListToTreatmentDTOList( appointment.getTreatments() ) );

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
        milestone.setTreatment( treatmentDTOToTreatment( milestoneDTO.getTreatment() ) );

        return milestone;
    }

    protected List<Milestone> milestoneDTOListToMilestoneList(List<MilestoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Milestone> list1 = new ArrayList<Milestone>( list.size() );
        for ( MilestoneDTO milestoneDTO : list ) {
            list1.add( milestoneDTOToMilestone( milestoneDTO ) );
        }

        return list1;
    }

    protected Treatment treatmentDTOToTreatment(TreatmentDTO treatmentDTO) {
        if ( treatmentDTO == null ) {
            return null;
        }

        Treatment treatment = new Treatment();

        treatment.setId( treatmentDTO.getId() );
        treatment.setName( treatmentDTO.getName() );
        treatment.setMilestones( milestoneDTOListToMilestoneList( treatmentDTO.getMilestones() ) );

        return treatment;
    }

    protected List<Treatment> treatmentDTOListToTreatmentList(List<TreatmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Treatment> list1 = new ArrayList<Treatment>( list.size() );
        for ( TreatmentDTO treatmentDTO : list ) {
            list1.add( treatmentDTOToTreatment( treatmentDTO ) );
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
        appointment.setTreatmentPlan( toBo( appointmentDTO.getTreatmentPlan() ) );
        appointment.setTreatments( treatmentDTOListToTreatmentList( appointmentDTO.getTreatments() ) );

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
