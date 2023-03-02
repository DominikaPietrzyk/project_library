package com.library.library.registration;

import com.library.library.user.User;
import com.library.library.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserRepository userRepository;

    @PostMapping
    public String register(@RequestBody User request) {
        return registrationService.register(request);
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
