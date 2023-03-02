package com.library.library.registration;

import com.library.library.user.User;
import com.library.library.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;


    public String register(User user){
        boolean isValidEmail = emailValidator.
                test(user.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String token = userService.signUpUser(user);

        return token;
    }


}
