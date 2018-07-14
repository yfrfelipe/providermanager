package br.com.providermanager.service;

import br.com.providermanager.dto.AbstractPageDTO;
import br.com.providermanager.dto.provider.ProviderDTO;
import br.com.providermanager.dto.provider.ProviderPageDTO;
import br.com.providermanager.exception.southbound.provider.ProviderCreateException;
import br.com.providermanager.exception.southbound.provider.ProviderDeleteException;
import br.com.providermanager.exception.southbound.provider.ProviderNotFoundException;
import br.com.providermanager.exception.southbound.provider.ProviderUpdateException;
import br.com.providermanager.model.provider.Provider;
import br.com.providermanager.persistence.ProviderPersistence;
import br.com.providermanager.service.converter.ConverterService;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {
    private static final Logger LOG  = LogManager.getLogger(ProviderServiceImpl.class);

    @Autowired
    private ProviderPersistence providerPersistence;

    @Autowired
    private ConverterService<Provider, ProviderDTO> providerConverter;

    @PostConstruct
    public void init() {
        LOG.info("Provider Service initialized with success.");
    }

    @Override
    public void create(ProviderDTO entityDTO) throws ProviderCreateException {

        final Provider provider = providerConverter.fromDto(entityDTO);
        providerPersistence.save(provider);
    }

    @Override
    public ProviderDTO retrieve(Integer id) throws ProviderNotFoundException {
        isExistingProvider(id);

        final Optional<Provider> optional = providerPersistence.findById(id);
        final Provider provider = optional.get();

        return providerConverter.toDto(provider);
    }

    @Override
    public void update(Integer id, ProviderDTO entityDTO) throws ProviderUpdateException {
        isExistingProvider(id);

        final Provider providerToUpdate = providerConverter.fromDto(entityDTO);
        providerToUpdate.setId(id);
        providerPersistence.save(providerToUpdate);
    }

    @Override
    public void delete(Integer id) throws ProviderDeleteException {
        isExistingProvider(id);

        providerPersistence.deleteById(id);
    }

    @Override
    public ProviderPageDTO listByQuantity(final Integer quantity) {
        final Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "name"));
        final Pageable pageable = PageRequest.of(0, quantity, sort);
        final Page<Provider> page = providerPersistence.findAll(pageable);

        final ProviderPageDTO providerPageDTO = new ProviderPageDTO();

        final List<ProviderDTO> providers = Lists.newArrayList();

        for (Provider provider : page.getContent()) {
            providers.add(providerConverter.toDto(provider));
        }

        providerPageDTO.setContent(providers);
        providerPageDTO.setTotalElements(page.getTotalElements());
        providerPageDTO.setTotalPages(page.getTotalPages());
        return providerPageDTO;
    }

    private void isExistingProvider(final Integer id) throws ProviderNotFoundException {
        if (!providerPersistence.existsById(id)) {
            throw new ProviderNotFoundException("Provider with ID " + id + " does not exist.");
        }
    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping Provider service.");
    }
}
