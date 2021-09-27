import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab_03_guilherme_aureliano.Agenda;

class AgendaTest {
	
	private Agenda agendaTest_1;
	private Agenda agendaTest_2;
	private Agenda agendaTest_3;
	private Agenda agendaTest_4;
	
	@BeforeEach
	public void criaAgenda() {
		this.agendaTest_1 = new Agenda();
		this.agendaTest_2 = new Agenda();
		this.agendaTest_3 = new Agenda();
		this.agendaTest_4 = new Agenda();
		
		this.agendaTest_1.cadastraContato(12, "Guilherme", "Aureliano", "111", "222", "333");
		this.agendaTest_1.cadastraContato(80, "Neymar", "Junior", "555", "+271 3131", "111");
		
		this.agendaTest_2.cadastraContato(12, "Guilherme", "Aureliano", "111", "222", "333");
		this.agendaTest_2.cadastraContato(80, "Neymar", "Junior", "555", "+271 3131", "111");
		
		this.agendaTest_4.cadastraContato(12, "Guilherme", "Aureliano", "111", "222", "333");
		this.agendaTest_4.cadastraContato(80, "Neymar", "Junior", "555", "+271 3131", "111");
	}
	
	
	@Test
	public void testCadastroEfetuado () {
		assertEquals(true, this.agendaTest_1.cadastraContato(1, "Tommy", "Shelby", "+399 1111", null, null));
		assertEquals(false, this.agendaTest_1.cadastraContato(0, "Matheus", "Gaudêncio", "83 77777",  "83 33231", "424235"));
		assertEquals(true, this.agendaTest_1.cadastraContato(100, "Gabigol", "Framengo", "81 1111",  "4444", null));
		assertEquals(false, this.agendaTest_4.cadastraContato(101, "Homem", "Aranha", "+288 9999", "2222", " "));

		
	}
	
	@Test
	public void testgetContato() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agendaTest_1.getContato(10));
		assertEquals("Guilherme Aureliano" + "\n" + 
					 "111 (prioritário) " + "\n" + 
					 "222 (zap)", this.agendaTest_1.getContato(12));
		assertEquals("POSIÇÃO INVÁLIDA!", this.agendaTest_1.getContato(0));
		assertEquals("POSIÇÃO INVÁLIDA!", this.agendaTest_1.getContato(101));
		assertEquals("Neymar Junior" + "\n" + 
					 "555 (prioritário) " + "\n" +
				     "+271 3131 (zap)", this.agendaTest_1.getContato(80));
	}
	
	@Test
	public void testEqualsObject() {
		assertTrue(this.agendaTest_1.equals(agendaTest_2));
		assertFalse(this.agendaTest_1.equals(agendaTest_3));
		assertTrue(this.agendaTest_1.equals(agendaTest_4));
	}
	
}
