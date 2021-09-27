package lab_04_guilherme_aureliano;

/**
 * Classe que representa um grupo. Todo grupo tem um nome e um conjunto de alunos que fazem parte desse grupo.
 * O grupo é identificado pelo seu nome.
 * @author Guilherme Aureliano - 119210371
 */

import java.util.HashSet;

public class Grupo {
	
	private String nomeGrupo;
	private HashSet<Aluno> conjuntoAlunos;
	
	/**
	 * Constrói um grupo a partir do seu nome.
	 * E cria um conjunto de alunos que pertencem ao grupo.
	 * @param nomeGrupo O nome do grupo
	 */
	public Grupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.conjuntoAlunos = new HashSet<>();
	}
	
	/**
	 * Método que adiciona alunos no grupo.
	 * @param aluno O próprio aluno que deve ser adicionado
	 */
	public void alocarAluno(Aluno aluno) {
		this.conjuntoAlunos.add(aluno);
	}
	
	/**
	 * Método que representa os alunos do grupo em formato de uma String.
	 * Caso não tenha nenhum aluno, exibe a mensagem "Nenhum aluno foi cadastrado." 
	 * @return Uma String que representa os alunos do grupo.
	 */
	public String toString() {
		String retorno = "";
		for (Aluno aluno: this.conjuntoAlunos) {
			retorno += "* " + aluno.toString() + "\n";
		}
		if (retorno == "") {
			return "* Nenhum aluno foi cadastrado. \n";
		}
		return retorno;
	}
	
	/**
	 * Método que calcula o número hash do Grupo.
	 * @return Um valor inteiro que representa o número hash do objeto Grupo.
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	
	/**
	 * Método que testa se dois objetos são iguais, nesse caso, se o nome do grupo são iguais.
	 * @return Um valor booleano que representa se são iguais ou não.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
}
