package br.com.providermanager.exception.northbound.address;

import br.com.providermanager.exception.northbound.AbstractNorthBoundException;

public class InvalidAddressException extends AbstractNorthBoundException {

    public InvalidAddressException(String message) {
        super(message);
    }
}
