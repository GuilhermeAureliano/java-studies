package sagaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saga.Cliente;
import saga.Fornecedor;

class FornecedorTest {

	private Fornecedor fornecedor1;
	private Fornecedor fornecedor2;
	private Fornecedor fornecedor3;
	private Cliente cliente;
	private Cliente cliente2;
	
	@BeforeEach
	void criaFornecedor() {
		this.fornecedor1 = new Fornecedor("Adilson", "adilson@gmail.com", "111");
		this.fornecedor2 = new Fornecedor("Gustavo", "gustavo@gmail.com", "222");
		this.fornecedor3 = new Fornecedor("Gustavo", "guga@gmail.com", "333");
		this.cliente = new Cliente("88888888888", "Tommy Shelby", "shelby@gmail.com", "UK");
		this.cliente2 = new Cliente("12345678912", "Guigol", "gol@gmail.com", "RJ");
	}

	@Test
	void testToString() {
		assertEquals("Adilson - adilson@gmail.com - 111", this.fornecedor1.toString());
		assertEquals("Gustavo - gustavo@gmail.com - 222", this.fornecedor2.toString());
		assertNotEquals("333 - Gustavo - guga@gmail.com", this.fornecedor3.toString());
	}
	
	@Test
	void testHashCode() {
		assertEquals(this.fornecedor1.hashCode(), this.fornecedor1.hashCode());
		assertEquals(this.fornecedor2.hashCode(), this.fornecedor3.hashCode());
		assertNotEquals(this.fornecedor3.hashCode(), this.fornecedor1.hashCode());
	}
	
	@Test
	void testEquals() {
		assertFalse(this.fornecedor1.equals(fornecedor2));
		assertTrue(this.fornecedor2.equals(fornecedor3));
		assertFalse(this.fornecedor3.equals(fornecedor1));
	}
	
	@Test
	void testAdicionaProduto() {
		this.fornecedor1.adicionaProduto("Celular", "Iphone", 9.99);
		this.fornecedor1.adicionaProduto("Celular", "Android", 5.75);
		this.fornecedor2.adicionaProduto("Pão", "Franch", 0.5);
		this.fornecedor3.adicionaProduto("Caneta", "Azul", 0.3);
		
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor1.adicionaProduto("Celular", "Iphone", 9.99)); // produto já existe
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor1.adicionaProduto("Ps5", "Original", -5.00)); // preço inválido
		
		
	}
	
	@Test
	void testExisteProduto() {
		this.fornecedor1.adicionaProduto("Celular", "Iphone", 9.99);
		assertFalse(true == this.fornecedor1.existeProduto("Celular", "Android"));
		assertTrue(true == this.fornecedor1.existeProduto("Celular", "Iphone"));
		
		this.fornecedor2.adicionaProduto("Pão", "Franch", 0.5);
		assertTrue(true == this.fornecedor2.existeProduto("Pão", "Franch"));
	}
	
	@Test
	void testExibeProduto() {
		this.fornecedor1.adicionaProduto("Pão", "Bola", 0.75);
		this.fornecedor2.adicionaProduto("Sabonete", "Líquido", 5.00);
		
		assertTrue("Pão - Bola - R$0,75".equals(this.fornecedor1.exibeProduto("Pão", "Bola")));
		assertTrue("Sabonete - Líquido - R$5,00".equals(this.fornecedor2.exibeProduto("Sabonete", "Líquido")));
		
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor1.exibeProduto("Pão", "Franch"));
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor2.exibeProduto("Sabonete", "Barra"));
	}
	
	@Test
	void tesEditaProduto() {
		this.fornecedor1.adicionaProduto("Refri", "Pepsi", 3.99);
		this.fornecedor1.editaProduto("Refri", "Pepsi", 10.00);
		assertEquals(10.00, this.fornecedor1.getProduto("Refri", "Pepsi").getPreco());
		
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor1.editaProduto("Fanta", "Uva", 5.00));
	}
	
	@Test
	void testRemoveProduto() {
		this.fornecedor2.adicionaProduto("Pão", "Bola", 0.75);
		assertTrue(true == this.fornecedor2.existeProduto("Pão", "Bola"));
		
		this.fornecedor2.removeProduto("Pão", "Bola");
		assertTrue(false == this.fornecedor2.existeProduto("Pão", "Bola"));
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor2.removeProduto("Sabão", "em pó"));
	}
	
	@Test
	void adicionaCompra() {
		this.fornecedor1.adicionaProduto("Pão", "Bola", 0.75);
		this.fornecedor1.adicionaCompra(this.cliente, "12/11/2020", "Pão", "Bola");
	}
	
	@Test
	void getDebito() {
		this.fornecedor1.adicionaProduto("Pão", "Bola", 0.75);
		this.fornecedor1.adicionaCompra(this.cliente, "12/11/2020", "Pão", "Bola");
		assertEquals("0.75", this.fornecedor1.getDebito(cliente));
		
		this.fornecedor1.adicionaProduto("Celular", "Android", 200.00);
		this.fornecedor1.adicionaCompra(this.cliente, "12/11/2020", "Celular", "Android");
		assertNotEquals("300.99", this.fornecedor1.getDebito(cliente));
		assertEquals("200.75", this.fornecedor1.getDebito(cliente));
		
		assertThrows(IllegalArgumentException.class, ()-> this.fornecedor2.getDebito(cliente2));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
