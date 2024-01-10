package com.uniovi.sdimywallapop.repositories;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogRepository extends CrudRepository<Log, Long> {

    @Query("Select l from Log l order by l.date desc")
    List<Log> findAllOrderByDate();

    @Query("Select l from Log l where l.type=?1 order by l.date desc")
    List<Log> findAllLogByParameter(String tipo);

}
