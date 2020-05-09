package com.epam.ukolpakova;

import com.epam.ukolpakova.beans.Client;
import com.epam.ukolpakova.beans.Event;
import com.epam.ukolpakova.loggers.EventLogger;
import lombok.AllArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@AllArgsConstructor
public class App {
    private Client client;
    private EventLogger eventLogger;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        for (int i = 0; i < 8; i++) {
            Event event = ctx.getBean("event", Event.class);
            event.setMsg("New event_" + i);
            app.logEvent(event);
        }
        ctx.close();
    }

    private void logEvent(Event event) throws IOException {
        eventLogger.logEvent(event);
    }
}
