package br.com.providermanager.service.converter;

import br.com.providermanager.dto.address.AddressDTO;
import br.com.providermanager.dto.contact.ContactDTO;
import br.com.providermanager.dto.provider.ProviderDTO;
import br.com.providermanager.model.address.Address;
import br.com.providermanager.model.contact.Contact;
import br.com.providermanager.model.provider.Provider;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderConverter implements ConverterService<Provider, ProviderDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConverterService<Address, AddressDTO> addressConverter;

    @Autowired
    private ConverterService<Contact, ContactDTO> contactConverter;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(ProviderDTO.class, Provider.class);
        modelMapper.createTypeMap(Provider.class, ProviderDTO.class);
    }

    @Override
    public Provider fromDto(ProviderDTO dto) {
        final Provider provider = modelMapper.map(dto, Provider.class);
        final Address address = addressConverter.fromDto(dto.getAddress());
        final Contact contact = contactConverter.fromDto(dto.getContact());

        provider.setAddress(address);
        provider.setContact(contact);
        return provider;
    }

    @Override
    public ProviderDTO toDto(Provider entity) {
        final ProviderDTO providerDTO = modelMapper.map(entity, ProviderDTO.class);
        final AddressDTO addressDTO = addressConverter.toDto(entity.getAddress());
        final ContactDTO contactDTO = contactConverter.toDto(entity.getContact());

        providerDTO.setAddress(addressDTO);
        providerDTO.setContact(contactDTO);
        return providerDTO;
    }
}
