package Lab_1;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - UFCG
 * @author Guilherme Aureliano - 119210371
 *
 */

public class Lista {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String entrada = "";
		int cont = 0;
		int soma = 0;
		int maior = -9999;
		int menor = 9999;
		int num = 0;
		int acima = 0;
		int abaixo = 0;
		while (true) {
			entrada = input.nextLine();
			String array[] = entrada.split(" ");
			if (entrada.equals("-")) {
				break;
			} else {
				num = Integer.parseInt(array[1]);
				cont ++;
				soma += num;
				if (num >= maior) {
					maior = num;
				}
				if (num < menor){
					menor = num;
				}
				if (num >= 700) {
					acima ++;
				} else {
					abaixo ++;
				}
			}
		}
		int media = soma/cont;
		if (cont == 1) {
			menor = soma;
			maior = soma;
		}
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
		input.close();
	}	
}
