package com.uniovi.sdimywallapop.validators;

import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
    @Autowired
    private UsersService usersService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getEmail().length() < 5 || user.getEmail().length() > 24) {
            errors.rejectValue("username", "Error.signup.email.length");
        }
        if (usersService.getUserByEmail(user.getEmail()) == null) {
            errors.rejectValue("username", "Error.signup.email.null");
        }
        if (user.getPassword().length() < 5
                || user.getPassword().length() > 24) {
            errors.rejectValue("password", "Error.signup.password.length");
        }
    }
}
