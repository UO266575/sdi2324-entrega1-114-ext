package com.uniovi.sdimywallapop.repositories;

import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffersRepository extends CrudRepository<Offer, Long> {
    @Query("SELECT o FROM Offer o WHERE o.destacado = true or o.user.id = ?1 order by o.destacado DESC")
    Page<Offer> findAllHighlightOfferByUser(Pageable pageable, Long id);

    Page<Offer> findAll(Pageable pageable);

    Page<Offer> findAllByUser(Pageable pageable, User user);

    @Query("Select r FROM Offer r WHERE LOWER(r.title) LIKE LOWER(?1)")
    Page<Offer> searchByTitle(Pageable pageable, String searchText);

    List<Offer> findAllByComprador(Long id);

    @Query("Select r.id FROM Offer r WHERE r.user.id = ?1")
    List<Long> findAllByUserID(Long id);

}
