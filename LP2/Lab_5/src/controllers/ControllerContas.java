package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import excecoes.GuiUtil;
import saga.Cliente;
import saga.Fornecedor;
/**
 * Classe que controla as contas do sistema para quando um cliente faz determinada compra de um produto do fornecedor.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class ControllerContas {
	
	private ControllerClientes controllerClientes;
	private ControllerFornecedores controllerFornecedores;
	
	/**
	 * Cria o controle de contas que é responsável por cadastrar as compras, além de suas outras respectivas funções.
	 * @param controllerClientes O objeto ControllerClientes para acessar seus métodos.
	 * @param controllerFornecedores O objeto ControllerFornecedores para acessar seus métodos.
	 */
	public ControllerContas(ControllerClientes controllerClientes, ControllerFornecedores controllerFornecedores) {
		this.controllerClientes = controllerClientes;
		this.controllerFornecedores = controllerFornecedores;
	}
	
	/**
	 * Método que adiciona a compra de um cliente a conta do fornecedor.
	 * @param cpf CPF do cliente para encontrá-lo no sistema.
	 * @param fornecedor Nome do fornecedor.
	 * @param data Data da compra.
	 * @param nomeProduto Nome do produto.
	 * @param descricao Descrição do produto.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricao) {
		GuiUtil.verificaStringNull(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringVazia(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringNull(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula." );
		GuiUtil.verificaStringVazia(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula." );
		GuiUtil.verificaStringNull(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringVazia(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringNull(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula." );
		GuiUtil.verificaStringVazia(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula." );
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		if (this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			
			if (this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
				Cliente cliente = this.controllerClientes.getCliente(cpf);
				this.controllerFornecedores.getMapaFornecedores().get(fornecedor).adicionaCompra(cliente, data, nomeProduto, descricao);
			} else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		
	}
	
	/**
	 * Método que retorna o débito do cliente com determinado fornecedor.
	 * @param cpf CPF do cliente para achá-lo no sistema.
	 * @param fornecedor O fornecedor no qual o cliente tem débito.
	 * @return Uma String que representa o débito do cliente.
	 */
	public String getDebito(String cpf, String fornecedor) {
		GuiUtil.verificaStringNull(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringVazia(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo." );
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		if (this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
			
			if (this.controllerClientes.getMapaClientes().containsKey(cpf)) {
				Cliente cliente = this.controllerClientes.getCliente(cpf);
				return this.controllerFornecedores.getMapaFornecedores().get(fornecedor).getDebito(cliente);
			} else {
				throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
			}
			
		} else {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que exibe determinado conta do cliente com fornecedor.
	 * @param cpf CPF do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @return Uma String que retorna os dado da conta do cliente.
	 */
	public String exibeContas(String cpf, String fornecedor) {
		GuiUtil.verificaStringNull(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(fornecedor,"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		
		Cliente cliente = this.controllerClientes.getCliente(cpf);
		if (!this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		} else if (!this.controllerFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");	
		}
		else {
			return this.controllerFornecedores.getMapaFornecedores().get(fornecedor).exibeContas(cliente, fornecedor);
		}
	}
	
	/**
	 * Método que exibe todas as contas do cliente no sistema.
	 * @param cpf CPF do cliente.
	 * @return Uma String de todas as contas do cliente no sistema.
	 */
	public String exibeContasClientes(String cpf) {
		GuiUtil.verificaStringNull(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		
		if(!this.controllerClientes.getMapaClientes().containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		
		Cliente cliente = this.controllerClientes.getCliente(cpf);
		String contas = "Cliente: " + cliente.getNome() + " | ";
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		listaFornecedores.addAll(this.controllerFornecedores.getMapaFornecedores().values());
		Collections.sort(listaFornecedores);
		
		for (Fornecedor fornecedor: listaFornecedores) {
			if (fornecedor.exibeContasCliente(cliente) != null) {
				contas += fornecedor.exibeContasCliente(cliente) + " | ";
			}
		}
		if (contas.equals("Cliente: " + cliente.getNome() + " | ")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		return contas.substring(0, contas.length() - 3);
	}
	
	public void ordenaPor(String criterio) {
		GuiUtil.verificaStringNull(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		
		listarCompras(criterio);
	}
	
	public void listarCompras(String criterio) {
		if ("Cliente".equals(criterio)) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		} else {
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
