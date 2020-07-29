package com.epam.ukolpakova.xmlconfigspring.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class Event {
    private int id;
    private Date date;
    private DateFormat df;

    @Getter
    @Setter
    private String msg;
    private final static Random RANDOM = new Random();

    public Event(Date date, DateFormat df) {
        id = RANDOM.nextInt(1000);
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
