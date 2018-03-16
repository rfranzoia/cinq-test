package br.com.cinq.spring.data.sample.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.domain.city.City;
import br.com.cinq.spring.data.sample.domain.city.CityRepository;
import br.com.cinq.spring.data.sample.domain.country.Country;

/**
 * Eye candy: implements a sample in using JpaRespositories
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("unit")
public class CityRepositoryTest {

    @Autowired
    private CityRepository dao;

    @Test
    public void testQueryPerson() {

    	assertThat(dao).isNotNull();
        
    	//assertThat(dao.count()).isGreaterThan(0);

        Country country = new Country();
        
        country.setId(99); // should be no one, or Should be France

        List<City> list = dao.findByCountry(country);

        assertThat(list.size()).isEqualTo(0);
    }
}
