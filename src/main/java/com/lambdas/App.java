package com.lambdas;

public class App {
	
	public static void main(String[] args) {
//		App.lambdaSinParam();
//		App.lambdaConParam();
	
//		System.out.println(App.esDivisor(8, 2));
		System.out.println(App.esMenor(782, 6));
		
	}
	
	public static void lambdaSinParam() {
		MiValor m = () -> 10.45;
		System.out.println(m.getValor());
	}
	
	public static void lambdaConParam() {
		MiValorParam p = (x) -> x + 10;
		System.out.println(p.getValor(2));
	}
	
	
	public static String esDivisor(int p1, int p2) {
		PruebaNum prueba = (x,y) -> (x % y == 0);
		boolean resp = prueba.pruebaEnteros(p1, p2);
		String msj = p2 + " no es divisor de " + p1;
		
		if(resp) msj = p2 + " es divisor de " + p1;

		return msj;
	}
	
	
	public static String esMenor(int p1, int p2) {
		PruebaNum prueba = (x,y) -> (x < y);
		boolean resp = prueba.pruebaEnteros(p1, p2);
		String msj = p1 + " no es menor que " + p2;
		
		if(resp) msj = p1 + " es menor que " + p2;

		return msj;
	}

}
