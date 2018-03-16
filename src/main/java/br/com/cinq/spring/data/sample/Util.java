package br.com.cinq.spring.data.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.cinq.spring.data.sample.domain.city.City;
import br.com.cinq.spring.data.sample.domain.country.Country;

public class Util {
	
	private static final Logger logger = LoggerFactory.getLogger(Util.class);

	public static <T> List<T> toList(Iterable<T> iterable) {

		if (iterable instanceof List) {
			return (List<T>) iterable;
		}

		ArrayList<T> list = new ArrayList<T>();
		if (iterable != null) {
			iterable.forEach(t -> {
				list.add(t);
			});
		}

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void readCsvFile(String fileName, Class<T> clazz) {
		
		BufferedReader br = null;
		String line = "";
		String separator = ",";
		
		List<T> list = new ArrayList<T>();
		
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			
			while ((line = br.readLine()) != null) {
				String[] item = line.split(separator);
				
				if (clazz.isInstance(City.class)) {
					
					City c = new City();
					c.setId(Integer.valueOf(item[0]));
					c.setName(item[1].trim());
					
					list.add((T) c);
					
				} else if (clazz.isInstance(Country.class)) {
					
					Country c = new Country();
					c.setId(Integer.valueOf(item[0]));
					c.setName(item[1].trim());
					
					list.add((T) c);
					
				}
				
			}
			
		} catch (IOException ioex) {
			logger.error("", ioex);
			
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					logger.error("", ex);
				}
			}
		}
		
		
	}
	
}
