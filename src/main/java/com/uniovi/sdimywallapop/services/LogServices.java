package com.uniovi.sdimywallapop.services;

import com.uniovi.sdimywallapop.entities.Log;
import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogServices {

    @Autowired
    private LogRepository logRepository;

    @PostConstruct
    public void init() {

    }

    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<Log>();
        logRepository.findAllOrderByDate().forEach(logs::add);
        return logs;
    }


    public void addLog(Log log) {
        logRepository.save(log);
    }

    public List<Log> getPetLogs(String tipo) {
        List<Log> logs = new ArrayList<Log>();
        logRepository.findAllLogByParameter(tipo).forEach(logs::add);
        return logs;
    }

    public void deleteLogs(){
        logRepository.deleteAll();
    }

}
