package br.com.cinq.spring.data.sample.domain.city;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cinq.spring.data.sample.domain.country.Country;

public interface CityRepository extends CrudRepository<City, Integer>{

	@Query(nativeQuery = true, 
			value = "select city.* " + 
					"from city " + 
					"inner join country on city.country_id = country.id " + 
					"where upper(country.name) like upper(:country) ")
	public List<City> findByCountryName(@Param("country") String countryNane);
	
	public List<City> findByCountry(Country country);
}
