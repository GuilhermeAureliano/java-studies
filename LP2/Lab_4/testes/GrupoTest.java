import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab_04_guilherme_aureliano.*;

class GrupoTest {
	
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;
	private Aluno aluno;
	
	@BeforeEach
	void criaGrupo() {
		this.grupo1 = new Grupo("Lista");
		this.grupo2 = new Grupo("Lista");
		this.grupo3 = new Grupo("Futebol");
		this.aluno = new Aluno("250", "Jax Teller", "CC");
	}

	@Test
	void testToString() {
		this.grupo1.alocarAluno(aluno);
		assertEquals("* 250 - Jax Teller - CC" + "\n", this.grupo1.toString());
	}
	
	@Test
	void testHashCode() {
		assertEquals(this.grupo1.hashCode(), this.grupo2.hashCode());
		assertNotEquals(this.grupo1.hashCode(), this.grupo3.hashCode());
	}
	
	@Test
	void tesEquals() {
		assertTrue(this.grupo1.equals(this.grupo2));
		assertTrue(this.grupo2.equals(this.grupo1));
		assertFalse(this.grupo1.equals(this.grupo3));
	}

}
