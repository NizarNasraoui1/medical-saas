package registry_service.service;

import jakarta.persistence.EntityNotFoundException;
import registry_service.entity.Role;
import registry_service.entity.User;
import registry_service.repository.RoleRepository;
import registry_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitUser implements CommandLineRunner {

    @Autowired
    UserRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public boolean adminExists(){
        User admin= userCredentialRepository.findByName("admin").orElse(null);
        return admin!=null;
    }

    public boolean rolesExits(){
        return !(roleRepository.findAll().size() ==0);
    }

    public void initRoles(){
        List<Role> roles = new ArrayList<>();
        Role admin = new Role();
        admin.setName("ADMIN");
        roles.add(admin);
        Role doctor = new Role();
        doctor.setName("DOCTOR");
        roles.add(doctor);
        Role secretary = new Role();
        secretary.setName("SECRETARY");
        roles.add(secretary);
        roleRepository.saveAll(roles);

    }

    public void initAdmin(){
        User user= new User();
        user.setEmail("admin");
        user.setName("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        Role admin = roleRepository.findByName("ADMIN").orElseThrow(()-> new EntityNotFoundException());
        user.getRoles().add(admin);
        userCredentialRepository.save(user);

    }

    @Override
    public void run(String... args) throws Exception {
        if(!rolesExits()){
            initRoles();
        }
        if(!adminExists()){
            this.initAdmin();
        }
    }
}
