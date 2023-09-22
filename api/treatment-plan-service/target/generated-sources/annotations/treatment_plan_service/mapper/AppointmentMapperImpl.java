package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.AppointmentMilestoneDTO;
import treatment_plan_service.dto.AppointmentTreatmentDTO;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.entity.AppointmentTreatment;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.entity.Treatment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T10:50:29+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public List<AppointmentDTO> toDtos(List<Appointment> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<AppointmentDTO> list = new ArrayList<AppointmentDTO>( dtos.size() );
        for ( Appointment appointment : dtos ) {
            list.add( toDto( appointment ) );
        }

        return list;
    }

    @Override
    public List<Appointment> toBos(List<AppointmentDTO> bos) {
        if ( bos == null ) {
            return null;
        }

        List<Appointment> list = new ArrayList<Appointment>( bos.size() );
        for ( AppointmentDTO appointmentDTO : bos ) {
            list.add( toBo( appointmentDTO ) );
        }

        return list;
    }

    @Override
    public AppointmentDTO toDto(Appointment bo) {
        if ( bo == null ) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId( bo.getId() );
        appointmentDTO.setName( bo.getName() );
        appointmentDTO.setStatus( bo.getStatus() );
        appointmentDTO.setMilestones( appointmentMilestoneListToAppointmentMilestoneDTOList( bo.getMilestones() ) );
        appointmentDTO.setTreatments( appointmentTreatmentListToAppointmentTreatmentDTOList( bo.getTreatments() ) );

        return appointmentDTO;
    }

    @Override
    public Appointment toBo(AppointmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId( dto.getId() );
        appointment.setName( dto.getName() );
        appointment.setStatus( dto.getStatus() );
        appointment.setMilestones( appointmentMilestoneDTOListToAppointmentMilestoneList( dto.getMilestones() ) );
        appointment.setTreatments( appointmentTreatmentDTOListToAppointmentTreatmentList( dto.getTreatments() ) );

        return appointment;
    }

    @Override
    public Appointment fillBo(AppointmentDTO dto, Appointment bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );
        bo.setStatus( dto.getStatus() );
        if ( bo.getMilestones() != null ) {
            List<AppointmentMilestone> list = appointmentMilestoneDTOListToAppointmentMilestoneList( dto.getMilestones() );
            if ( list != null ) {
                bo.getMilestones().clear();
                bo.getMilestones().addAll( list );
            }
            else {
                bo.setMilestones( null );
            }
        }
        else {
            List<AppointmentMilestone> list = appointmentMilestoneDTOListToAppointmentMilestoneList( dto.getMilestones() );
            if ( list != null ) {
                bo.setMilestones( list );
            }
        }
        if ( bo.getTreatments() != null ) {
            List<AppointmentTreatment> list1 = appointmentTreatmentDTOListToAppointmentTreatmentList( dto.getTreatments() );
            if ( list1 != null ) {
                bo.getTreatments().clear();
                bo.getTreatments().addAll( list1 );
            }
            else {
                bo.setTreatments( null );
            }
        }
        else {
            List<AppointmentTreatment> list1 = appointmentTreatmentDTOListToAppointmentTreatmentList( dto.getTreatments() );
            if ( list1 != null ) {
                bo.setTreatments( list1 );
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

    protected TreatmentDTO treatmentToTreatmentDTO(Treatment treatment) {
        if ( treatment == null ) {
            return null;
        }

        TreatmentDTO treatmentDTO = new TreatmentDTO();

        treatmentDTO.setId( treatment.getId() );
        treatmentDTO.setName( treatment.getName() );

        return treatmentDTO;
    }

    protected AppointmentTreatmentDTO appointmentTreatmentToAppointmentTreatmentDTO(AppointmentTreatment appointmentTreatment) {
        if ( appointmentTreatment == null ) {
            return null;
        }

        AppointmentTreatmentDTO appointmentTreatmentDTO = new AppointmentTreatmentDTO();

        appointmentTreatmentDTO.setTreatment( treatmentToTreatmentDTO( appointmentTreatment.getTreatment() ) );

        return appointmentTreatmentDTO;
    }

    protected List<AppointmentTreatmentDTO> appointmentTreatmentListToAppointmentTreatmentDTOList(List<AppointmentTreatment> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentTreatmentDTO> list1 = new ArrayList<AppointmentTreatmentDTO>( list.size() );
        for ( AppointmentTreatment appointmentTreatment : list ) {
            list1.add( appointmentTreatmentToAppointmentTreatmentDTO( appointmentTreatment ) );
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

    protected Treatment treatmentDTOToTreatment(TreatmentDTO treatmentDTO) {
        if ( treatmentDTO == null ) {
            return null;
        }

        Treatment treatment = new Treatment();

        treatment.setId( treatmentDTO.getId() );
        treatment.setName( treatmentDTO.getName() );

        return treatment;
    }

    protected AppointmentTreatment appointmentTreatmentDTOToAppointmentTreatment(AppointmentTreatmentDTO appointmentTreatmentDTO) {
        if ( appointmentTreatmentDTO == null ) {
            return null;
        }

        AppointmentTreatment appointmentTreatment = new AppointmentTreatment();

        appointmentTreatment.setTreatment( treatmentDTOToTreatment( appointmentTreatmentDTO.getTreatment() ) );

        return appointmentTreatment;
    }

    protected List<AppointmentTreatment> appointmentTreatmentDTOListToAppointmentTreatmentList(List<AppointmentTreatmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentTreatment> list1 = new ArrayList<AppointmentTreatment>( list.size() );
        for ( AppointmentTreatmentDTO appointmentTreatmentDTO : list ) {
            list1.add( appointmentTreatmentDTOToAppointmentTreatment( appointmentTreatmentDTO ) );
        }

        return list1;
    }
}
