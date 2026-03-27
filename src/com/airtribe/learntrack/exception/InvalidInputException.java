package com.airtribe.learntrack.exception;

import jdk.jshell.spi.ExecutionControl;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message){
        super(message);
    }
}
