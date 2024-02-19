package com.core.arnuv.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ArnuvNotFoundException extends RuntimeException {
    public ArnuvNotFoundException(String message, Object... parametros) {
        super(MessageFormat.format(message,parametros));
    }
}
