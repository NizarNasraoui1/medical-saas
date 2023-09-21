package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.entity.Treatment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-21T22:07:14+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class TreatmentMapperImpl implements TreatmentMapper {

    @Override
    public List<TreatmentDTO> toDtos(List<Treatment> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TreatmentDTO> list = new ArrayList<TreatmentDTO>( dtos.size() );
        for ( Treatment treatment : dtos ) {
            list.add( toDto( treatment ) );
        }

        return list;
    }

    @Override
    public List<Treatment> toBos(List<TreatmentDTO> bos) {
        if ( bos == null ) {
            return null;
        }

        List<Treatment> list = new ArrayList<Treatment>( bos.size() );
        for ( TreatmentDTO treatmentDTO : bos ) {
            list.add( toBo( treatmentDTO ) );
        }

        return list;
    }

    @Override
    public TreatmentDTO toDto(Treatment bo) {
        if ( bo == null ) {
            return null;
        }

        TreatmentDTO treatmentDTO = new TreatmentDTO();

        treatmentDTO.setId( bo.getId() );
        treatmentDTO.setName( bo.getName() );
        treatmentDTO.setMilestones( milestoneListToMilestoneDTOList( bo.getMilestones() ) );

        return treatmentDTO;
    }

    @Override
    public Treatment toBo(TreatmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Treatment treatment = new Treatment();

        treatment.setId( dto.getId() );
        treatment.setName( dto.getName() );
        treatment.setMilestones( milestoneDTOListToMilestoneList( dto.getMilestones() ) );

        return treatment;
    }

    @Override
    public Treatment fillBo(TreatmentDTO dto, Treatment bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );
        if ( bo.getMilestones() != null ) {
            List<Milestone> list = milestoneDTOListToMilestoneList( dto.getMilestones() );
            if ( list != null ) {
                bo.getMilestones().clear();
                bo.getMilestones().addAll( list );
            }
            else {
                bo.setMilestones( null );
            }
        }
        else {
            List<Milestone> list = milestoneDTOListToMilestoneList( dto.getMilestones() );
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
        milestoneDTO.setTreatment( toDto( milestone.getTreatment() ) );

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

    protected Milestone milestoneDTOToMilestone(MilestoneDTO milestoneDTO) {
        if ( milestoneDTO == null ) {
            return null;
        }

        Milestone milestone = new Milestone();

        milestone.setId( milestoneDTO.getId() );
        milestone.setName( milestoneDTO.getName() );
        milestone.setTreatment( toBo( milestoneDTO.getTreatment() ) );

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
}
