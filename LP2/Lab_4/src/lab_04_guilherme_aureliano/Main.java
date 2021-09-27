package lab_04_guilherme_aureliano;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static ControleAluno controleAluno = new ControleAluno();
	private static int CONTADOR_DE_GRUPOS = 0;
	private static int CONTADOR_ALUNOS_QUE_RESPONDERAM = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			String opcao = menu(input);
			comando(opcao);
		}
	}
	
	private static String menu(Scanner input){
		System.out.print(
				"(C)adastrar Aluno \n" +
				"(E)xibir Aluno \n" + 
				"(N)ovo Grupo \n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos \n" + 
				"(R)egistrar Aluno que Respondeu \n" +
				"(I)mprimir Alunos que Responderam \n" + 
				"(O)ra, vamos fechar o programa! \n");
		System.out.print("\nOpção> ");
		return input.next().toUpperCase();
	}
	
	private static void comando(String opcao) {
		switch (opcao) {
		case "C":
			cadastrarAluno();
			break;
		case "E":
			consultarAluno();
			break;
		case "N":
			cadastrarGrupo();
			break;
		case "A":
			alocarAndImprimir();
			break;
		case "R":
			registrarAlunoQueRespondeu();
			break;
		case "I":
			imprimirAlunosQueResponderam();
			break;
		case "O":
			fecharPrograma();
			break;
		default:
			System.out.println("Opção inválida! \n");	
		}
	}
	private static void fecharPrograma() {
		System.out.println("\nPrograma encerrado!");
		System.exit(0);
	}
	private static void cadastrarAluno() {
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		GuiUtil.verificaStringNull(matricula, "Não pode matrícula nula.");
		GuiUtil.verificaStringVazia(matricula, "Não pode matrícula vazia.");
		
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		GuiUtil.verificaStringNull(nome, "Não pode nome nulo.");
		GuiUtil.verificaStringVazia(nome, "Não pode nome vazio.");
		
		System.out.println("Curso: ");
		String curso = sc.nextLine();
		GuiUtil.verificaStringNull(curso, "Não pode curso nulo.");
		GuiUtil.verificaStringVazia(curso, "Não pode curso vazio.");
		
		System.out.println(controleAluno.cadastrarAluno(matricula, nome, curso));
	}
	
	private static void consultarAluno() {
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		GuiUtil.verificaStringNull(matricula, "Não pode matrícula nula.");
		GuiUtil.verificaStringVazia(matricula, "Não pode matrícula vazia.");
		
		System.out.println(controleAluno.consultarAluno(matricula));
	}
	
	private static void cadastrarGrupo() {
		System.out.println("Grupo: ");
		String nomeGrupo = sc.nextLine().toUpperCase();
		GuiUtil.verificaStringNull(nomeGrupo, "Não pode grupo nulo.");
		GuiUtil.verificaStringVazia(nomeGrupo, "Não pode grupo vazio.");
		
		System.out.println(controleAluno.cadastrarGrupo(nomeGrupo));
		CONTADOR_DE_GRUPOS += 1;
	}
	
	private static void alocarAndImprimir() {
		System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
		String comando = sc.nextLine().toUpperCase();
		
		if (comando.equals("A")) {
			System.out.println("Matrícula: ");
			String matricula = sc.nextLine();
			GuiUtil.verificaStringNull(matricula, "Não pode matrícula nula.");
			GuiUtil.verificaStringVazia(matricula, "Não pode matrícula vazia.");
			
			System.out.println("Grupo: ");
			String nomeGrupo = sc.nextLine().toUpperCase();
			GuiUtil.verificaStringNull(nomeGrupo, "Não pode grupo nulo.");
			GuiUtil.verificaStringVazia(nomeGrupo, "Não pode grupo vazio.");
			
			System.out.println(controleAluno.alocarAluno(matricula, nomeGrupo));
		} else if (comando.equals("I")) {
			System.out.println("Grupo: ");
			String nomeGrupo = sc.nextLine().toUpperCase();
			GuiUtil.verificaStringNull(nomeGrupo, "Não pode grupo nulo.");
			GuiUtil.verificaStringVazia(nomeGrupo, "Não pode grupo vazio.");
			
			if (CONTADOR_DE_GRUPOS > 0) { // Verifica se já foi cadastrado pelo menos 1 grupo.
				System.out.println("Alunos do grupo " + nomeGrupo + ":");				
			}
			System.out.println(controleAluno.imprimirGrupos(nomeGrupo));
		}
	}
	
	private static void registrarAlunoQueRespondeu() {
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		GuiUtil.verificaStringNull(matricula, "Não pode matrícula nula.");
		GuiUtil.verificaStringVazia(matricula, "Não pode matrícula vazia.");
		
		System.out.println(controleAluno.cadastrarAlunosQueResponderam(matricula));
		CONTADOR_ALUNOS_QUE_RESPONDERAM += 1;
	}
	
	private static void imprimirAlunosQueResponderam() {
		if (CONTADOR_ALUNOS_QUE_RESPONDERAM > 0) { // Verifica se pelo menos 1 aluno respondeu.
			System.out.println("Alunos: ");			
		}
		System.out.println(controleAluno.imprimirAlunosQueResponderam());
	}	
}
