package Lab_1;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - UFCG
 * @author Guilherme Aureliano - 119210371
 *
 */

public class CD {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		
		if (a < b && b < c && c < d) {
			System.out.print(
					"POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		} else if (a > b && b > c && c > d) {
			System.out.print(
					"POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		} else {
			System.out.print(
					"FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}		
		input.close();
	}
}
