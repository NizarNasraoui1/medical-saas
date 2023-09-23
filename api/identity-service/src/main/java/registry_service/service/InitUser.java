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
import java.util.UUID;

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
        Role superAdmin = new Role();
        superAdmin.setName("SUPER_ADMIN");
        roles.add(superAdmin);
        Role centerAdmin = new Role();
        centerAdmin.setName("CENTER_ADMIN");
        roles.add(centerAdmin);
        Role doctor = new Role();
        doctor.setName("DOCTOR");
        roles.add(doctor);
        Role secretary = new Role();
        secretary.setName("SECRETARY");
        roles.add(secretary);
        Role adminDoctor = new Role();
        adminDoctor.setName("ADMIN_DOCTOR");
        roles.add(adminDoctor);
        roleRepository.saveAll(roles);

    }

    public void initAdmin(){
        User user= new User();
        user.setEmail("admin");
        user.setName("admin");
        user.setUuid(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode("admin"));
        Role admin = roleRepository.findByName("SUPER_ADMIN").orElseThrow(()-> new EntityNotFoundException());
        user.setRole(admin);
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
