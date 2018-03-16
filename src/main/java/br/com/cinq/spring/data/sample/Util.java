package br.com.cinq.spring.data.sample;

import java.util.ArrayList;
import java.util.List;

public class Util {

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
	
}
