package com.uniovi.sdimywallapop.controllers;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.Message;
import com.uniovi.sdimywallapop.entities.Offer;
import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.services.ConversationService;
import com.uniovi.sdimywallapop.services.OffersService;
import com.uniovi.sdimywallapop.services.UsersService;
import com.uniovi.sdimywallapop.validators.MessageValidator;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private OffersService offersService;

    @Autowired
    private MessageValidator messageValidator;

    @RequestMapping(value = "/conversation/start/{id}", method = RequestMethod.GET)
    public String startConversation(Model model, @PathVariable Long id, Principal principal) {
        model.addAttribute("formState", 0);
        String email = principal.getName();
        Offer offer = offersService.searchById(id);
        User buyer = usersService.getUserByEmail(email);
        User seller = offer.getUser();

        if (buyer.getEmail().equals(seller.getEmail()))
            return "redirect:/offer/list";

        Conversation conversation = conversationService.searchByBuyerAndOffer(email, id);
        if (conversation == null) {
            conversation = new Conversation(seller, buyer, offer);
        }

        model.addAttribute("conversation", conversation);
        model.addAttribute("tableMessages", conversation.getMessages());

        model.addAttribute("buyer", buyer);
        model.addAttribute("seller", seller);
        model.addAttribute("offer", offer);

        model.addAttribute("message", new Message());

        return "conversation/conversation";
    }

    @RequestMapping(value = "/conversation/resume/{id}", method = RequestMethod.GET)
    public String resumeConversation(Model model, @PathVariable Long id, Principal principal){
        model.addAttribute("formState", 1);
        Conversation conversation = conversationService.searchById(id);
        User buyer = conversation.getBuyer();
        User seller = conversation.getSeller();
        Offer offer = conversation.getOffer();

        model.addAttribute("conversation", conversation);
        model.addAttribute("tableMessages", conversation.getMessages());

        model.addAttribute("buyer", buyer);
        model.addAttribute("seller", seller);
        model.addAttribute("offer", offer);

        model.addAttribute("message", new Message());

        return "conversation/conversation";
    }

    @RequestMapping(value = "/conversation/start/{id}", method = RequestMethod.POST)
    public String sendMessage(Model model, @ModelAttribute @Validated Message message, @PathVariable Long id, Principal principal, BindingResult result) {
        messageValidator.validate(message, result);
        String email = principal.getName();
        Offer offer = offersService.searchById(id);
        User seller = offer.getUser();
        User buyer = usersService.getUserByEmail(email);
        Conversation conversation = conversationService.searchByUserAndOffer(buyer, offer);
        if (result.hasErrors()) {
            if (conversation != null)
                model.addAttribute("tableMessages", conversation.getMessages());
            else
                model.addAttribute("tableMessages", new ArrayList<Message>());

            model.addAttribute("offer", offer);
            return "conversation/conversation";
        }
        if (conversation == null) {
            conversation = new Conversation(seller, buyer, offer);
            conversationService.addConversation(conversation);
        }
        message.setUser(buyer);
        message.setConversation(conversation);
        conversationService.addMessage(message);
        model.addAttribute("conversation", conversation);
        model.addAttribute("tableMessages", conversation.getMessages());
        return "redirect:/conversation/start/" + id;
    }

    @RequestMapping(value = "/conversation/resume/{id}", method = RequestMethod.POST)
    public String sendMessageResume(Model model, @ModelAttribute @Validated Message message, @PathVariable Long id, Principal principal, BindingResult result) {
        messageValidator.validate(message, result);
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Conversation conversation = conversationService.searchById(id);
        Offer offer = conversation.getOffer();
        if (result.hasErrors()) {
            model.addAttribute("conversation", conversation);
            model.addAttribute("tableMessages", conversation.getMessages());
            model.addAttribute("offer", conversation.getOffer());
            return "conversation/conversation";
        }
        message.setUser(user);
        message.setConversation(conversation);
        message.setDate(LocalDateTime.now());
        conversationService.addMessage(message);
        return "redirect:/conversation/resume/" + id;
    }

    @RequestMapping("/conversation/list")
    public String getList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Page<Conversation> conversations = conversationService.searchConversationsTakingPartBy(pageable, user);

        model.addAttribute("conversationList", conversations.getContent());
        model.addAttribute("page", conversations);
        model.addAttribute("user", user);

        return "conversation/list";
    }

    @RequestMapping("/conversation/remove/{id}")
    public String deleteConversation(@PathVariable Long id, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        List<Long> conversations = conversationService.searchConversationsTakingPartBy(user);
        if (conversations.contains(id))
            conversationService.deleteConversation(id);
        return "redirect:/conversation/list";
    }

    @RequestMapping("/conversation/list/update")
    public String updateList(Model model, Pageable pageable) {
        Page<Conversation> conversations = conversationService.getConversations(pageable);
        model.addAttribute("conversationList", conversations.getContent());
        return "conversation/list :: tableConversations";
    }

    @RequestMapping(value = "/conversation/start/update/{id}")
    public String getList(Model model,  @PathVariable Long id, Principal principal){
        Conversation conversation = conversationService.searchById(id);
        if (conversation != null)
            model.addAttribute("tableMessages", conversation.getMessages());
        else
            model.addAttribute("tableMessages", new ArrayList<Message>());
        return "conversation/conversation :: tableMessages";
    }
}
