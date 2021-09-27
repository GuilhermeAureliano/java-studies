package lab_02_guilherme_aureliano;

/**
 * Classe que representa a saúde de um aluno. Ela pode ser mental ou física.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class Saude {
	/**
	 * String que representa a saúde mental do aluno.
	 */
	private String saudeMental;
	/**
	 * String que representa a saúde física do aluno.
	 */
	private String saudeFisica;
	/**
	 * String que representa o sentimento do aluno na forma de um emoji.
	 */
	private String Emoji;
	/**
	 * Inteiro para contar quantas vezes a saúde foi registrada.
	 */
	private int cont;
	
	/**
	 * Constrói um objeto que representa as saúdes do aluno.
	 * Se não for passado parâmetro, as saúdes do aluno é considerada boa.
	 */
	Saude () {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}
	
	/**
	 * Recebe um valor no parâmetro que representa a saúde mental do aluno.
	 * @param valor Uma String.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		this.cont += 1;
	}
	
	/**
	 * Recebe um valor no parâmetro que representa a saúde física do aluno.
	 * @param valor Uma String.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		this.cont += 1;
	}
	
	/**
	 * Recebe um valor como parâmetro que representa o sentimento atual do aluno.
	 * @param valor Uma String na forma de um emoji. 
	 */
	public void definirEmoji(String valor) {
		this.Emoji = valor;
	}
	
	/**
	 * Verifica as saúdes dos alunos, definindo seu status geral de acordo com suas saúdes mental e física.
	 * Caso a saúde tenha sido registrada 2 vezes (1 de cada), retorna a String junto de um Emoji.
	 * Caso a saúde tenha sido registrada mais de 2 vezes, a geral acaba mudando, e retorna apenas a String sem o emoji.
	 * @return Uma string que representa o status geral do aluno. Onde: FRACA(caso ambas saúdes estejam fracas), BOA(caso ambas saúdes estejam boas) e OK(caso elas sejam diferentes).
	 */
	public String getStatusGeral() {
		if (cont == 2) {
			if (saudeFisica.equals("fraca") && saudeMental.equals("fraca")) {
				return "fraca" +" "+Emoji;
			} else if (saudeFisica.equals("boa") && saudeMental.equals("boa")) {
				return "boa" +" "+ Emoji;			
			}
			return "ok" +" "+ Emoji;
		}
		if (saudeFisica.equals("fraca") && saudeMental.equals("fraca")) {
			return "fraca";
		} else if (saudeFisica.equals("boa") && saudeMental.equals("boa")) {
			return "boa";
		}
		return "ok";
	}
}
