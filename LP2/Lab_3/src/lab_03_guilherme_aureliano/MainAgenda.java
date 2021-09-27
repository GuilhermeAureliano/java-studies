package lab_03_guilherme_aureliano;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(T)elefones preferidos\n" +
						"(Z)aps\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "T":
			telefonesPreferidos(agenda);
			break;
		case "Z":
			telefonesZaps(agenda);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * Imprime os telefones prioritários dos contatos da agenda.
	 * Caso não tenha telefone prioriário, exibe a mensagem no seguindo formato: "nome - Não tem".
	 * @param agenda A agenda que estamos manipulando
	 */
	private static void telefonesPreferidos(Agenda agenda) {
		System.out.println("Telefones prioritários: ");
		String[] contatos = agenda.getContatos();
		String[] prioritarios = agenda.getPrioritarios();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.print(contatos[i] + " - ");
				if (prioritarios[i] == null) {
					System.out.println("Não tem");
				} else {
					System.out.println(prioritarios[i]);
				}
			}
		}
	}
	/**
	 * Imprime os telefones do whatsapp dos contatos da agenda.
	 * Caso não tenha whatsapp, exibe a seguinte mensagem: "nome - Não tem".
	 * @param agenda Agenda que estamos manipulando.
	 */
	private static void telefonesZaps(Agenda agenda) {
		System.out.println("Contatos whatsapps: ");
		String[] contatos = agenda.getContatos();
		String[] zaps = agenda.getZaps();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.print(contatos[i] + " - ");
				if (zaps[i] == null) {
					System.out.println("Não tem");
				}
				else {
					System.out.println(zaps[i]);
				}
			}
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		String contato = agenda.getContato(posicao);
		System.out.println("Dados do contato:\n" + formataContato(posicao, contato));
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (posicao < 1 || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA!");
		} else {
			scanner.nextLine();
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			GuiUtil.entradaVazia(nome, "Nome inválido");
			GuiUtil.entradaVazia(nome, "Nome inválido");
			
			System.out.print("Sobrenome: ");
			String sobrenome = scanner.nextLine();
			GuiUtil.entradaVazia(sobrenome, "Sobrenome inválido");
			GuiUtil.entradaVazia(sobrenome, "Sobrenome inválido");
			
			System.out.print("Telefone1: ");
			String telefone1 = scanner.nextLine();
			GuiUtil.entradaVazia(telefone1, "Espera-se pelo menos 1 telefone");
			GuiUtil.entradaVazia(telefone1, "Espera-se pelo menos 1 telefone");
			
			System.out.print("Telefone2: ");
			String telefone2 = scanner.nextLine();
			System.out.print("Telefone3: ");
			String telefone3 = scanner.nextLine();
			
			System.out.print("Telefone prioritário: ");
			String principal = scanner.nextLine();
			GuiUtil.entradaVazia(principal, "Telefone prioritário inválido");
			GuiUtil.entradaVazia(principal, "Telefone prioritário inválido");
			
			System.out.print("Contato whatsapp: ");
			String whats = scanner.nextLine();

			principal = "1".equals(principal) ? telefone1 : principal;
			principal = "2".equals(principal) ? telefone2 :principal;
			principal = "3".equals(principal) ? telefone3 :principal;
			whats = "1".equals(whats) ? telefone1 : whats;
			whats = "2".equals(whats) ? telefone2 : whats;
			whats = "3".equals(whats) ? telefone3 : whats;
			if (whats.equals(" ")) {
				whats = null;
			}
			if (telefone3.equals(" ")) {
				telefone3 = null;
			}
			if (principal.equals(" ")) {
				principal = null;
			}
			agenda.cadastraContato(posicao, nome, sobrenome, principal, whats, telefone3);
			System.out.println("CADASTRO REALIZADO");	
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {

		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	
}

