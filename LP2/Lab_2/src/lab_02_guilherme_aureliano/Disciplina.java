package lab_02_guilherme_aureliano;

import java.util.Arrays;

/**
 * Classe que representa uma disciplina. Toda disciplina tem um nome, quantidade de horas que cursa, notas da disciplina
 * e média das notas.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class Disciplina {
	/**
	 * É o nome da disciplina, que é uma representação em String.
	 */
	private String nomeDisciplina;
	/**
	 * Representação das horas cursadas da disciplina, no formato de um inteiro.
	 */
	private int horas;
	/**
	 * Representação das notas do aluno em formato de Array. O índice significa qual a nota está
	 * sendo representada, e o valor associado ao índice é a nota do aluno.
	 */
	private double[] arrayNotas;
	
	/**
	 * Constrói uma disciplina a partir do seu nome.
	 * @param nomeDisciplina É o nome da disciplina.
	 */
	Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
        this.arrayNotas = new double[4];
	}
	
	/**
	 * Cadastra as horas da disciplina do aluno.
	 * @param horas Recebe às horas da disciplina do aluno.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Cadastra as notas do aluno.
	 * E verifica se a nota é menor que 0 ou caso o usuário tente cadastrar uma quinta nota, ou seja, ultrapassando o
	 * array, dessa forma, o programa não quebra e ele não consegue cadastrar.
	 * @param nota Representa qual a nota vai ser cadastrada.
	 * @param valorNota Representa o valor da sua nota.
	 */
	public void cadastraNota(int nota, double valorNota) {
		if (nota < 0 || nota > this.arrayNotas.length) {
			return;
		} else {
			arrayNotas[nota-1] = valorNota;			
		}
	}
	
	/**
	 * Método que calcula a média das notas do aluno.
	 * @return Um valor que é a média dividido pelo tamanho do array que é a quantidade de disciplinas.
	 */
	private double calculaMedia() {
		double media = 0;
		for (double i: arrayNotas) {
			media += i;
		}
	return media/this.arrayNotas.length;
	}

	/**
	 * Verifica se a média é suficiente para ser aprovado ou não.
	 * @return Um valor em booleano se foi aprovado ou não.
	 */
	public boolean aprovado() {
		if (calculaMedia()>= 7.0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a String que representa a disciplina, no formato: NOME DISCIPLINA - HORAS CURSADAS - MÉDIA DAS NOTAS - NOTAS.
	 * @return A representação em String da disciplina.
	 */
	public String toString() {
		return nomeDisciplina + " " + horas + " " + calculaMedia() + " " + Arrays.toString(this.arrayNotas);
	}
	
}
