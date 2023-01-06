package com.flexcub.common.exception;

import org.springframework.http.HttpStatus;

import com.flexcub.common.message.MessageCode;

/**
 * Exception thrown when a result or entity was not found in a REST operation.
 */
public class NotFoundException extends CustomException {

    private static final long serialVersionUID = -213926961313510255L;

    public NotFoundException(final MessageCode messageCode) {
        super(HttpStatus.NOT_FOUND, messageCode);
    }

}
