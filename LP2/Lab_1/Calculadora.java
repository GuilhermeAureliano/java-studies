package Lab_1;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - UFCG
 * @author Guilherme Aureliano - 119210371
 *
 */

public class Calculadora {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String entrada = input.next();
		
		if (!entrada.equals("+") && !entrada.equals("-") &&
				!entrada.equals("*") && !entrada.equals("/")) {
			System.out.println("ENTRADA INVALIDA");
		} else {
			double a = input.nextDouble();
			double b = input.nextDouble();
			double res = 0;
			boolean test = false;
			
			if (entrada.equals("+")) {
				res = a + b;
			} else if (entrada.equals("-")) {
				res = a - b;
			} else if (entrada.equals("*")) {
				res = a * b;
			} else {
				if (b == 0) {
					test = true;
				} else {
					res = a/b;
				}
			} 
			
			if (test == false) {
				System.out.println("RESULTADO: " + res);
			} else {
				System.out.println("ERRO");
			}
		}
		input.close();
	}
}
