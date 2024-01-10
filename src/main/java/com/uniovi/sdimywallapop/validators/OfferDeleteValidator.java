package com.uniovi.sdimywallapop.validators;

import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;

import java.util.ArrayList;
import java.util.List;

public class OfferDeleteValidator {
    public List<String> validate(Offer offer, User user) {
        List<String> errores = new ArrayList<>();
        if (offer.getUser().getId() != user.getId()) {
            errores.add("Error.offer.delete.user");
        }
        return errores;
    }
}
