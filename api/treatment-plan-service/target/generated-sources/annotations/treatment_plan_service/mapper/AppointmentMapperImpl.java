package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.entity.Treatment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-21T22:26:24+0200",
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
        appointmentDTO.setTreatments( treatmentListToTreatmentDTOList( bo.getTreatments() ) );

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
        appointment.setTreatments( treatmentDTOListToTreatmentList( dto.getTreatments() ) );

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
        if ( bo.getTreatments() != null ) {
            List<Treatment> list = treatmentDTOListToTreatmentList( dto.getTreatments() );
            if ( list != null ) {
                bo.getTreatments().clear();
                bo.getTreatments().addAll( list );
            }
            else {
                bo.setTreatments( null );
            }
        }
        else {
            List<Treatment> list = treatmentDTOListToTreatmentList( dto.getTreatments() );
            if ( list != null ) {
                bo.setTreatments( list );
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
}
