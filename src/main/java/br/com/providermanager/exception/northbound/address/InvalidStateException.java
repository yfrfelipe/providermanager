package br.com.providermanager.exception.northbound.address;

import br.com.providermanager.exception.northbound.AbstractNorthBoundException;

public class InvalidStateException extends AbstractNorthBoundException {

    public InvalidStateException(String message) {
        super(message);
    }
}
