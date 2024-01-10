package com.uniovi.sdimywallapop.services;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.Message;
import com.uniovi.sdimywallapop.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.uniovi.sdimywallapop.entities.User;

@Service
public class InsertSampleDataService {

    @Autowired
    private UsersService usersService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private ConversationService conversationService;
    @PostConstruct
    public void init() {
        User user1 = new User("Pedro", "Díaz", "user01@email.com");
        user1.setPassword("user01");
        user1.setRole(rolesService.getRoles()[0]);
        User user2 = new User("Lucas", "Núñez", "user02@email.com");
        user2.setPassword("user01");
        user2.setRole(rolesService.getRoles()[0]);
        User user3 = new User("María", "Rodríguez", "user03@email.com");
        user3.setPassword("user01");
        user3.setRole(rolesService.getRoles()[0]);
        User user4 = new User("Miguel", "Castillo", "user04@email.com");
        user4.setPassword("user01");
        user4.setRole(rolesService.getRoles()[0]);
        User user5 = new User("Marco", "Fernández", "user05@email.com");
        user5.setPassword("user01");
        user5.setRole(rolesService.getRoles()[0]);
        User user6 = new User("Mario", "García", "user06@email.com");
        user6.setPassword("user01");
        user6.setRole(rolesService.getRoles()[0]);
        User user7 = new User("Carlos", "Gonzalez", "user07@email.com");
        user7.setPassword("user01");
        user7.setRole(rolesService.getRoles()[0]);
        User user8 = new User("Marta", "Castaño", "user08@email.com");
        user8.setPassword("user01");
        user8.setRole(rolesService.getRoles()[0]);
        User user9 = new User("Carolina", "Martínez", "user09@email.com");
        user9.setPassword("user01");
        user9.setRole(rolesService.getRoles()[0]);
        User user10 = new User("Marcos", "Valín", "user10@email.com");
        user10.setPassword("user01");
        user10.setRole(rolesService.getRoles()[0]);
        User user11 = new User("Sergio", "Azaustre", "user11@email.com");
        user11.setPassword("user01");
        user11.setRole(rolesService.getRoles()[0]);
        User user12 = new User("Raúl", "Medina", "user12@email.com");
        user12.setPassword("user01");
        user12.setRole(rolesService.getRoles()[0]);
        User user13 = new User("Javier", "Navarro", "user13@email.com");
        user13.setPassword("user01");
        user13.setRole(rolesService.getRoles()[0]);
        User user14 = new User("Martín", "Coya", "user14@email.com");
        user14.setPassword("user01");
        user14.setRole(rolesService.getRoles()[0]);
        User user15 = new User("Daniel", "Abajo", "user15@email.com");
        user15.setPassword("user01");
        user15.setRole(rolesService.getRoles()[0]);
        User user16 = new User("Pelayo", "Valdes", "admin@email.com");
        user16.setPassword("admin");
        user16.setRole(rolesService.getRoles()[1]);

        Set user1Offers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 1", "Texto1", "Detalles1", 14, user1));
                add(new Offer("Oferta 2", "Texto2", "Detalles2", 100, user1));
                add(new Offer("Oferta 3", "Texto3", "Detalles3", 14, user1));
                add(new Offer("Oferta 4", "Texto4", "Detalles4", 14, user1));
                add(new Offer("Oferta 5", "Texto5", "Detalles5", 14, user1));
                add(new Offer("Oferta 6", "Texto6", "Detalles6", 14, user1));
                add(new Offer("Oferta 7", "Texto7", "Detalles7", 14, user1));
                add(new Offer("Oferta 8", "Texto8", "Detalles8", 14, user1));
                add(new Offer("Oferta 9", "Texto9", "Detalles9", 14, user1));
                add(new Offer("Oferta 10", "Texto10", "Detalles10", 14, user1));
            }
        };
        Set user11ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 11", "Texto1", "Detalles1", 24, user2));
                add(new Offer("Oferta 12", "Texto2", "Detalles2", 100, user2));
                add(new Offer("Oferta 13", "Texto3", "Detalles3", 200, user2));
                add(new Offer("Oferta 14", "Texto4", "Detalles4", 14, user2));
                add(new Offer("Oferta 15", "Texto5", "Detalles5", 14, user2));
                add(new Offer("Oferta 16", "Texto6", "Detalles6", 14, user2));
                add(new Offer("Oferta 17", "Texto7", "Detalles7", 14, user2));
                add(new Offer("Oferta 18", "Texto8", "Detalles8", 14, user2));
                add(new Offer("Oferta 19", "Texto9", "Detalles9", 14, user2));
                add(new Offer("Oferta 20", "Texto10", "Detalles10", 14, user2));
            }
        };

        Set user12ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 21", "Texto1", "Detalles1", 24, user3));
                add(new Offer("Oferta 22", "Texto2", "Detalles2", 100, user3));
                add(new Offer("Oferta 23", "Texto3", "Detalles3", 200, user3));
                add(new Offer("Oferta 24", "Texto4", "Detalles4", 14, user3));
                add(new Offer("Oferta 25", "Texto5", "Detalles5", 14, user3));
                add(new Offer("Oferta 26", "Texto6", "Detalles6", 14, user3));
                add(new Offer("Oferta 27", "Texto7", "Detalles7", 14, user3));
                add(new Offer("Oferta 28", "Texto8", "Detalles8", 14, user3));
                add(new Offer("Oferta 29", "Texto9", "Detalles9", 14, user3));
                add(new Offer("Oferta 30", "Texto10", "Detalles10", 14, user3));
            }
        };

        Set user13ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 31", "Texto1", "Detalles1", 24, user4));
                add(new Offer("Oferta 32", "Texto2", "Detalles2", 100, user4));
                add(new Offer("Oferta 33", "Texto3", "Detalles3", 200, user4));
                add(new Offer("Oferta 34", "Texto4", "Detalles4", 14, user4));
                add(new Offer("Oferta 35", "Texto5", "Detalles5", 14, user4));
                add(new Offer("Oferta 36", "Texto6", "Detalles6", 14, user4));
                add(new Offer("Oferta 37", "Texto7", "Detalles7", 14, user4));
                add(new Offer("Oferta 38", "Texto8", "Detalles8", 14, user4));
                add(new Offer("Oferta 39", "Texto9", "Detalles9", 14, user4));
                add(new Offer("Oferta 40", "Texto10", "Detalles10", 14, user4));
            }
        };

        Set user14ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 41", "Texto1", "Detalles1", 24, user5));
                add(new Offer("Oferta 42", "Texto2", "Detalles2", 100, user5));
                add(new Offer("Oferta 43", "Texto3", "Detalles3", 200, user5));
                add(new Offer("Oferta 44", "Texto4", "Detalles4", 14, user5));
                add(new Offer("Oferta 45", "Texto5", "Detalles5", 14, user5));
                add(new Offer("Oferta 46", "Texto6", "Detalles6", 14, user5));
                add(new Offer("Oferta 47", "Texto7", "Detalles7", 14, user5));
                add(new Offer("Oferta 48", "Texto8", "Detalles8", 14, user5));
                add(new Offer("Oferta 49", "Texto9", "Detalles9", 14, user5));
                add(new Offer("Oferta 50", "Texto10", "Detalles10", 14, user5));
            }
        };

        Set user15ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 51", "Texto1", "Detalles1", 24, user6));
                add(new Offer("Oferta 52", "Texto2", "Detalles2", 100, user6));
                add(new Offer("Oferta 53", "Texto3", "Detalles3", 200, user6));
                add(new Offer("Oferta 54", "Texto4", "Detalles4", 14, user6));
                add(new Offer("Oferta 55", "Texto5", "Detalles5", 14, user6));
                add(new Offer("Oferta 56", "Texto6", "Detalles6", 14, user6));
                add(new Offer("Oferta 57", "Texto7", "Detalles7", 14, user6));
                add(new Offer("Oferta 58", "Texto8", "Detalles8", 14, user6));
                add(new Offer("Oferta 59", "Texto9", "Detalles9", 14, user6));
                add(new Offer("Oferta 60", "Texto10", "Detalles10", 14, user6));
            }
        };

        Set user16ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 61", "Texto1", "Detalles1", 24, user7));
                add(new Offer("Oferta 62", "Texto2", "Detalles2", 100, user7));
                add(new Offer("Oferta 63", "Texto3", "Detalles3", 200, user7));
                add(new Offer("Oferta 64", "Texto4", "Detalles4", 14, user7));
                add(new Offer("Oferta 65", "Texto5", "Detalles5", 14, user7));
                add(new Offer("Oferta 66", "Texto6", "Detalles6", 14, user7));
                add(new Offer("Oferta 67", "Texto7", "Detalles7", 14, user7));
                add(new Offer("Oferta 68", "Texto8", "Detalles8", 14, user7));
                add(new Offer("Oferta 69", "Texto9", "Detalles9", 14, user7));
                add(new Offer("Oferta 70", "Texto10", "Detalles10", 14, user7));
            }
        };

        Set user17ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 71", "Texto1", "Detalles1", 24, user8));
                add(new Offer("Oferta 72", "Texto2", "Detalles2", 100, user8));
                add(new Offer("Oferta 73", "Texto3", "Detalles3", 200, user8));
                add(new Offer("Oferta 74", "Texto4", "Detalles4", 14, user8));
                add(new Offer("Oferta 75", "Texto5", "Detalles5", 14, user8));
                add(new Offer("Oferta 76", "Texto6", "Detalles6", 14, user8));
                add(new Offer("Oferta 77", "Texto7", "Detalles7", 14, user8));
                add(new Offer("Oferta 78", "Texto8", "Detalles8", 14, user8));
                add(new Offer("Oferta 79", "Texto9", "Detalles9", 14, user8));
                add(new Offer("Oferta 80", "Texto10", "Detalles10", 14, user8));
            }
        };

        Set user18ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 81", "Texto1", "Detalles1", 24, user9));
                add(new Offer("Oferta 82", "Texto2", "Detalles2", 100, user9));
                add(new Offer("Oferta 83", "Texto3", "Detalles3", 200, user9));
                add(new Offer("Oferta 84", "Texto4", "Detalles4", 14, user9));
                add(new Offer("Oferta 85", "Texto5", "Detalles5", 14, user9));
                add(new Offer("Oferta 86", "Texto6", "Detalles6", 14, user9));
                add(new Offer("Oferta 87", "Texto7", "Detalles7", 14, user9));
                add(new Offer("Oferta 88", "Texto8", "Detalles8", 14, user9));
                add(new Offer("Oferta 89", "Texto9", "Detalles9", 14, user9));
                add(new Offer("Oferta 90", "Texto10", "Detalles10", 14, user9));
            }
        };

        Set user19ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 91", "Texto1", "Detalles1", 24, user10));
                add(new Offer("Oferta 92", "Texto2", "Detalles2", 100, user10));
                add(new Offer("Oferta 93", "Texto3", "Detalles3", 200, user10));
                add(new Offer("Oferta 94", "Texto4", "Detalles4", 14, user10));
                add(new Offer("Oferta 95", "Texto5", "Detalles5", 14, user10));
                add(new Offer("Oferta 96", "Texto6", "Detalles6", 14, user10));
                add(new Offer("Oferta 97", "Texto7", "Detalles7", 14, user10));
                add(new Offer("Oferta 98", "Texto8", "Detalles8", 14, user10));
                add(new Offer("Oferta 99", "Texto9", "Detalles9", 14, user10));
                add(new Offer("Oferta 100", "Texto10", "Detalles10", 14, user10));
            }
        };

        Set user20ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 101", "Texto1", "Detalles1", 24, user11));
                add(new Offer("Oferta 102", "Texto2", "Detalles2", 100, user11));
                add(new Offer("Oferta 103", "Texto3", "Detalles3", 200, user11));
                add(new Offer("Oferta 104", "Texto4", "Detalles4", 14, user11));
                add(new Offer("Oferta 105", "Texto5", "Detalles5", 14, user11));
                add(new Offer("Oferta 106", "Texto6", "Detalles6", 14, user11));
                add(new Offer("Oferta 107", "Texto7", "Detalles7", 14, user11));
                add(new Offer("Oferta 108", "Texto8", "Detalles8", 14, user11));
                add(new Offer("Oferta 109", "Texto9", "Detalles9", 14, user11));
                add(new Offer("Oferta 110", "Texto10", "Detalles10", 14, user11));
            }
        };

        Set user21ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 111", "Texto1", "Detalles1", 24, user12));
                add(new Offer("Oferta 112", "Texto2", "Detalles2", 100, user12));
                add(new Offer("Oferta 113", "Texto3", "Detalles3", 200, user12));
                add(new Offer("Oferta 114", "Texto4", "Detalles4", 14, user12));
                add(new Offer("Oferta 115", "Texto5", "Detalles5", 14, user12));
                add(new Offer("Oferta 116", "Texto6", "Detalles6", 14, user12));
                add(new Offer("Oferta 117", "Texto7", "Detalles7", 14, user12));
                add(new Offer("Oferta 118", "Texto8", "Detalles8", 14, user12));
                add(new Offer("Oferta 119", "Texto9", "Detalles9", 14, user12));
                add(new Offer("Oferta 120", "Texto10", "Detalles10", 14, user12));
            }
        };

        Set user22ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 121", "Texto1", "Detalles1", 24, user13));
                add(new Offer("Oferta 122", "Texto2", "Detalles2", 100, user13));
                add(new Offer("Oferta 123", "Texto3", "Detalles3", 200, user13));
                add(new Offer("Oferta 124", "Texto4", "Detalles4", 14, user13));
                add(new Offer("Oferta 125", "Texto5", "Detalles5", 14, user13));
                add(new Offer("Oferta 126", "Texto6", "Detalles6", 14, user13));
                add(new Offer("Oferta 127", "Texto7", "Detalles7", 14, user13));
                add(new Offer("Oferta 128", "Texto8", "Detalles8", 14, user13));
                add(new Offer("Oferta 129", "Texto9", "Detalles9", 14, user13));
                add(new Offer("Oferta 130", "Texto10", "Detalles10", 14, user13));
            }
        };

        Set user23ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 131", "Texto1", "Detalles1", 24, user14));
                add(new Offer("Oferta 132", "Texto2", "Detalles2", 100, user14));
                add(new Offer("Oferta 133", "Texto3", "Detalles3", 200, user14));
                add(new Offer("Oferta 134", "Texto4", "Detalles4", 14, user14));
                add(new Offer("Oferta 135", "Texto5", "Detalles5", 14, user14));
                add(new Offer("Oferta 136", "Texto6", "Detalles6", 14, user14));
                add(new Offer("Oferta 137", "Texto7", "Detalles7", 14, user14));
                add(new Offer("Oferta 138", "Texto8", "Detalles8", 14, user14));
                add(new Offer("Oferta 139", "Texto9", "Detalles9", 14, user14));
                add(new Offer("Oferta 140", "Texto10", "Detalles10", 14, user14));
            }
        };

        Set user24ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 141", "Texto1", "Detalles1", 24, user15));
                add(new Offer("Oferta 142", "Texto2", "Detalles2", 100, user15));
                add(new Offer("Oferta 143", "Texto3", "Detalles3", 200, user15));
                add(new Offer("Oferta 144", "Texto4", "Detalles4", 14, user15));
                add(new Offer("Oferta 145", "Texto5", "Detalles5", 14, user15));
                add(new Offer("Oferta 146", "Texto6", "Detalles6", 14, user15));
                add(new Offer("Oferta 147", "Texto7", "Detalles7", 14, user15));
                add(new Offer("Oferta 148", "Texto8", "Detalles8", 14, user15));
                add(new Offer("Oferta 149", "Texto9", "Detalles9", 14, user15));
                add(new Offer("Oferta 150", "Texto10", "Detalles10", 14, user15));
            }
        };

        Set user25ffers = new HashSet<Offer>() {
            {
                add(new Offer("Oferta 151", "Texto1", "Detalles1", 24, user16));
                add(new Offer("Oferta 152", "Texto2", "Detalles2", 100, user16));
                add(new Offer("Oferta 153", "Texto3", "Detalles3", 200, user16));
                add(new Offer("Oferta 154", "Texto4", "Detalles4", 14, user16));
                add(new Offer("Oferta 155", "Texto5", "Detalles5", 14, user16));
                add(new Offer("Oferta 156", "Texto6", "Detalles6", 14, user16));
                add(new Offer("Oferta 157", "Texto7", "Detalles7", 14, user16));
                add(new Offer("Oferta 158", "Texto8", "Detalles8", 14, user16));
                add(new Offer("Oferta 159", "Texto9", "Detalles9", 14, user16));
                add(new Offer("Oferta 160", "Texto10", "Detalles10", 14, user16));
            }
        };

        user1.setOffers(user1Offers);
        user2.setOffers(user11ffers);
        user3.setOffers(user12ffers);
        user4.setOffers(user13ffers);
        user5.setOffers(user14ffers);
        user6.setOffers(user15ffers);
        user7.setOffers(user16ffers);
        user8.setOffers(user17ffers);
        user9.setOffers(user18ffers);
        user10.setOffers(user19ffers);
        user11.setOffers(user20ffers);
        user12.setOffers(user21ffers);
        user13.setOffers(user22ffers);
        user14.setOffers(user23ffers);
        user15.setOffers(user24ffers);
        user16.setOffers(user25ffers);

        usersService.addUser(user1);
        usersService.addUser(user2);
        usersService.addUser(user3);
        usersService.addUser(user4);
        usersService.addUser(user5);
        usersService.addUser(user6);
        usersService.addUser(user7);
        usersService.addUser(user8);
        usersService.addUser(user9);
        usersService.addUser(user10);
        usersService.addUser(user11);
        usersService.addUser(user12);
        usersService.addUser(user13);
        usersService.addUser(user14);
        usersService.addUser(user15);
        usersService.addUser(user16);

        //Conversation conversation = new Conversation(user2, user1, new Offer("Oferta 8", "Texto8", "Detalles8", 24, user2));
        //conversationService.addConversation(conversation);
        //Message message1 = new Message("esto es un mensaje de prueba", user1, conversation);
        //Message message2 = new Message("si se ve esto significa que todo es correcto", user1, conversation);
        //Message message3 = new Message("lo que el comprador ha dicho", user2, conversation);
        //conversationService.addMessage(message1);
        //conversationService.addMessage(message2);
        //conversationService.addMessage(message3);
    }
}
