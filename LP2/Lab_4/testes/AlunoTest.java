import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab_04_guilherme_aureliano.*;

class AlunoTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@BeforeEach
	void criaAluno() {
		this.aluno1 = new Aluno("250", "Jax Teller", "CC");
		this.aluno2 = new Aluno("999", "Tommy Shelby", "Mecânica");
		this.aluno3 = new Aluno("250", "Jax Teller", "CC");
	}
	@Test
	void testToString() {
		assertEquals("250 - Jax Teller - CC", this.aluno1.toString());
		assertEquals("999 - Tommy Shelby - Mecânica", this.aluno2.toString());
		assertEquals("250 - Jax Teller - CC", this.aluno3.toString());
	}
	@Test
	void testHashCode() {
		assertEquals(this.aluno1.hashCode(), this.aluno3.hashCode());
		assertNotEquals(this.aluno1.hashCode(), this.aluno2.hashCode());
	}
	
	@Test
	void testEquals() {
		assertTrue(this.aluno1.equals(aluno3));
		assertFalse(this.aluno1.equals(aluno2));
	}
}
