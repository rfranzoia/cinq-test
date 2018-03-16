package br.com.cinq.spring.data.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.spring.data.sample.Util;
import br.com.cinq.spring.data.sample.domain.country.Country;
import br.com.cinq.spring.data.sample.domain.country.CountryRepository;

@Service
public class CountryService {

	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	CountryRepository repository;

	public List<Country> listAll() {
		Iterable<Country> list = repository.findAll();
		List<Country> result = Util.toList(list);
		
		return result;
	}

	public void populate(List<Country> countries) {
		countries.stream().forEach(c -> {
			try {
				repository.save(c);
			} catch (Exception ex) {
				logger.error("", ex);
			}
		});
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
