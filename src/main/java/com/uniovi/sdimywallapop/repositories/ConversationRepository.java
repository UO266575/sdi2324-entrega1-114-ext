package com.uniovi.sdimywallapop.repositories;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {

    List<Conversation> findAllBySeller(User user);
    Page<Conversation> findAll(Pageable pageable);

    @Query("Select c from Conversation c where c.buyer.email LIKE ?1 and c.offer.id = ?2")
    Conversation findByBuyerAndOffer(String buyerDni, Long id);

    @Query("Select c from Conversation c where c.buyer.email LIKE ?1 and c.offer.id = ?2")
    Conversation findByUserAndOffer(String dni, Long id);

    @Query("Select c from Conversation c where c.buyer.email LIKE ?1 or c.seller.email LIKE ?1")
    Page<Conversation> findConversationsByUser(Pageable pageable, String dni);

    @Query("Select c.id from Conversation c where c.buyer.email LIKE ?1 or c.seller.email LIKE ?1")
    List<Long> findConversationsByUser(String email);
}
