package br.com.cinq.spring.data.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.spring.data.sample.Util;
import br.com.cinq.spring.data.sample.domain.city.City;
import br.com.cinq.spring.data.sample.domain.city.CityRepository;

@Service
public class CityService {

	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	@Autowired
	CityRepository repository;

	public List<City> listAll() {
		
		Iterable<City> list = repository.findAll();
		List<City> result = Util.toList(list);
		
		return result;
	}

	public List<City> listByCountryName(String countryNane) {
		
		countryNane = countryNane.replaceAll("%", "");

		if (countryNane.isEmpty()) {
			return new ArrayList<City>();
		}
		
		List<City> list = repository.findByCountryName("%" + countryNane.trim().toUpperCase() + "%");
		
		return list;
	}
	
	public void populate(List<City> cities) {
		cities.stream().forEach(c -> {
			try {
				repository.save(c);
			} catch (Exception ex) {
				logger.error("", ex);
			}
		});
	}
	
	public City get(Integer id) {
		return repository.findById(id).get();
	}

	public City save(City city) {
		city = repository.save(city);
		return city;
	}

	public City update(Integer id, City newCity) {
		City oldCity = repository.findById(id).get();

		if (oldCity != null) {
			oldCity.setName(newCity.getName());
		}

		return oldCity;
	}
	
	public void delete(Integer id) {
		City city = repository.findById(id).get();
		repository.delete(city);
	}
}
