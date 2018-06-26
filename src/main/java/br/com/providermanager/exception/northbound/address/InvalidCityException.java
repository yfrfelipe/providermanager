package br.com.providermanager.exception.northbound.address;

import br.com.providermanager.exception.northbound.AbstractNorthBoundException;

public class InvalidCityException extends AbstractNorthBoundException {

    public InvalidCityException(String message) {
        super(message);
    }
}
