package br.com.providermanager.control.validator;

import br.com.providermanager.dto.contact.ContactDTO;
import br.com.providermanager.exception.northbound.provider.InvalidContactException;
import com.google.common.base.Strings;
import java.util.Objects;

public class ContactValidator extends AbstractValidator {

    private static final String CONTACT_NULL_MESSAGE = "Por favor, informe os detalhes de contato do fornecedor.";
    private static final String INVALID_PRIMARY_PHONE_MESSAGE = "Por favor informe o telefone primário do fornecedor.";

    public static void validateContact(final ContactDTO contactDTO) {

        if (Objects.isNull(contactDTO)) {
            throw new InvalidContactException(CONTACT_NULL_MESSAGE);
        }

        if (Strings.isNullOrEmpty(contactDTO.getPrimaryPhone())) {
            throw new InvalidContactException(INVALID_PRIMARY_PHONE_MESSAGE);
        }
    }
}
