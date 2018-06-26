package br.com.providermanager.control.validator;

import br.com.providermanager.dto.address.CityDTO;
import br.com.providermanager.exception.northbound.address.InvalidCityException;
import com.google.common.base.Strings;
import java.util.Objects;

public class CityValidator extends AbstractValidator {

    private static final String CITY_NULL_MESSGE = "Pro favor, informe a cidade.";
    private static final String INVALID_NAME_MESSAGE = "Por favor, informe um nome de cidade válido.";

    public static void validateCity(final CityDTO cityDTO) {

        if (Objects.isNull(cityDTO)) {
            throw new InvalidCityException(CITY_NULL_MESSGE);
        }

        if (Strings.isNullOrEmpty(cityDTO.getName())) {
            throw new InvalidCityException(INVALID_NAME_MESSAGE);
        }

        StateValidator.validateState(cityDTO.getStateDTO());
    }
}
