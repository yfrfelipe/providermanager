package br.com.providermanager.control.validator;

import br.com.providermanager.dto.provider.ProviderDTO;
import br.com.providermanager.exception.northbound.provider.ProviderInvalidException;
import com.google.common.base.Strings;

public class ProviderValidator extends AbstractValidator {

    private static final String INVALID_NAME_MESSAGE = "Nome inválido.";
    private static final String INVALID_CNPJ_MESSAGE = "CNPJ para fornecedor %s inválido.";

    public static void validateProvider(final ProviderDTO providerDTO) {

        if (Strings.isNullOrEmpty(providerDTO.getName())) {
            throw new ProviderInvalidException(INVALID_NAME_MESSAGE);
        }

        if (Strings.isNullOrEmpty(providerDTO.getCnpj())) {
            throw new ProviderInvalidException(String.format(INVALID_CNPJ_MESSAGE, providerDTO.getName()));
        }

        AddressValidator.validateAddress(providerDTO.getAddress());
        ContactValidator.validateContact(providerDTO.getContact());
    }
}
