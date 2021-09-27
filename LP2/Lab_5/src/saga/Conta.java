package saga;

import java.util.ArrayList;
/**
 * Classe que representa a conta de um cliente com um determinado fornecedor.
 * Toda conta tem uma lista de compras efetuadas.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class Conta {
	
	private ArrayList<Compra> listaCompras;
	
	/**
	 * Cria uma conta do cliente.
	 */
	public Conta() {
		this.listaCompras = new ArrayList<Compra>();
	}
	
	/**
	 * Método que adiciona a compra do cliente a sua conta.
	 * @param data Data de compra. 
	 * @param nomeProduto Nome do produto.
	 * @param descricao Descrição do produto.
	 * @param preco Preço do produto.
	 */
	public void adicionaCompra(String data, String nomeProduto, String descricao, double preco) {
		Compra compra = new Compra(data, nomeProduto, descricao, preco);
		this.listaCompras.add(compra);
	}
	
	/**
	 * Método que exibe o débito do cliente com determinado fornecedor.
	 * @return Uma String que representa o débito.
	 */
	public String getDebito() {
		double debito = 0;
		for (Compra compra: this.listaCompras) {
			debito += compra.getPreco();
		}
		
		String getDebito = String.format("%.2f", debito);
		return getDebito.replace(",",".");
	}
	
	public String exibeContas(String fornecedor) {
		String conta = String.format("%s | ", fornecedor);
		for (Compra compra: this.listaCompras) {
			conta += compra.toString() + " | ";
		}
		
		conta = conta.substring(0, conta.length() - 3);
		return conta.replace("/", "-");
	}	
	
}
