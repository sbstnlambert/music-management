package be.technifutur.musicManagement.business.mapper;

import be.technifutur.musicManagement.model.dto.UserDTO;
import be.technifutur.musicManagement.model.entity.User;
import be.technifutur.musicManagement.model.form.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {

    private final PasswordEncoder encoder;

    public UserDTO entityToDTO(User entity) {
        if (entity == null)
            return null;

        return UserDTO.builder()
                .username(entity.getUsername())
                .build();
    }

    public User formToEntity(UserForm form) {
        if (form == null)
            return null;

        return User.builder()
                .username(form.getUsername())
                .password(this.encoder.encode(form.getPassword()))
                .email(form.getEmail())
                .isNotLocked(true)
                .build();
    }

}
