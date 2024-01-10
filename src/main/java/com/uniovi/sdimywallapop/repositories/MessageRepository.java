package com.uniovi.sdimywallapop.repositories;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.Message;
import com.uniovi.sdimywallapop.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Page<Conversation> findAll(Pageable pageable);

    @Query("Select m from Message m where m.conversation.id = ?1")
    List<Message> findMessages(Long id);
}
