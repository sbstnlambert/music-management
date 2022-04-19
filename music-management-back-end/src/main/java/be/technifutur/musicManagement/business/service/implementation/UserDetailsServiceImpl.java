package be.technifutur.musicManagement.business.service.implementation;

import be.technifutur.musicManagement.business.mapper.UserMapper;
import be.technifutur.musicManagement.model.dto.UserDTO;
import be.technifutur.musicManagement.model.entity.User;
import be.technifutur.musicManagement.model.form.UserForm;
import be.technifutur.musicManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Username '%s' has not been found", username))
                );
    }

    public UserDTO createUserAccount(UserForm form) {
        User user = mapper.formToEntity(form);
        user = userRepository.save(user);
        return mapper.entityToDTO(user);
    }

}
