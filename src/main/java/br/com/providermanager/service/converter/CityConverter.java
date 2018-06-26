package br.com.providermanager.service.converter;

import br.com.providermanager.dto.address.CityDTO;
import br.com.providermanager.dto.address.StateDTO;
import br.com.providermanager.model.address.City;
import br.com.providermanager.model.address.State;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityConverter implements ConverterService<City, CityDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConverterService<State, StateDTO> stateConverter;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(CityDTO.class, City.class);
        modelMapper.createTypeMap(City.class, CityDTO.class);
    }

    @Override
    public City fromDto(final CityDTO dto) {
        final City city = modelMapper.map(dto, City.class);
        final State state = stateConverter.fromDto(dto.getStateDTO());

        city.setState(state);
        return city;
    }

    @Override
    public CityDTO toDto(final City entity) {
        final CityDTO cityDTO = modelMapper.map(entity, CityDTO.class);
        final StateDTO stateDTO = stateConverter.toDto(entity.getState());

        cityDTO.setStateDTO(stateDTO);
        return cityDTO;
    }
}
