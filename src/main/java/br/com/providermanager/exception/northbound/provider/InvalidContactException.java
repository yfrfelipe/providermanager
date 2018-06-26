package br.com.providermanager.exception.northbound.provider;

import br.com.providermanager.exception.northbound.AbstractNorthBoundException;

public class InvalidContactException extends AbstractNorthBoundException {

    public InvalidContactException(String message) {
        super(message);
    }
}
