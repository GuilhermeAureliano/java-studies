package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/**
 * Classe que representa um fornecedor. Todo fornecedor tem nome, email e telefone.
 * Além disso, todo fornecedor tem produtos e contas no sistema.
 * @author Guilherme
 *
 */
public class Fornecedor implements Comparable<Fornecedor>{
	
	private String nome;
	private String email;
	private String telefone;
	private HashMap<ProdutoID, Produto> mapaProdutos;
	private HashMap<Cliente, Conta> mapaContas;
	
	/**
	 * Cria um fornecedor a partir de seu nome, email e telefone.
	 * @param nome Nome do fornecedor.
	 * @param email Email do fornecedor.
	 * @param telefone Telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mapaProdutos = new HashMap<>();
		this.mapaContas = new HashMap<>();
	}
	
	public String toString() {
		return getNome() + " - " + getEmail() + " - " + getTelefone();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.getNome());
	}
	
	public void adicionaProduto(String nomeProduto, String descricao, double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if (existeProduto(nomeProduto, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		} else {
			ProdutoFinal produtoFinal = new ProdutoFinal(nomeProduto, descricao, preco);
			ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
			this.mapaProdutos.put(produtoID, produtoFinal);
		}
	}
	
	/**
	 * Método que verifica se um determinado produto existe no sistema a partir de seu nome e descrição.
	 * @param nomeProduto Nome do produto.
	 * @param descricao Descrição do produto.
	 * @return
	 */
	public boolean existeProduto(String nomeProduto, String descricao) {
		ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
		if (this.mapaProdutos.containsKey(produtoID)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método que indentifica e pega determinado produto e o retorna para poder ser acessado por outros métodos.
	 * @param nomeProduto Nome do produto.
	 * @param descricao Descrição do produto.
	 * @return Retorna o próprio produto.
	 */
	public Produto getProduto(String nomeProduto, String descricao) {
		ProdutoID produtoID = new ProdutoID (nomeProduto, descricao);
		return this.mapaProdutos.get(produtoID);
	}
	
	public String exibeProduto(String nomeProduto, String descricao) {
		if (existeProduto(nomeProduto, descricao)) {
			return getProduto(nomeProduto, descricao).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
	}
	
	public String exibeProdutosFornecedor() {
		String retorno = "";
		
		List<Produto> listaProdutos= new ArrayList<Produto>();
		listaProdutos.addAll(this.mapaProdutos.values());
		
		if (listaProdutos.size() != 0) {
			Collections.sort(listaProdutos);
			
			for (Produto produto: listaProdutos) {
				retorno+= this.nome + " - " + produto.toString() + " | ";
			}
			
			retorno = retorno.substring(0, retorno.length() -3);
			return retorno;
		}
		else {
			return this.nome + " -";
		}
	}
	
	public void editaProduto(String nomeProduto, String descricao, double novoPreco) {
		if (existeProduto(nomeProduto, descricao)) {
			getProduto(nomeProduto, descricao).setPreco(novoPreco);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
	}
	
	public void removeProduto(String nomeProduto, String descricao) {
		if (existeProduto(nomeProduto, descricao)) {
			ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
			this.mapaProdutos.remove(produtoID);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
	}
	
	public void adicionaCompra(Cliente cliente, String data, String nomeProduto, String descricao) {
		if (existeProduto(nomeProduto, descricao)) {
			ProdutoID produtoID = new ProdutoID(nomeProduto, descricao);
			double preco = this.mapaProdutos.get(produtoID).getPreco();
			
			if (this.mapaContas.containsKey(cliente)) {
				this.mapaContas.get(cliente).adicionaCompra(data, nomeProduto, descricao, preco);
			} else {
				Conta conta = new Conta();
				conta.adicionaCompra(data, nomeProduto, descricao, preco);
				this.mapaContas.put(cliente, conta);
			}
			
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
	}
	
	public String getDebito(Cliente cliente) {
		if (this.mapaContas.containsKey(cliente)) {
			return this.mapaContas.get(cliente).getDebito();
		} else {
			 throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
	}
	
	public String exibeContas(Cliente cliente, String fornecedor) {
		
		if (this.mapaContas.containsKey(cliente)) {
			return "Cliente: " + cliente.getNome()+ " | " + this.mapaContas.get(cliente).exibeContas(this.getNome());
		} else {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}
	
	public String exibeContasCliente(Cliente cliente) {
		if (this.mapaContas.containsKey(cliente)) {
			return this.mapaContas.get(cliente).exibeContas(this.getNome());
		}
		return null;
	}
	
	/**
	 * Método que retorna o mapa de produtos que será acessado por outra classe.
	 * @return Retorna o mapa de produtos.
	 */
	public HashMap<ProdutoID, Produto> getMapaProdutos() {
		return mapaProdutos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
