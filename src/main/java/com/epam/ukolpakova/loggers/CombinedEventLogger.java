package com.epam.ukolpakova.loggers;

import com.epam.ukolpakova.beans.Event;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class CombinedEventLogger implements EventLogger {
    List<EventLogger> loggers;

    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
