package sagaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saga.Cliente;

class ClienteTest {

	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	
	@BeforeEach
	void criaCliente() {
		this.cliente1 = new Cliente("88888888888", "Gabriel Barbosa", "gabigol@gmail.com", "RJ");
		this.cliente2 = new Cliente("77777777777", "Pedro Queixada", "queixada@gmail.com", "RJ");
		this.cliente3 = new Cliente("88888888888", "Tommy Shelby", "shelby@gmail.com", "UK");
	}
	
	@Test
	void testToString() {
		assertEquals("Gabriel Barbosa - RJ - gabigol@gmail.com", this.cliente1.toString());
		assertEquals("Pedro Queixada - RJ - queixada@gmail.com", this.cliente2.toString());
		assertEquals("Tommy Shelby - UK - shelby@gmail.com", this.cliente3.toString());
	}
	
	@Test
	void testHashCode() {
		assertEquals(this.cliente1.hashCode(), this.cliente3.hashCode());
		assertNotEquals(this.cliente1.hashCode(), this.cliente2.hashCode());
		assertNotEquals(this.cliente2.hashCode(), this.cliente3.hashCode());
	}
	
	@Test
	void testEquals() {
		assertTrue(this.cliente1.equals(cliente3));
		assertFalse(this.cliente1.equals(cliente2));
		assertFalse(this.cliente2.equals(cliente3));
	}
	
	

}
