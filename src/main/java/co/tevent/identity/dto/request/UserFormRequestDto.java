package co.tevent.identity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFormRequestDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
//    private MultipartFile file;
}
