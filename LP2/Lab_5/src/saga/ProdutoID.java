package saga;

/**
 * Classe que serve com ID de um produto a partir de seu nome e descrição.
 * @author Guilherme
 *
 */
public class ProdutoID {
	
	private String nomeProduto;
	private String descricao;
	
	/**
	 * Cria o ID do produto a partir do nome e descrição.
	 * @param nomeProduto Nome do produto. 
	 * @param descricao Descrição do produto.
	 */
	public ProdutoID(String nomeProduto, String descricao) {
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		ProdutoID other = (ProdutoID) obj;
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
	
}
