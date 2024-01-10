package com.uniovi.sdimywallapop.services;

import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.repositories.OffersRepository;
import com.uniovi.sdimywallapop.validators.OfferBuyValidator;
import com.uniovi.sdimywallapop.validators.OfferHighlightValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.uniovi.sdimywallapop.validators.OfferDeleteValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class OffersService {

    @Autowired
    private OffersRepository offersRepository;

    public List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<Offer>();
        offersRepository.findAll().forEach(offers::add);
        return offers;
    }

    public Page<Offer> getOffers(Pageable pageable) {
        Page<Offer> offers = offersRepository.findAll(pageable);
        return offers;
    }

    public Offer getOffer(Long id) {
        return offersRepository.findById(id).get();
    }

    public void addOffer(Offer offer) {
        offersRepository.save(offer);
    }

    public void deleteOffer(Long id) {
        offersRepository.deleteById(id);
    }

    public Page<Offer> getOffersForUser(Pageable pageable, User user) {
        Page<Offer> offers = new PageImpl<Offer>(new LinkedList<Offer>());
        if(user != null){
            offers = offersRepository.findAllHighlightOfferByUser(pageable, user.getId());
        }
        return offers;
    }

    public Page<Offer> searchOffersByTitle(Pageable pageable, String searchText) {
        searchText = "%"+searchText+"%";
        Page<Offer> offers = offersRepository.searchByTitle(pageable, searchText);
        return offers;
    }

    public void soldOffer(Offer offer, User user) {
        offer.setSold(true);
        offer.setComprador(user.getId());
        offer.setEmailComprador(user.getEmail());
        addOffer(offer);
    }

    public Offer searchById(Long id) {
        return offersRepository.findById(id).get();
    }

    public List<Offer> getOffersByUserId(Long id) {
        return offersRepository.findAllByComprador(id);
    }

    public Page<Offer> getOffersByUserId(User user, Pageable pageable) {
        return offersRepository.findAllByUser(pageable, user);
    }

    public List<String> validateOffer(Offer offer, User user) {
        return new OfferBuyValidator().validate(offer, user);
    }

    public List<String> validateOfferHighlight(Offer offer, User user){
        return new OfferHighlightValidator().validate(offer, user);
    }

    public List<Long> getOffersIdsByUserId(Long id){
        return offersRepository.findAllByUserID(id);
    }

    public void toHighlightOffer(Offer offer){
        offer.setDestacado(true);
        offersRepository.save(offer);
    }

    public List<String> validateOfferToDelete(Offer offer, User user) {
        return new OfferDeleteValidator().validate(offer, user);
    }

}
