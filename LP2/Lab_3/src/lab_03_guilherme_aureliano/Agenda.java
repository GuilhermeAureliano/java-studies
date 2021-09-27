package lab_03_guilherme_aureliano;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 101;
	
	private String[] contatos;
	private String[] telefonesPrincipais;
	private String[] telefonesZaps;
	private String[] telefone_3;
	
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new String[TAMANHO_AGENDA];
		this.telefonesPrincipais = new String[TAMANHO_AGENDA];
		this.telefonesZaps = new String[TAMANHO_AGENDA];
		this.telefone_3 = new String[TAMANHO_AGENDA];
	}
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		return this.contatos.clone();
	}
	
	/**
	 * Acessa a lista de contatos prioritários.
	 * @return O array de contatos prioritários.
	 */
	public String[] getPrioritarios() {
		return this.telefonesPrincipais.clone();
	}
	
	/**
	 * Acessa a lista de contatos com whatsapp.
	 * @return O array de contatos do whatsapp.
	 */
	public String[] getZaps() {
		return this.telefonesZaps.clone();
	}
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Os dados do contato na posição passada como parâmetro. Caso não tenha contato na posição passada, retorna "POSIÇÃO INVÁLIDA".
	 */
	public String getContato(int posicao) {
		if (posicao < 0 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA!";
		}
		String retorno = "";
		int cont = 0;
		for (int i = 0; i < this.contatos.length; i++) {
			if ((i + 1) == posicao && contatos[posicao] != null) {
				retorno += contatos[posicao] + "\n";
				cont++;
			}
		}
		for (int p = 0; p < this.telefonesPrincipais.length; p++) {
			if ((p + 1) == posicao && telefonesPrincipais[posicao] != null) {
				retorno += telefonesPrincipais[posicao] + " (prioritário) \n";
			} else if ((p + 1) == posicao && (telefonesPrincipais[posicao] == null)){
				retorno += "Não tem (prioritário) \n";
			}			
		}
		for (int z = 0; z < this.telefonesZaps.length; z++) {
			if ((z + 1) == posicao && telefonesZaps[posicao] != null) {
				retorno += telefonesZaps[posicao] + " (zap)";
			} else if ((z + 1) == posicao && telefonesZaps[posicao] == null){
				retorno += "Não tem (zap)";
			}
		}
		if (cont == 0) {
			return "POSIÇÃO INVÁLIDA!";
		} else {
			return retorno;		
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato .
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param principal Telefone prioritário do contato.
	 * @param whats Whatsapp do contato.
	 * @param telefone3 Terceiro telefone do contato.
	 * 
	 * @return Um valor booleano que indica se o cadastrado foi efetuado ou não.
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String principal, String whats, String telefone3) {
		if (posicao > 0 && posicao < 101) {
			this.contatos[posicao] = nome + " " + sobrenome;
			this.telefonesPrincipais[posicao] = principal;
			this.telefonesZaps[posicao] = whats;
			this.telefone_3[posicao] = telefone3;
			return true;			
		} else {
			return false;
		}
	}
	
	/**
	 * Testa se duas agendas são iguais. Elas serão iguais se tiverem os mesmos contatos nas mesmas posições.
	 * 
	 * @return Um valor booleano que indica se elas são iguais ou não.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		
		return true;
	}
}
