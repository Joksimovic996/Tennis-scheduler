package com.levi9.internship.TennisScheduler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TennisException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;


}
