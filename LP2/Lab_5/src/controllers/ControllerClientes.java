package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import excecoes.GuiUtil;
import saga.Cliente;

/**
 * Classe que controla e cadastra os clientes, além de saus outras operações.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class ControllerClientes {
	
	private HashMap<String, Cliente> mapaClientes;
	
	/**
	 * Cria o controle de clientes.
	 */
	public ControllerClientes() {
		this.mapaClientes = new HashMap<>();
	}
	
	/**
	 * Método que cadastra os clientes e os adiciona aos mapas dos clientes.
	 * @param cpf CPF do cliente.
	 * @param nome Nome do cliente.
	 * @param email Email do cliente.
	 * @param local Local de trabalho do cliente.
	 * @return Retorna o CPF que serve como ID do cliente, caso o cadastro seja bem sucedido.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String local) {
		GuiUtil.verificaStringNull(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(local, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		GuiUtil.verificaStringVazia(local, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		
		if (this.mapaClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		Cliente cliente = new Cliente(cpf, nome, email, local);
		this.mapaClientes.put(cpf, cliente);
		return cpf;
	}
	
	/**
	 * Método que exibe os dados de um determinado cliente.
	 * @param cpf CPF que serve para achar o cliente no mapa de clientes.
	 * @return Retorna uma String dos dados do cliente. 
	 */
	public String exibeCliente(String cpf) {
		GuiUtil.verificaStringNull(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		
		if (this.mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Método que exibe todos os clientes cadastrados.
	 * @return Retorna uma String de todos os clientes e seus dados.
	 */
	public String exibeClientes() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.addAll(this.mapaClientes.values());
		Collections.sort(listaClientes);
		
		String retorno = "";
		for(Cliente cliente: listaClientes) {
			retorno += cliente.toString() + " | ";
		}
		
		retorno = retorno.substring(0, retorno.length() - 3);
		return retorno;
	}
	
	/**
	 * Método que edita algum atributo do cliente.
	 * @param cpf CPF para indentificar o cliente.
	 * @param atributo Atributo a ser editado.
	 * @param novoValor O novo valor do atributo editado.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		GuiUtil.verificaStringNull(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		
		if("cpf".equals(atributo)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
			
		} else if (this.mapaClientes.containsKey(cpf)) {
			
			if ("nome".equals(atributo)) {
				this.mapaClientes.get(cpf).setNome(novoValor);
			} else if ("email".equals(atributo)) {
				this.mapaClientes.get(cpf).setEmail(novoValor);
			} else if ("localizacao".equals(atributo)) {
				this.mapaClientes.get(cpf).setLocal(novoValor);
			} else {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");	
			}
		}  else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Método que remove um cliente do sistema.
	 * @param cpf CPF para indentificar o cliente.
	 */
	public void removeCliente(String cpf) {
		GuiUtil.verificaStringNull(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		GuiUtil.verificaStringVazia(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		
		if (this.mapaClientes.containsKey(cpf)) {
			this.mapaClientes.remove(cpf);
		} else {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Método que retorna o mapa de clientes que será acessado por outra classe.
	 * @return Retorna o mapa de clientes.
	 */
	public HashMap<String, Cliente> getMapaClientes() {
		return mapaClientes;
	}
	
	/**
	 * Método que retorna o próprio cliente a partir do seu CPF.
	 * @param cpf CPF para indentificar o cliente.
	 * @return Retorna o próprio cliente.
	 */
	public Cliente getCliente(String cpf) {
		return mapaClientes.get(cpf);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
