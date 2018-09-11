package br.com.providermanager.persistence;

import br.com.providermanager.model.provider.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderPersistence extends CrudRepository<Provider, Integer>, PagingAndSortingRepository<Provider, Integer> {
}
