package br.com.cinq.spring.data.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.spring.data.sample.Util;
import br.com.cinq.spring.data.sample.domain.country.Country;
import br.com.cinq.spring.data.sample.domain.country.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository repository;

	public List<Country> listAll() {
		Iterable<Country> list = repository.findAll();
		List<Country> result = Util.toList(list);
		
		return result;
	}

	public Country get(Integer id) {
		return repository.findById(id).get();
	}

	public Country save(Country country) {
		country = repository.save(country);
		return country;
	}

	public Country update(Integer id, Country newCountry) {
		Country oldCountry = repository.findById(id).get();

		if (oldCountry != null) {
			oldCountry.setName(newCountry.getName());
		}

		return oldCountry;
	}
	
	public void delete(Integer id) {
		Country country = repository.findById(id).get();
		repository.delete(country);
	}
}
