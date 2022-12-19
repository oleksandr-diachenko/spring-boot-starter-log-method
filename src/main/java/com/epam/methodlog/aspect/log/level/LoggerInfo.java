package com.epam.methodlog.aspect.log.level;

import com.epam.methodlog.aspect.lookup.AspectLoggerLookup;
import org.aspectj.lang.JoinPoint;

public class LoggerInfo implements Logger {

    private final AspectLoggerLookup aspectLoggerLookup;

    public LoggerInfo(AspectLoggerLookup aspectLoggerLookup) {
        this.aspectLoggerLookup = aspectLoggerLookup;
    }

    @Override
    public void log(JoinPoint jp, String message, Object... args) {
        org.slf4j.Logger logger = aspectLoggerLookup.lookup(jp);
        logger.info(message, args);
    }
}