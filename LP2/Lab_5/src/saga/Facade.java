package saga;

import controllers.ControllerClientes;
import controllers.ControllerContas;
import controllers.ControllerFornecedores;
import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", 
				"acceptance_test/use_case_1.txt",
				"acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt",
				"acceptance_test/use_case_4.txt",
				"acceptance_test/use_case_5.txt",
				"acceptance_test/use_case_6.txt"};
		EasyAccept.main(args);
	}
	
	private ControllerClientes controllerClientes;
	private ControllerFornecedores controllerFornecedores;
	private ControllerContas controllerContas;
	
	public Facade() {
		this.controllerClientes = new ControllerClientes();
		this.controllerFornecedores = new ControllerFornecedores();
		this.controllerContas = new ControllerContas(this.controllerClientes, this.controllerFornecedores);
	}
	public String adicionaCliente (String cpf, String nome, String email, String local) {
		return this.controllerClientes.adicionaCliente(cpf, nome, email, local);
	}
	
	public String exibeCliente(String cpf) {
		return this.controllerClientes.exibeCliente(cpf);
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.controllerClientes.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		this.controllerClientes.removeCliente(cpf);
	}
	/**
	 * -----------------------> Fim do US1 <-----------------------
	 */
	
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.controllerFornecedores.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.controllerFornecedores.exibeFornecedor(nome);
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.controllerFornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		this.controllerFornecedores.removeFornecedor(nome);
	}
	/**
	 * -----------------------> Fim do US2 <-----------------------
	 */
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.controllerFornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.controllerFornecedores.exibeProduto(nome, descricao, fornecedor);
	}
	
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.controllerFornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public void removeProduto (String nomeProduto, String descricao, String fornecedor) {
		this.controllerFornecedores.removeProduto(nomeProduto, descricao, fornecedor);
	}
	/**
	 * -----------------------> Fim do US3 <-----------------------
	 */
	
	public String exibeProdutos() {
		return this.controllerFornecedores.exibeProdutos();
	}
	
	public String exibeProdutosFornecedor(String nome) {
		return this.controllerFornecedores.exibeProdutosFornecedor(nome);
	}
	
	public String exibeClientes() {
		return this.controllerClientes.exibeClientes();
	}
	
	public String exibeFornecedores() {
		return this.controllerFornecedores.exibeFornecedores();
	}
	/**
	 * -----------------------> Fim do US4 <-----------------------
	 */
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricao) {
		this.controllerContas.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricao);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		return this.controllerContas.getDebito(cpf, fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return this.controllerContas.exibeContas(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return this.controllerContas.exibeContasClientes(cpf);
	}
	/**
	 * -----------------------> Fim do US5 <-----------------------
	 */
	
	public void ordenaPor(String criterio) {
		this.controllerContas.ordenaPor(criterio);
	}
	
	public void listarCompras(String criterio) {
		this.controllerContas.listarCompras(criterio);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}