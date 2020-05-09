package com.epam.ukolpakova;

import com.epam.ukolpakova.beans.Client;
import com.epam.ukolpakova.beans.Event;
import com.epam.ukolpakova.loggers.EventLogger;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@AllArgsConstructor
public class App {
    private Client client;
    private EventLogger eventLogger;

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");
        Event event = ctx.getBean("event", Event.class);
        event.setMsg("New event");
        app.logEvent(event);
    }

    private void logEvent(Event event) throws IOException {
        eventLogger.logEvent(event);
    }
}
