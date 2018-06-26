package br.com.providermanager.control.validator;

import br.com.providermanager.dto.address.AddressDTO;
import br.com.providermanager.exception.northbound.address.InvalidAddressException;
import com.google.common.base.Strings;
import java.util.Objects;

public class AddressValidator extends AbstractValidator {

    private static final String ADDRESS_NULL_MESSAGE = "Por favor informe o endereço do fornecedor.";
    private static final String INVALID_STREET_MESSAGE = "Logradouro inválido.";
    private static final String INVALID_CEP_MESSAGE = "Cep para logradouro %s inválido.";
    private static final String INVALID_NUMBER_MESSAGE = "Número inválido para logradouro %s.";
    private static final String INVALID_NEIGHBOR_MESSAGE = "Bairro inválido para logradouro %s.";

    public static void validateAddress(final AddressDTO addressDTO) {

        if (Objects.isNull(addressDTO)) {
            throw new InvalidAddressException(ADDRESS_NULL_MESSAGE);
        }

        if (Strings.isNullOrEmpty(addressDTO.getStreet())) {
            throw new InvalidAddressException(INVALID_STREET_MESSAGE);
        }

        if (Strings.isNullOrEmpty(addressDTO.getCep())) {
            throw new InvalidAddressException(String.format(INVALID_CEP_MESSAGE, addressDTO.getStreet()));
        }

        if (Strings.isNullOrEmpty(addressDTO.getNumber())) {
            throw new InvalidAddressException(String.format(INVALID_NUMBER_MESSAGE, addressDTO.getStreet()));
        }

        if (Strings.isNullOrEmpty(addressDTO.getNeighbor())) {
            throw new InvalidAddressException(String.format(INVALID_NEIGHBOR_MESSAGE, addressDTO.getStreet()));
        }

        CityValidator.validateCity(addressDTO.getCityDTO());
    }
}
