import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab_04_guilherme_aureliano.ControleAluno;

class ControleAlunoTest {

	private ControleAluno controleAluno;
	
	@BeforeEach
	void setup() {
		this.controleAluno = new ControleAluno();
		this.controleAluno.cadastrarAluno("250", "Guilherme Aureliano", "Computação");
		this.controleAluno.cadastrarAluno("999", "Gabigol", "Futebol");
		this.controleAluno.cadastrarGrupo("FMCC2");
	}
	
	@Test
	void testCadastrarAluno() {
		assertEquals("CADASTRO REALIZADO! \n", this.controleAluno.cadastrarAluno("111", "Matheus", "CC"));
		assertEquals("MATRÍCULA JÁ CADASTRADA! \n", this.controleAluno.cadastrarAluno("111", "Guilherme Aureliano", "Computação"));
		assertEquals("MATRÍCULA JÁ CADASTRADA! \n", this.controleAluno.cadastrarAluno("250", "Guilherme Aureliano", "Computação"));
	}
	
	@Test
	void testExisteAluno() {
		assertTrue(this.controleAluno.existeAluno("250"));
		assertTrue(this.controleAluno.existeAluno("999"));
		assertFalse(this.controleAluno.existeAluno("333"));
	}
	
	@Test
	void testConsultarAluno() {
		assertEquals("Aluno não cadastrado. \n", this.controleAluno.consultarAluno("333"));
		assertEquals("Aluno: 250 - Guilherme Aureliano - Computação" + "\n", this.controleAluno.consultarAluno("250"));
		assertEquals("Aluno: 999 - Gabigol - Futebol" + "\n", this.controleAluno.consultarAluno("999"));
	}
	
	@Test
	void testCadastrarGrupo() {
		assertEquals("CADASTRO REALIZADO! \n", this.controleAluno.cadastrarGrupo("Listas"));
		assertEquals("GRUPO JÁ CADASTRADO! \n", this.controleAluno.cadastrarGrupo("Listas"));
		assertEquals("GRUPO JÁ CADASTRADO! \n", this.controleAluno.cadastrarGrupo("FMCC2"));
	}
	
	@Test
	void testExisteGrupo() {
		assertTrue(this.controleAluno.existeGrupo("FMCC2"));
		assertFalse(this.controleAluno.existeGrupo("Listas"));
		assertFalse(this.controleAluno.existeGrupo("Informática"));
	}
	
	@Test
	void testAlocarAluno() {
		assertEquals("Aluno não cadastrado. \n", this.controleAluno.alocarAluno("333", "FMCC2"));
		assertEquals("ALUNO ALOCADO! \n", this.controleAluno.alocarAluno("250", "FMCC2"));
		assertEquals("Grupo não cadastrado. \n", this.controleAluno.alocarAluno("999", "Informática"));
	}
	
	@Test
	void testImprimirGrupos() {
		assertEquals("Grupo não cadastrado. \n", this.controleAluno.imprimirGrupos("React"));
		this.controleAluno.cadastrarGrupo("React");
		this.controleAluno.alocarAluno("250", "React");
		assertEquals("* 250 - Guilherme Aureliano - Computação" + "\n", this.controleAluno.imprimirGrupos("React"));
		this.controleAluno.alocarAluno("999", "React");
		assertEquals("* 999 - Gabigol - Futebol" + "\n" + 
					 "* 250 - Guilherme Aureliano - Computação" + "\n", this.controleAluno.imprimirGrupos("React"));
	}
	
	@Test
	void testCadastrarAlunosQueResponderam() {
		assertEquals("Aluno não cadastrado. \n", this.controleAluno.cadastrarAlunosQueResponderam("333"));
		assertEquals("ALUNO REGISTRADO! \n", this.controleAluno.cadastrarAlunosQueResponderam("250"));
	}
	
	@Test
	void testImprimirAlunosQueResponderam() {
		this.controleAluno.cadastrarAlunosQueResponderam("250");
		assertEquals("1. 250 - Guilherme Aureliano - Computação" + "\n", 
				this.controleAluno.imprimirAlunosQueResponderam());
		this.controleAluno.cadastrarAlunosQueResponderam("999");
		assertEquals("1. 250 - Guilherme Aureliano - Computação" + "\n" + 
					 "2. 999 - Gabigol - Futebol" + "\n", this.controleAluno.imprimirAlunosQueResponderam());
	}
}