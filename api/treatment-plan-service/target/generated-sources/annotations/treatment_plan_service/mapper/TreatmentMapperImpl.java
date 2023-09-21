package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Treatment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T01:01:21+0200",
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

        return treatment;
    }

    @Override
    public Treatment fillBo(TreatmentDTO dto, Treatment bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );

        return bo;
    }
}
