package br.com.cinq.spring.data.sample.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.Util;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CountryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository dao;

    @Test
    public void testGelAllCountries() {

    	assertThat(dao).isNotNull();

    	assertThat(dao.count()).isGreaterThan(0);
    	
        long count = dao.count();

        assertThat(count).isGreaterThan(0);
        
        List<Country> countries = Util.toList(dao.findAll());

        assertThat(count).isEqualTo(countries.size());
    }

    @Test
    public void testFindOneCountry() {

    	assertThat(dao).isNotNull();

        List<Country> countries = dao.findByNameLike("Fra");

        assertThat(countries.size()).isEqualTo(1);

    }

}
