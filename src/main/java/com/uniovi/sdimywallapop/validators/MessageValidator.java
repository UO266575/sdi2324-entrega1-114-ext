package com.uniovi.sdimywallapop.validators;

import com.uniovi.sdimywallapop.entities.Message;
import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Message.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Message message = (Message) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "Error.message.text");
    }
}
