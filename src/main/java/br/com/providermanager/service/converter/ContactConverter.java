package br.com.providermanager.service.converter;

import br.com.providermanager.dto.contact.ContactDTO;
import br.com.providermanager.model.contact.Contact;
import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactConverter implements ConverterService<Contact, ContactDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(ContactDTO.class, Contact.class);
        modelMapper.createTypeMap(Contact.class, ContactDTO.class);
    }

    @Override
    public Contact fromDto(ContactDTO dto) {
        return modelMapper.map(dto, Contact.class);
    }

    @Override
    public ContactDTO toDto(Contact entity) {
        return modelMapper.map(entity, ContactDTO.class);
    }
}
