package registry_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import registry_service.entity.Center;
import registry_service.service.CenterService;

@RestController
@RequestMapping("/auth/center")
public class CenterResource {
    @Autowired
    CenterService centerService;

    @PostMapping
    public String addCenter(@RequestBody Center center){
        return centerService.addCenter(center);
    }

}
