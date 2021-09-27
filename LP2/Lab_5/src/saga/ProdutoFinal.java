package saga;

/**
 * Classe que representa o produto do fornecedor. Todo produto tem nome, descrição e preço.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class ProdutoFinal implements Produto {

	private String nomeProduto;
	private String descricao;
	private double preco;
	
	/**
	 * Cria um produto a partir de seu nome, descrição e preço.
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 */
	public ProdutoFinal(String nomeProduto, String descricao, double preco) {
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco =  preco;
	}
	
	public String toString() {
		return String.format("%s - %s - R$%.2f", this.getNome(), this.getDescricao(), this.getPreco());
	}

	public String getNome() {
		return nomeProduto;
	}

	public void setNome(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
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
		ProdutoFinal other = (ProdutoFinal) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		return true;
	}

	@Override
	public int compareTo(Produto o) {
		return this.nomeProduto.compareTo(o.getNome());
	}
	
	
	
	
}
