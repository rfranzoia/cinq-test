package br.com.cinq.spring.data.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.spring.data.sample.Util;
import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.CityRepository;

@Service
public class CityService {

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
