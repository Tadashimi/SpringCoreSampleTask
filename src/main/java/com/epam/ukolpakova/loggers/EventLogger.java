package com.epam.ukolpakova.loggers;

import com.epam.ukolpakova.beans.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event) throws IOException;
}
