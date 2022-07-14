package com.dh.clase35.exceptions;

import org.apache.log4j.Logger;

public class BadRequestException extends Exception{
    private static final Logger logger = Logger.getLogger(BadRequestException.class);
    public BadRequestException(String message) {
        super(message);
        logger.error(message);
    }
}
