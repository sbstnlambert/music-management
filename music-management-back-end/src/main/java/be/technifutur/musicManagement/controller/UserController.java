package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.implementation.UserDetailsServiceImpl;
import be.technifutur.musicManagement.model.dto.UserDTO;
import be.technifutur.musicManagement.model.form.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/add")
    public UserDTO createUserAccount(@RequestBody UserForm form) {
        return this.userDetailsService.createUserAccount(form);
    }

}
