package br.com.providermanager.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"br.com.providermanager.service", "br.com.providermanager.control"})
@EnableJpaRepositories(basePackages = {"br.com.providermanager.persistence"})
@EntityScan("br.com.providermanager.model")
@EnableSwagger2
public class WebApplicationExecutor extends SpringBootServletInitializer {
    private static final Logger LOG = LogManager.getLogger(WebApplicationExecutor.class);

    @Override
    public SpringApplicationBuilder configure(final SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(WebApplicationExecutor.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationExecutor.class, args);
        LOG.info("Provider manager started with success.");
    }
}
