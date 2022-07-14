package com.dh.clase35.exceptions;

import org.apache.log4j.Logger;

public class ResourceNotFoundException extends Exception{
    private static final Logger logger = Logger.getLogger(ResourceNotFoundException.class);
    public ResourceNotFoundException(String message) {
        super(message);
        logger.error(message);
    }
}

