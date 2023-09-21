package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.AppointmentMilestoneDTO;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.entity.Milestone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T01:01:21+0200",
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
}
