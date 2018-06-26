package br.com.providermanager.service;

import br.com.providermanager.dto.provider.ProviderDTO;
import br.com.providermanager.exception.southbound.provider.ProviderCreateException;
import br.com.providermanager.exception.southbound.provider.ProviderDeleteException;
import br.com.providermanager.exception.southbound.provider.ProviderNotFoundException;
import br.com.providermanager.exception.southbound.provider.ProviderUpdateException;

public interface ProviderService extends AbstractService<
        ProviderDTO,
        ProviderCreateException,
        ProviderUpdateException,
        ProviderNotFoundException,
        ProviderDeleteException> {
}
