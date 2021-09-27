package Lab_1;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - UFCG
 * @author Guilherme Aureliano - 119210371
 *
 */

public class Wally {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String nome = "";
		int tam = 5;
		String parametro = "";
		String test = "";
		
		while (!nome.equals("wally")) {
			nome = input.nextLine();
			String array[] = nome.split(" ");
			
			for (int i = 0; i < array.length; i++) {
				test = array[i];
				if (test.length() == tam) {
					parametro = test;
				}
			} 
			if (parametro.equals("") && !nome.equals("wally")) {
				System.out.println("?");
			} else if (!nome.equals("wally")) {
				System.out.println(parametro);
			}
		parametro = "";
		}	
		input.close();
	}		
}