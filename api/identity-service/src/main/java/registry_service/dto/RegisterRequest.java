package registry_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import registry_service.enumeration.RoleEnum;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequest {
    private int id;
    private String name;
    private String email;
    private String password;
    private Long roleId;
    private Long centerId;
}
