package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.Milestone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T01:01:21+0200",
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

        return milestone;
    }

    @Override
    public Milestone fillBo(MilestoneDTO dto, Milestone bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );

        return bo;
    }
}
