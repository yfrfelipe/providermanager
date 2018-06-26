package br.com.providermanager.service;


import br.com.providermanager.dto.AbstractDTO;
import br.com.providermanager.exception.southbound.AbstractCreateException;
import br.com.providermanager.exception.southbound.AbstractDeleteException;
import br.com.providermanager.exception.southbound.AbstractRetrievereException;
import br.com.providermanager.exception.southbound.AbstractUpdateException;

public interface AbstractService<
        T extends AbstractDTO,
        C extends AbstractCreateException,
        U extends AbstractUpdateException,
        R extends AbstractRetrievereException,
        D extends AbstractDeleteException> extends AutoCloseable {

    void create(T entityDTO) throws C;

    T retrieve(Integer id) throws R;

    void update(Integer id, T entityDTO) throws U;

    void delete(Integer id) throws D;
}
