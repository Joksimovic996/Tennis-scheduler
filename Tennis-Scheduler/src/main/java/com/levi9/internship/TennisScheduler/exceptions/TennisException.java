package com.levi9.internship.tennisscheduler.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TennisException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;

    public TennisException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
