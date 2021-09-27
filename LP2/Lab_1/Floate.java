package Lab_1;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - UFCG
 * @author Guilherme Aureliano - 119210371
 *
 */

public class Floate {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float a = input.nextFloat();
		float b = input.nextFloat();
		float media = (a+b)/2;
		
		if (media >= 7) {
			System.out.print("pass: True!");
		} else {
			System.out.print("pass: False!");
		}
		
		input.close();
	}
}
