package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import excecoes.GuiUtil;
import saga.Fornecedor;
/**
 * Classe que controla e cadastra os fornecedores do sistema. Essa classe também cria e adiciona os produtos do sistema.
 * 
 * @author Guilherme Aureliano - 119210371
 *
 */
public class ControllerFornecedores {

	private HashMap<String, Fornecedor> mapaFornecedores;
	
	public ControllerFornecedores() {
		this.mapaFornecedores = new HashMap<>();
	}
	
	/**
	 * Método que cria e adiciona o fornecedor ao mapa de fornecedores.
	 * @param nome Nome do fornecedor. 
	 * @param email Email do fornecedor.
	 * @param telefone Telefone do fornecedor.
	 * @return Retorna uma String que é o nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		GuiUtil.verificaStringNull(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringNull(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo." );
		GuiUtil.verificaStringVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo." );
		
		if (this.mapaFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		} else {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			this.mapaFornecedores.put(nome, fornecedor);
			return nome;
		}
	}
	
	/**
	 * Método que exibe os dados de um determinado fornecedor.
	 * @param nome Nome do fornecedor para achá-lo ao mapa de fornecedores.
	 * @return Retorna uma String que é os dados do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		GuiUtil.verificaStringNull(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(nome)) {
			return this.mapaFornecedores.get(nome).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		
	}
	
	/**
	 * Método que retorna todos os fornecedores do sistema.
	 * @return Uma String que representa todos os fornecedores do sistema.
	 */
	public String exibeFornecedores() {
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		listaFornecedores.addAll(this.mapaFornecedores.values());
		Collections.sort(listaFornecedores);
		
		String retorno = "";
		for (Fornecedor fornecedor: listaFornecedores) {
			retorno += fornecedor.toString() + " | ";
		}
		
		retorno = retorno.substring(0, retorno.length() -3);
		return retorno;
	}
	
	/**
	 * Método que edita um determinado atributo de um fornecedor.
	 * @param nome Nome do fornecedor para achá-lo no sistema.
	 * @param atributo Atributo que vai ser editado.
	 * @param novoValor Novo valor do atributo editado.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		GuiUtil.verificaStringNull(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(nome)) {
			
			if ("nome".equals(atributo)) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			}
			
			if ("email".equals(atributo)) {
				this.mapaFornecedores.get(nome).setEmail(novoValor);
			} else if ("telefone".equals(atributo)) {
				this.mapaFornecedores.get(nome).setTelefone(novoValor);
			} else {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}	
			
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que remove um determinado fornecedor do sistema.
	 * @param nome Nome do fornecedor para achá-lo no mapa de fornecedores.
	 */
	public void removeFornecedor(String nome) {
		GuiUtil.verificaStringNull(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(nome)) {
			this.mapaFornecedores.remove(nome);
		} else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que cadastra e adiciona um produto ao mapa de produtos.
	 * @param fornecedor Nome do fornecedor para achá-lo no sistema e que é responsável pelo produto.
	 * @param nome Nome do produto.
	 * @param descricao Descricão do produto.
	 * @param preco Preço do produto.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		GuiUtil.verificaStringNull(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		GuiUtil.verificaStringVazia(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			this.mapaFornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que exibe os dados de um determinado produto.
	 * @param nome Nome do produto para achá-lo no sistema.
	 * @param descricao Descricão do produto.
	 * @param fornecedor Nome do fornecedor responsável pelo produto.
	 * @return Uma String que representa os dados do produto.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		GuiUtil.verificaStringNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		GuiUtil.verificaStringVazia(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			return this.mapaFornecedores.get(fornecedor).exibeProduto(nome, descricao);
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que exibe todos os dados dos produtos.
	 * @param fornecedor Nome do fornecedor que é indentificá-lo no sistema.
	 * @return Uma String dos dados dos produtos dos fornecedores.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		GuiUtil.verificaStringNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			return this.mapaFornecedores.get(fornecedor).exibeProdutosFornecedor();
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que exibe os dados de todos os produtos.
	 * @return Uma String dos dados dos produtos do sistema.
	 */
	public String exibeProdutos() {
		
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		listaFornecedores.addAll(this.mapaFornecedores.values());
		Collections.sort(listaFornecedores);
		
		String retorno = "";
		for (Fornecedor fornecedor: listaFornecedores) {
			retorno += fornecedor.exibeProdutosFornecedor() + " | ";
		}
		
		retorno =  retorno.substring(0, retorno.length() -3);
		return retorno;
	}
	
	/**
	 * Método que edita determinado produto.
	 * @param nome Nome do produto que para achá-lo no sistema.
	 * @param descricao Descrição do produto para achá-lo no sistema.
	 * @param fornecedor Nome do fornecedor responsável pelo produto.
	 * @param novoPreco O novo preço do produto.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		GuiUtil.verificaStringNull(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(descricao,  "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		GuiUtil.verificaStringVazia(descricao,  "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		
		if (novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		} else if (this.mapaFornecedores.containsKey(fornecedor)) {
			this.mapaFornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que remove determinado produto do sistema.
	 * @param nomeProduto Nome do produto que para achá-lo no sistema.
	 * @param descricao Descrição do produto para achá-lo no sistema.
	 * @param fornecedor Nome do fornecedor responsável pelo produto.
	 */
	public void removeProduto (String nomeProduto, String descricao, String fornecedor) {
		GuiUtil.verificaStringNull(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringNull(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		GuiUtil.verificaStringVazia(descricao,"Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		GuiUtil.verificaStringNull(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		GuiUtil.verificaStringVazia(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		
		if (this.mapaFornecedores.containsKey(fornecedor)) {
			this.mapaFornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		
	}
	
	/**
	 * Método que retorna o mapa de fornecedores que será acessado por outra classe.
	 * @return O mapa de fornecedores.
	 */
	public HashMap<String, Fornecedor> getMapaFornecedores() {
		return mapaFornecedores;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
