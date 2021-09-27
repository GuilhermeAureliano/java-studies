package lab_04_guilherme_aureliano;

/**
 * Classe que faz o controle do aluno através de mapas e array list.
 * Essa classe é responsável por cadastrar alunos e grupos, consultar aluno, alocar aluno, 
 * além de cadastrar e imprimir alunos que responderam.
 * @author Guilherme Aureliano - 119210371
 */

import java.util.ArrayList;
import java.util.HashMap;

public class ControleAluno {
	
	private HashMap<String, Aluno> mapaAluno;
	private HashMap<String, Grupo> mapaGrupo;
	private ArrayList<Aluno> listaAlunosQueResponderam;
	
	/**
	 * Constrói o controle de Aluno.
	 * Cria o mapa de aluno, mapa de grupo e lista de alunos que responderam.
	 */
	public ControleAluno() {
		this.mapaAluno = new HashMap<>();
		this.mapaGrupo = new HashMap<>();
		this.listaAlunosQueResponderam = new ArrayList<>();
	}
	
	/**
	 * Método que verifica se o aluno está cadastrado através de sua matrícula.
	 * @param matricula É a matrícula que representa o aluno e que é usada como chave do mapa.
	 * @return Um valor booleano indicando se o aluno está cadastrado ou não.
	 */
	public boolean existeAluno(String matricula) {
		return this.mapaAluno.containsKey(matricula);
	}
	
	/**
	 * Método que cadastra o aluno.
	 * Primeiro, verifica se sua matrícula já foi cadastrada ou não. Caso não tenha sido cadastrada,
	 * o aluno é adicionado ao mapa onde sua matrícula é a chave, e o valor é o próprio aluno.
	 * @param matricula A matrícula do aluno
	 * @param nome O Nome do aluno
	 * @param curso O curso do aluno
	 * @return Uma String indicando se o aluno foi cadastrado, ou se sua matrícula já está cadastrada.
	 */
	public String cadastrarAluno(String matricula, String nome, String curso) {
		if (existeAluno(matricula) == false) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.mapaAluno.put(matricula, aluno);	
			return "CADASTRO REALIZADO! \n";
		}
		return "MATRÍCULA JÁ CADASTRADA! \n";
	}
	
	/**
	 * Método que consulta se o aluno existe através da sua matrícula.
	 * Caso exista, ele o exibe no formato de "Aluno: MATRÍCULA - NOME - CURSO".
	 * @param matricula A matrícula do aluno
	 * @return Uma String que exibe o aluno caso ele exista, senão, exibe a mensagem "Aluno não cadastrado. ".
	 */
	public String consultarAluno(String matricula) {
		if (existeAluno(matricula) == true) {
			Aluno aluno = this.mapaAluno.get(matricula);
			return "Aluno: " + aluno.toString() + "\n"; 
		}
		return "Aluno não cadastrado. \n";
	}
	
	/**
	 * Método que verifica se o grupo, através de seu nome, está cadastrado ou não.
	 * @param nome O nome do grupo
	 * @return Um valor booleano indicando se o grupo já foi cadastrado ou não.
	 */
	public boolean existeGrupo(String nome) {
		return this.mapaGrupo.containsKey(nome);
	}
	
	/**
	 * Método que cadastra um grupo.
	 * Primeiro, verifica se o nome do grupo já foi cadastrado ou não. Caso não tenha sido cadastrado,
	 * o grupo é adicionado ao mapa onde o nome do grupo é a chave, e o valor é o próprio grupo.
	 * @param nomeGrupo O nome do grupo
	 * @return Uma String indicando se o grupo foi cadastrado, ou se o grupo já está cadastrado.
	 */
	public String cadastrarGrupo(String nomeGrupo) {
		if (existeGrupo(nomeGrupo) == false) {
			Grupo grupo = new Grupo(nomeGrupo);
			this.mapaGrupo.put(nomeGrupo, grupo);
			return "CADASTRO REALIZADO! \n";
		}
		return "GRUPO JÁ CADASTRADO! \n";
	}
	
	/**
	 * Método que aloca um aluno para o grupo que é passado como parâmetro.
	 * Primeiro, verifica se a matrícula passada como parâmetro existe no mapa de alunos.
	 * Segundo, verifica se o nome do grupo passado como parâmetro existe no mapa de grupos.
	 * Caso a matrícula e o grupo existam, o aluno é alocado para o grupo.
	 * @param matricula A matrícula do aluno
	 * @param nomeGrupo O nome do grupo
	 * @return Uma String indicando se o aluno foi alocado ou não.
	 */
	public String alocarAluno(String matricula, String nomeGrupo) {
		if (existeAluno(matricula) == false) {
			return "Aluno não cadastrado. \n";
		}
		if (existeGrupo(nomeGrupo) == false) {
			return "Grupo não cadastrado. \n";
		}
		Grupo grupo = this.mapaGrupo.get(nomeGrupo);
		Aluno aluno = this.mapaAluno.get(matricula);
		
		grupo.alocarAluno(aluno);
		return "ALUNO ALOCADO! \n";
	}
	
	/**
	 * Método que imprime o grupo e os alunos cadastrados nesse grupo.
	 * Primeiro, verifica se o grupo existe. Caso não exista, exibe a mensagem "Grupo não cadastrado".
	 * @param nomeGrupo O nome do grupo
	 * @return Uma String de todos os alunos cadastrados nesse grupo caso o grupo exista.
	 */
	public String imprimirGrupos(String nomeGrupo) {
		if (existeGrupo(nomeGrupo) == false) {
			return "Grupo não cadastrado. \n";
		}
		Grupo grupo = this.mapaGrupo.get(nomeGrupo);
		return grupo.toString();
	}
	
	/**
	 * Método que que cadastra alunos que responderam.
	 * Primeiro, verifica se a matrícula passada como parâmetro existe.
	 * @param matricula A matrícula do aluno
	 * @return Uma String informando se o aluno foi registrado ou não.
	 */
	public String cadastrarAlunosQueResponderam(String matricula) {
		if (existeAluno(matricula) == false) {
			return "Aluno não cadastrado. \n";
		}
		Aluno aluno = this.mapaAluno.get(matricula);
		this.listaAlunosQueResponderam.add(aluno);
		return "ALUNO REGISTRADO! \n";
	}
	
	/**
	 * Método que imprime a lista com o nome e a matrícula dos alunos que responderam.
	 * Caso nenhuma aluno tenha respondido, exibe a mensagem "Nenhum aluno respondeu.".
	 * @return Uma String que representa a lista dos alunos que responderam.
	 */
	public String imprimirAlunosQueResponderam() {
		String retorno = "";
		for(int i = 0; i < this.listaAlunosQueResponderam.size(); i++) {
			retorno += (i+1) + ". " + this.listaAlunosQueResponderam.get(i).toString() + "\n";
		}
		if (retorno == "") {
			return "Nenhum aluno respondeu. \n";
		}
		return retorno;
	}
}
