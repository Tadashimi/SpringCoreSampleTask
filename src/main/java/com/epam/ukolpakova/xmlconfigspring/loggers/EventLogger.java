package com.epam.ukolpakova.xmlconfigspring.loggers;

import com.epam.ukolpakova.xmlconfigspring.beans.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event) throws IOException;
}
