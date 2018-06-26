package br.com.providermanager.service.converter;

import br.com.providermanager.dto.AbstractDTO;
import br.com.providermanager.model.AbstractEntity;

public interface ConverterService<E extends AbstractEntity, D extends AbstractDTO> {

    E fromDto(D dto);

    D toDto(E entity);
}
