package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-20T17:09:31+0200",
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

        return bo;
    }
}
