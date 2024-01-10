package com.uniovi.sdimywallapop.repositories;

import com.uniovi.sdimywallapop.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE "
            + "u.role != 'ROLE_ADMIN'")
    List<User> findAllActive();

}
