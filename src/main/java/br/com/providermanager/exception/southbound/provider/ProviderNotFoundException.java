package br.com.providermanager.exception.southbound.provider;

import br.com.providermanager.exception.southbound.AbstractRetrievereException;

public class ProviderNotFoundException extends AbstractRetrievereException {

    public ProviderNotFoundException(String message) {
        super(message);
    }
}
