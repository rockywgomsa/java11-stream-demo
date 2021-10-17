package com.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicados {

	//LOS PREDICADOS SON EXPRESIONES QUE RECIBEN UN ARGUMENTO Y DEVUELVEN UN VALOR LOGICO 
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		evaluar(x->x>5, lista);

		evaluar(x->x%2==0, lista);
		
		
		Predicate<Integer> pre = n->n%2==0;
		System.out.println(lista.stream().filter(pre).collect(Collectors.toList()));
	}
	
	public static void evaluar(Predicate<Integer> predicate, List<Integer> lista) {
		for (Integer n : lista) {
			if(predicate.test(n)) System.out.println(n + " ");
		}
		System.out.println();
	}

}
