package lab_02_guilherme_aureliano;

/**
 * Classe que representa uma conta na cantina. Toda cantina tem um nome, o valor total dos lanches, o saldo atual dos lanches
 * e a quantidade de itens consumidos.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class ContaCantina {	
	/**
	 * String que representa o nome da cantina.
	 */
	private String nomeDaCantina;
	/**
	 * Inteiro que representa o valor, em centavos, total dos lanches.
	 */
	private int valorTotalLanches;
	/**
	 * Inteiro que representa o valor, em centavos, do saldo de pagamento dos lanches.
	 */
	private int saldoAtualLanches;
	/**
	 * Inteiro que representa a quantidade de itens consumidos.
	 */
	private int totalItens;
	
	/**
	 * Constrói uma cantina a partir de seu nome. 
	 * @param nomeDaCantina nome da cantina.
	 */
	ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
	}	
	
	/**
	 * Adiciona os itens consumidos e o valor total do lanche.
	 * @param itens Quantidade de itens.
	 * @param valorCentavos Valor do lanche em centavos.
	 */
	public void cadastraLanche(int itens, int valorCentavos) {
		this.valorTotalLanches += valorCentavos;
		this.totalItens += itens;
		
	}
	
	/**
	 * Subtrai o valor efetuado do valor total do lanche.
	 * @param valorCentavos É o valor em centavos que deve ser subtraido do total.
	 */
	public void pagaConta(int valorCentavos) {
		this.saldoAtualLanches += valorCentavos;
		
	}
	
	/**
	 * Verifica se o aluno ainda deve um valor na cantina.
	 * @return Um inteiro que representa o valor que o aluno deve, em centavos, na cantina.
	 */
	public int getFaltaPagar() {
		int faltaPagar = 0;
		faltaPagar = valorTotalLanches - saldoAtualLanches;
		return faltaPagar;
	}
	
	/**
	 * Retorna uma String que representa o nome da cantina, quantidade de itens consumidos e o valor total gasto.
	 */
	public String toString() {
		return nomeDaCantina + " " + totalItens + " " + valorTotalLanches;
	}
}
