package br.com.providermanager.control.validator;

import br.com.providermanager.dto.address.StateDTO;
import br.com.providermanager.exception.northbound.address.InvalidStateException;
import com.google.common.base.Strings;
import java.util.Objects;

public class StateValidator extends AbstractValidator {

    private static final String STATE_NULL_MESSAGE = "Por favor, informe um estado brasileiro válido.";
    private static final String INVALID_NAME_MESSAGE = "Por favor, informe um nome de estado brasileiro válido.";

    public static void validateState(final StateDTO stateDTO) {

        if (Objects.isNull(stateDTO)) {
            throw new InvalidStateException(STATE_NULL_MESSAGE);
        }

        if (Strings.isNullOrEmpty(stateDTO.getName())) {
            throw new InvalidStateException(INVALID_NAME_MESSAGE);
        }
    }
}
