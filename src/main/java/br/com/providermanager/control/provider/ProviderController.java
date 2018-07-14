package br.com.providermanager.control.provider;

import br.com.providermanager.control.AbstractWebService;
import br.com.providermanager.control.validator.ProviderValidator;
import br.com.providermanager.dto.provider.ProviderDTO;
import br.com.providermanager.dto.provider.ProviderPageDTO;
import br.com.providermanager.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@Api(value = "providermanager", description = "Provider Operations")
public class ProviderController implements AbstractWebService<ProviderDTO> {
    private static final Logger LOG = LogManager.getLogger(ProviderController.class);

    @Autowired
    private ProviderService providerServiceImpl;

    public void init() {
        LOG.info("Provider Controller initialized with success.");
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create a new Provider.")
    @Override
    public void post(@RequestBody final ProviderDTO providerDTO) {
        ProviderValidator.validateProvider(providerDTO);

        providerServiceImpl.create(providerDTO);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Retrieve a given Provider from a given ID.")
    @Override
    @ResponseBody
    public ProviderDTO get(@PathVariable final Integer id) {
        ProviderValidator.validateId(id);

        return providerServiceImpl.retrieve(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update a given Provider based on an existing ID.")
    @Override
    public void put(@PathVariable final Integer id, @RequestBody final ProviderDTO providerDTO) {
        ProviderValidator.validateId(id);

        providerServiceImpl.update(id, providerDTO);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Delete a given Provider based on a given ID.")
    @Override
    public void delete(@PathVariable final Integer id) {
        ProviderValidator.validateId(id);

        providerServiceImpl.delete(id);
    }

    @GetMapping(path = "/list")
    @ApiOperation("Retrieve a list of providers by quantity.")
    @Override
    public ProviderPageDTO listByQuantity(@RequestParam final Integer quantity) {
        return providerServiceImpl.listByQuantity(quantity);
    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping Provider controller.");
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (Objects.nonNull(request.getHeader("Origin")));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");

        if (request.getMethod().equals("OPTIONS")) {
            response.getWriter().print("OK");
            response.getWriter().flush();
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
