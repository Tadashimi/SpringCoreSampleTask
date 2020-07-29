package com.epam.ukolpakova.xmlconfigspring.loggers;

import com.epam.ukolpakova.xmlconfigspring.beans.Event;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
