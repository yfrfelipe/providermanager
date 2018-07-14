package br.com.providermanager.control;

import br.com.providermanager.dto.AbstractDTO;
import br.com.providermanager.dto.AbstractPageDTO;
import java.util.List;
import javax.servlet.Filter;

public interface AbstractWebService <T extends AbstractDTO> extends AutoCloseable, Filter {

    /**
     * This method is responsible to receive a DTO to be created.
     */
    void post(T modelDTO);

    /**
     * This method is responsble to retrieve a given data.
     */
    T get(Integer id);

    void put(Integer id, T modelDTO);

    void delete(Integer id);

    AbstractPageDTO<T> listByQuantity(Integer quantity);
}
