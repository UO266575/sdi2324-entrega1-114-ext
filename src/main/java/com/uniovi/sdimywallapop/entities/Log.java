package com.uniovi.sdimywallapop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private Date date;
    private String description;

    public Log(String type, Date date, String description){
        this.type = type;
        this.date = date;
        this.description = description;
    }

    public Log() {

    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
