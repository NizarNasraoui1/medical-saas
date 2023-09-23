package registry_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import registry_service.entity.Center;
import registry_service.repository.CenterRepository;

import java.util.UUID;

@Service
public class CenterService {
    @Autowired
    CenterRepository centerRepository;
    public String addCenter(Center center){
        center.setUuid(UUID.randomUUID());
        centerRepository.save(center);
        return "center added successfully";
    }
}
