package com.uniovi.sdimywallapop.validators;

import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class OfferHighlightValidator {

    public List<String> validate(Offer offer, User user) {
        List<String> errores = new ArrayList<>();
        if (user.getMoney() < 20) {
            errores.add("Error.offer.destacado.money");
        }
        if (offer.isDestacado()) {
            errores.add("Error.offer.isHighlight");
        }
        if (offer.getUser().getId() != user.getId()) {
            errores.add("Error.offer.user.highlight");
        }
        return errores;
    }
}
