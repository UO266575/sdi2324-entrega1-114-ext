package com.uniovi.sdimywallapop.validators;

import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OfferFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Offer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Offer offer = (Offer) target;

        if (offer.getPrice() < 0) {
            errors.rejectValue("price", "Error.offer.price.negative");
        }
        if (offer.getTitle().length() < 3 || offer.getTitle().length() > 30) {
            errors.rejectValue("title", "Error.offer.title.length");
        }
        if (offer.getDetails().length() < 3 || offer.getDetails().length() > 30) {
            errors.rejectValue("details", "Error.offer.details.length");
        }

    }

}
