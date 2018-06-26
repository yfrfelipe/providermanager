package br.com.providermanager.service.converter;

import br.com.providermanager.dto.address.AddressDTO;
import br.com.providermanager.dto.address.CityDTO;
import br.com.providermanager.model.address.Address;
import br.com.providermanager.model.address.City;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter implements ConverterService<Address, AddressDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConverterService<City, CityDTO> cityConverter;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(Address.class, AddressDTO.class);
        modelMapper.createTypeMap(AddressDTO.class, Address.class);
    }

    @Override
    public Address fromDto(final AddressDTO dto) {
        final Address address = modelMapper.map(dto, Address.class);
        final City city = cityConverter.fromDto(dto.getCityDTO());

        address.setCity(city);
        return address;
    }

    @Override
    public AddressDTO toDto(final Address entity) {
        final AddressDTO addressDTO = modelMapper.map(entity, AddressDTO.class);
        final CityDTO cityDTO = cityConverter.toDto(entity.getCity());

        addressDTO.setCityDTO(cityDTO);
        return addressDTO;
    }
}
