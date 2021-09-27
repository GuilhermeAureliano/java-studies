package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ControllerClientes;

class ControllerClientesTest {

	
	private ControllerClientes controllerClientes;
	
	@BeforeEach
	void criaControllerClientes() {
		this.controllerClientes = new ControllerClientes();
	}
	
	@Test
	void adicionaCliente() {
		assertEquals("11111111111", this.controllerClientes.adicionaCliente("11111111111", "Tommy", "shelby@gmail.com", "UK"));
		
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.adicionaCliente("11111111111", "Tommy", "shelby@gmail.com", "UK")); // cliente já existe
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.adicionaCliente("12345", "Adilson", "adilson@gmail.com", "PB")); // cpf inválido
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.adicionaCliente("12345678911", null, "null@gmail.com", "Nulândia"));
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.adicionaCliente(null, "José", "josé@gmail.com", "Taperoá"));
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.adicionaCliente("12345678911", "José", null, "Taperoá"));
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.adicionaCliente("12345678911", "José", "jose@gmail.com", null));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.adicionaCliente("77777777777", "       ", "ninguem@gmail.com", "NG"));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.adicionaCliente("", "Ninguem", "ninguem@gmail.com", "NG"));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.adicionaCliente("99345678324", "Ninguem", "ninguem@gmail.com", "          "));
	}
	
	@Test
	void testExibeCliente() {
		this.controllerClientes.adicionaCliente("11111111111", "Gustavo", "guga@gmail.com", "PB");
		assertEquals("Gustavo - PB - guga@gmail.com", this.controllerClientes.exibeCliente("11111111111").toString());
		
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.exibeCliente("00000000000").toString());
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.exibeCliente("").toString());
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.exibeCliente("00").toString());
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.exibeCliente("    ").toString());
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.exibeCliente(null).toString());
	}
	
	@Test
	void testEditaCliente() {
		this.controllerClientes.adicionaCliente("11111111111", "Gustavo", "guga@gmail.com", "PB");
		this.controllerClientes.editaCliente("11111111111", "nome", "Guguzinho");
		assertEquals("Guguzinho - PB - guga@gmail.com", this.controllerClientes.exibeCliente("11111111111").toString());
		
		this.controllerClientes.editaCliente("11111111111", "email", "ehguguzinviu@gmail.com");
		assertEquals("Guguzinho - PB - ehguguzinviu@gmail.com", this.controllerClientes.exibeCliente("11111111111").toString());
		
		this.controllerClientes.editaCliente("11111111111", "localizacao", "Catingueira");
		assertEquals("Guguzinho - Catingueira - ehguguzinviu@gmail.com", this.controllerClientes.exibeCliente("11111111111").toString());
		
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.editaCliente("11111111111", "bairro", "Liberdade")); // atributo não existe
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.editaCliente("11111111111", "cpf", "00000000000")); // cpf não pode ser editado
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.editaCliente("11111111111", "", "Oxente"));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.editaCliente("11111111111", "nome", "          "));
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.editaCliente("11111111111", null, "Deu Errado"));
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.editaCliente("11111111111", "email", null));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.editaCliente("22222222222", "email", "guilherme@gmail.com")); // cliente não existe
	}
	
	@Test
	void testRemoveCliente() {
		this.controllerClientes.adicionaCliente("11111111111", "Gustavo", "guga@gmail.com", "PB");
		assertTrue(true == this.controllerClientes.getMapaClientes().containsKey("11111111111"));
		
		this.controllerClientes.removeCliente("11111111111");
		assertFalse(true == this.controllerClientes.getMapaClientes().containsKey("11111111111"));
		
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.removeCliente("12345678901"));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.removeCliente(""));
		assertThrows( IllegalArgumentException.class, ()-> this.controllerClientes.removeCliente("           "));
		assertThrows( NullPointerException.class, ()-> this.controllerClientes.removeCliente(null));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
