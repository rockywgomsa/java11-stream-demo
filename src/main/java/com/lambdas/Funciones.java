package com.lambdas;

import java.util.function.Function;

public class Funciones {

	public static void main(String[] args) {
		//Las funciones reciben un argumento y devuelven un resultado, usan la interface Function<T,R> T:tipo de dato input, R:tipo de dato resultado
		Function<Integer, Integer> suma = x-> x+8;
		System.out.println(suma.apply(2));
		
		Function<String, Integer> longitud = s->s.length();
		System.out.println(longitud.apply("rocky"));
	}

}
