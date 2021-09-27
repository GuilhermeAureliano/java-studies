package saga;
/**
 * Classe que representa um cliente. Todo clientem nome, email, cpf e local onde trabalha.
 * @author Guilherme Aureliano - 119210371
 *
 */
public class Cliente implements Comparable<Cliente> {
	
	private String nome;
	private String local;
	private String email;
	private String cpf;
	
	/**
	 * Cria um cliente a partir de seus respectivos dados.
	 * @param cpf CPF do cliente. 
	 * @param nome Nome do cliente.
	 * @param email Email do cliente.
	 * @param local Local de trabalho do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String local) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.local = local;
	}
	
	/**
	 * Método que retorna uma representação do cliente no seguinte formato: NOME - LOCAL DE TRABALHO - EMAIL.
	 * @return Uma String que representa o cliente.
	 */
	public String toString() {
		return getNome() + " - " + getLocal() + " - " + getEmail();
	}
	
	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareTo(o.getNome());
	}
	
	
}
