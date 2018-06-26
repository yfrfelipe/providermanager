package br.com.providermanager.exception.northbound.provider;

import br.com.providermanager.exception.northbound.AbstractNorthBoundException;

public class ProviderInvalidException extends AbstractNorthBoundException {

    public ProviderInvalidException(String message) {
        super(message);
    }
}
