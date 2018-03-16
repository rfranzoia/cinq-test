package br.com.cinq.spring.data.sample;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.cinq.spring.data.sample.rest.CityREST;
import br.com.cinq.spring.data.sample.rest.CountryREST;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Configuration
@ApplicationPath("rest")
public class Config extends ResourceConfig {

    public Config() {
    	register(CountryREST.class);
		register(CityREST.class);
    }


}