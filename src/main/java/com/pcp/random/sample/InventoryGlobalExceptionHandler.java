package com.pcp.random.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class InventoryGlobalExceptionHandler {

    @ExceptionHandler(value = {CreateTheatreException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(CreateTheatreException createTheatreException) {
        log.error(createTheatreException.getMessage(), createTheatreException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(createTheatreException.getMessage())
                .build();
    }
}
