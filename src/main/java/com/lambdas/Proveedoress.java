package com.lambdas;

import java.util.function.Supplier;

public class Proveedoress {

	public static void main(String[] args) {
		//Las expresiones Lambda de este tipo no tiene parámetros de entrada, pero si devuelven un resultado, 
		//utilizan la interface Supplier<T>
		
		Supplier<String> cadena = () -> "Rocky y Osito";
		System.out.println(cadena.get());

		
		Supplier<Persona> supplier = Proveedoress::llenarPersona;
		System.out.println(supplier.get().getNombre());
	}
	
	public static Persona llenarPersona(){
		return new Persona("Rocky", "Osito", 2);
	}

}
