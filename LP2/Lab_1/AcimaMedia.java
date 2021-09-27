package Lab_1;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - UFCG
 * @author Guilherme Aureliano - 119210371
 *
 */

public class AcimaMedia {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String entrada = input.nextLine();
		String array[] = entrada.split(" ");
		
		int soma = 0;
		for (int i = 0; i < array.length; i ++) {
			
			soma += Integer.parseInt(array[i]);
		}
		double media = soma/(array.length);
		
		String acima = "";
		for (int i = 0; i < array.length; i ++) {
			if (Integer.parseInt(array[i]) > media) {
				acima += array[i] + " ";
			}
		}
		System.out.println(acima);
		input.close();
	}
}
