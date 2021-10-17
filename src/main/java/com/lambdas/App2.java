package com.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App2 {

	public static void main(String[] args) {
			

		List<Integer> listNumeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		listNumeros.forEach(System.out::println);
	
		List<Integer> lista = App2.obbtenerElementosMayorA2(listNumeros);
		lista.forEach(System.out::println);

	}
	
	public static List<Integer> obbtenerElementosMayorA2(List<Integer> list) {
		List<Integer> lista = list.stream()
				.filter(x -> x>2)
				.collect(Collectors.toList());
		
		return lista;
	}

}
