package com.uniovi.sdimywallapop.services;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.Message;
import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.repositories.ConversationRepository;
import com.uniovi.sdimywallapop.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    public void addConversation(Conversation conversation) {
        conversationRepository.save(conversation);
    }

    public Page<Conversation> getConversations(Pageable pageable) {
        return conversationRepository.findAll(pageable);
    }

    public Conversation searchById(Long id) {
        return conversationRepository.findById(id).get();
    }

    public void deleteConversation(Long id) {
        conversationRepository.deleteById(id);
    }

    public Conversation searchByBuyerAndOffer(String buyerEmail, Long id) {
        return conversationRepository.findByBuyerAndOffer(buyerEmail, id);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> findMessages(Long id) {
        return messageRepository.findMessages(id);
    }

    public Conversation searchByUserAndOffer(User user, Offer offer){
        return conversationRepository.findByUserAndOffer(user.getEmail(), offer.getId());
    }

    public Page<Conversation> searchConversationsTakingPartBy(Pageable pageable, User user) {
        return conversationRepository.findConversationsByUser(pageable, user.getEmail());
    }

    public List<Long> searchConversationsTakingPartBy(User user) {
        return conversationRepository.findConversationsByUser(user.getEmail());
    }
}
