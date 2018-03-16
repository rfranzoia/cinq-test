package br.com.cinq.spring.data.sample.domain.country;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer>{

	public List<Country> findByNameLike(String name);
	
}
