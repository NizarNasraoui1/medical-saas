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
public class MilestoneMapperImpl implements MilestoneMapper {

    @Override
    public List<MilestoneDTO> toDtos(List<Milestone> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<MilestoneDTO> list = new ArrayList<MilestoneDTO>( dtos.size() );
        for ( Milestone milestone : dtos ) {
            list.add( toDto( milestone ) );
        }

        return list;
    }

    @Override
    public List<Milestone> toBos(List<MilestoneDTO> bos) {
        if ( bos == null ) {
            return null;
        }

        List<Milestone> list = new ArrayList<Milestone>( bos.size() );
        for ( MilestoneDTO milestoneDTO : bos ) {
            list.add( toBo( milestoneDTO ) );
        }

        return list;
    }

    @Override
    public MilestoneDTO toDto(Milestone bo) {
        if ( bo == null ) {
            return null;
        }

        MilestoneDTO milestoneDTO = new MilestoneDTO();

        milestoneDTO.setId( bo.getId() );
        milestoneDTO.setName( bo.getName() );
        milestoneDTO.setTreatment( treatmentToTreatmentDTO( bo.getTreatment() ) );

        return milestoneDTO;
    }

    @Override
    public Milestone toBo(MilestoneDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Milestone milestone = new Milestone();

        milestone.setId( dto.getId() );
        milestone.setName( dto.getName() );
        milestone.setTreatment( treatmentDTOToTreatment( dto.getTreatment() ) );

        return milestone;
    }

    @Override
    public Milestone fillBo(MilestoneDTO dto, Milestone bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );
        if ( dto.getTreatment() != null ) {
            if ( bo.getTreatment() == null ) {
                bo.setTreatment( new Treatment() );
            }
            treatmentDTOToTreatment1( dto.getTreatment(), bo.getTreatment() );
        }
        else {
            bo.setTreatment( null );
        }

        return bo;
    }

    protected TreatmentDTO treatmentToTreatmentDTO(Treatment treatment) {
        if ( treatment == null ) {
            return null;
        }

        TreatmentDTO treatmentDTO = new TreatmentDTO();

        treatmentDTO.setId( treatment.getId() );
        treatmentDTO.setName( treatment.getName() );
        treatmentDTO.setMilestones( toDtos( treatment.getMilestones() ) );

        return treatmentDTO;
    }

    protected Treatment treatmentDTOToTreatment(TreatmentDTO treatmentDTO) {
        if ( treatmentDTO == null ) {
            return null;
        }

        Treatment treatment = new Treatment();

        treatment.setId( treatmentDTO.getId() );
        treatment.setName( treatmentDTO.getName() );
        treatment.setMilestones( toBos( treatmentDTO.getMilestones() ) );

        return treatment;
    }

    protected void treatmentDTOToTreatment1(TreatmentDTO treatmentDTO, Treatment mappingTarget) {
        if ( treatmentDTO == null ) {
            return;
        }

        mappingTarget.setId( treatmentDTO.getId() );
        mappingTarget.setName( treatmentDTO.getName() );
        if ( mappingTarget.getMilestones() != null ) {
            List<Milestone> list = toBos( treatmentDTO.getMilestones() );
            if ( list != null ) {
                mappingTarget.getMilestones().clear();
                mappingTarget.getMilestones().addAll( list );
            }
            else {
                mappingTarget.setMilestones( null );
            }
        }
        else {
            List<Milestone> list = toBos( treatmentDTO.getMilestones() );
            if ( list != null ) {
                mappingTarget.setMilestones( list );
            }
        }
    }
}
