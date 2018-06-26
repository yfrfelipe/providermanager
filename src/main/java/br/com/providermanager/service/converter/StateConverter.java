package br.com.providermanager.service.converter;

import br.com.providermanager.dto.address.StateDTO;
import br.com.providermanager.model.address.State;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateConverter implements ConverterService<State, StateDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(StateDTO.class, State.class);
        modelMapper.createTypeMap(State.class, StateDTO.class);
    }

    @Override
    public State fromDto(final StateDTO dto) {
        return modelMapper.map(dto, State.class);
    }

    @Override
    public StateDTO toDto(final State entity) {
        return modelMapper.map(entity, StateDTO.class);
    }
}
