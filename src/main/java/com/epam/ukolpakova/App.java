package com.epam.ukolpakova;

import com.epam.ukolpakova.beans.Client;
import com.epam.ukolpakova.beans.Event;
import com.epam.ukolpakova.enums.EventType;
import com.epam.ukolpakova.loggers.EventLogger;
import lombok.AllArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
public class App {
    private Client client;
    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> eventLoggers;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        printGreeting(app.client);
        for (int i = 0; i < 8; i++) {
            Event event = ctx.getBean("event", Event.class);
            event.setMsg("New event_" + i);
            EventType eventType;
            switch (i % 3) {
                case 0:
                    eventType = EventType.INFO;
                    break;
                case 1:
                    eventType = EventType.ERROR;
                    break;
                default:
                    eventType = null;
            }
            app.logEvent(event, eventType);
        }
        ctx.close();
    }

    private static void printGreeting(Client client) {
        System.out.println("\nGREETING, MASTER!");
        System.out.println("You are: " + client);
        System.out.println("------------------\n");
    }

    private void logEvent(Event event, EventType eventType) throws IOException {
        EventLogger eventLogger = eventLoggers.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultEventLogger;
        }
        eventLogger.logEvent(event);
    }
}
