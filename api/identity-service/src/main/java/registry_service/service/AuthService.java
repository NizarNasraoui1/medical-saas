package registry_service.service;

import jakarta.persistence.EntityNotFoundException;
import registry_service.dto.RegisterRequest;
import registry_service.entity.Center;
import registry_service.entity.Role;
import registry_service.entity.User;
import registry_service.exception.LoginAlreadyExistsException;
import registry_service.repository.CenterRepository;
import registry_service.repository.RoleRepository;
import registry_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CenterRepository centerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(RegisterRequest registerRequest) throws LoginAlreadyExistsException {
        User user = new User();
        if(userAlreadyExists(registerRequest.getName())){
            throw new LoginAlreadyExistsException();
        }
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setUuid(UUID.randomUUID());
        String password;
        if(!Objects.nonNull(registerRequest.getPassword()) || registerRequest.getPassword().isEmpty() || registerRequest.getPassword().isBlank()){
            password = generateRandomPassword(15);
            user.setPassword(passwordEncoder.encode(password));
        }
        else{
            password = registerRequest.getPassword();
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        }
        Center center = centerRepository.findById(registerRequest.getCenterId()).orElseThrow(()->new EntityNotFoundException());
        user.setCenter(center);
        Role role = roleRepository.findById(registerRequest.getRoleId()).orElseThrow(()->new EntityNotFoundException());
        user.getRoles().add(role);
        userRepository.save(user);
        return password;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

    public static String generateRandomPassword(int length) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, length);
    }

    public boolean userAlreadyExists(String name){
        return userRepository.existsByName(name);
    }


}
