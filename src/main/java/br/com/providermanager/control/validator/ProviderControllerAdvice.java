package br.com.providermanager.control.validator;

import br.com.providermanager.exception.northbound.provider.ProviderInvalidException;
import br.com.providermanager.exception.southbound.provider.ProviderNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProviderControllerAdvice {
    private static final Logger LOG = LogManager.getLogger(ProviderControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(ProviderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ProviderNotFoundExceptionHandler(final ProviderNotFoundException e) {
        LOG.error(e);
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProviderInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String lotInvalidExceptionHandler(final ProviderInvalidException e) {
        LOG.error(e);
        return e.getMessage();
    }
}
