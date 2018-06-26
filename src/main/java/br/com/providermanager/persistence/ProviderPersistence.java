package br.com.providermanager.persistence;

import br.com.providermanager.model.provider.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderPersistence extends CrudRepository<Provider, Integer> {
}
