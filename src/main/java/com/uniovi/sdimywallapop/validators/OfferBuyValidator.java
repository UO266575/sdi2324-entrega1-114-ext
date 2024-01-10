package com.uniovi.sdimywallapop.validators;

import com.uniovi.sdimywallapop.CustomConfiguration;
import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OfferBuyValidator {
    public List<String> validate(Offer offer, User user) {
        List<String> errores = new ArrayList<>();
        if (user.getMoney() < offer.getPrice()) {
            errores.add("Error.offer.price.minus");
        } if (offer.isSold()) {
            errores.add("Error.offer.sold");
        } if (offer.getUser().getId() == user.getId()) {
            errores.add("Error.offer.user");
        }
        return errores;
    }
}
