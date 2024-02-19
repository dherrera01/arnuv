package com.core.arnuv.configuration;

import com.core.arnuv.response.RestErrorResponse;
import com.core.arnuv.utils.ArnuvNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArnuvNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    RestErrorResponse handleCustomerNotFoundException( ArnuvNotFoundException ex) {
        return new RestErrorResponse( HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    // Handle any other exception too.
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    RestErrorResponse handleException(Exception ex) {
        return new RestErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
