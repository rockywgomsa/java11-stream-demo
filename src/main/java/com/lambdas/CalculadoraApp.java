package com.lambdas;

public class CalculadoraApp {

	public static void main(String[] args) {
		
		IOperacion ope = CalculadoraApp.realizarOperacion("/");
		
		double result = ope.getOperar(10, 2);
		System.out.println(result);

	}
	
	public static IOperacion realizarOperacion(String tipOpe) {
		IOperacion ope = null;
		switch (tipOpe) {
		case "-":
			ope = (p1,p2) -> (p1-p2);
			break;
		case "/":
			ope = (p1,p2) -> (p1/p2);
			break;
		case "*":
			ope = (p1,p2) -> (p1*p2);
			break;
		default:
			ope = (p1,p2) -> (p1+p2);
			break;
		}
		
		return ope;
		
	}

}
