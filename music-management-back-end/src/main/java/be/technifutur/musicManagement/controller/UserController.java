package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.business.service.implementation.UserDetailsServiceImpl;
import be.technifutur.musicManagement.model.dto.UserDTO;
import be.technifutur.musicManagement.model.form.UserForm;
import be.technifutur.musicManagement.model.form.UserLogInForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    // GET - http://localhost:8080/user/roles?user
    @GetMapping("/roles")
    public List<String> getUserAccountRoles(@RequestParam(name = "user") String username) {
        return this.userDetailsService.getUserAccountRoles(username);
    }

    // POST - http://localhost:8080/user/verify
    @PostMapping("/verify")
    public Boolean verifyUserAccount(@RequestBody UserLogInForm form) {
        return this.userDetailsService.verifyUserAccount(form);
    }

    // POST - http://localhost:8080/user/add
    @PostMapping("/add")
    public UserDTO createUserAccount(@RequestBody UserForm form) {
        return this.userDetailsService.createUserAccount(form);
    }

}
