package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentMilestoneDTO;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.entity.Milestone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T23:25:25+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class AppointmentMilestonMapperImpl implements AppointmentMilestonMapper {

    @Override
    public List<AppointmentMilestoneDTO> toDtos(List<AppointmentMilestone> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<AppointmentMilestoneDTO> list = new ArrayList<AppointmentMilestoneDTO>( dtos.size() );
        for ( AppointmentMilestone appointmentMilestone : dtos ) {
            list.add( toDto( appointmentMilestone ) );
        }

        return list;
    }

    @Override
    public List<AppointmentMilestone> toBos(List<AppointmentMilestoneDTO> bos) {
        if ( bos == null ) {
            return null;
        }

        List<AppointmentMilestone> list = new ArrayList<AppointmentMilestone>( bos.size() );
        for ( AppointmentMilestoneDTO appointmentMilestoneDTO : bos ) {
            list.add( toBo( appointmentMilestoneDTO ) );
        }

        return list;
    }

    @Override
    public AppointmentMilestoneDTO toDto(AppointmentMilestone bo) {
        if ( bo == null ) {
            return null;
        }

        AppointmentMilestoneDTO appointmentMilestoneDTO = new AppointmentMilestoneDTO();

        appointmentMilestoneDTO.setMilestone( milestoneToMilestoneDTO( bo.getMilestone() ) );

        return appointmentMilestoneDTO;
    }

    @Override
    public AppointmentMilestone toBo(AppointmentMilestoneDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AppointmentMilestone appointmentMilestone = new AppointmentMilestone();

        appointmentMilestone.setMilestone( milestoneDTOToMilestone( dto.getMilestone() ) );

        return appointmentMilestone;
    }

    @Override
    public AppointmentMilestone fillBo(AppointmentMilestoneDTO dto, AppointmentMilestone bo) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getMilestone() != null ) {
            if ( bo.getMilestone() == null ) {
                bo.setMilestone( new Milestone() );
            }
            milestoneDTOToMilestone1( dto.getMilestone(), bo.getMilestone() );
        }
        else {
            bo.setMilestone( null );
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

    protected Milestone milestoneDTOToMilestone(MilestoneDTO milestoneDTO) {
        if ( milestoneDTO == null ) {
            return null;
        }

        Milestone milestone = new Milestone();

        milestone.setId( milestoneDTO.getId() );
        milestone.setName( milestoneDTO.getName() );

        return milestone;
    }

    protected void milestoneDTOToMilestone1(MilestoneDTO milestoneDTO, Milestone mappingTarget) {
        if ( milestoneDTO == null ) {
            return;
        }

        mappingTarget.setId( milestoneDTO.getId() );
        mappingTarget.setName( milestoneDTO.getName() );
    }
}
