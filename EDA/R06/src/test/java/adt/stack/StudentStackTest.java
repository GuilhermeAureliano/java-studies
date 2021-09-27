package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<>(6);
		stack2 = new StackDoubleLinkedListImpl<>(3);
		stack3 = new StackDoubleLinkedListImpl<>(3);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
		assertTrue(stack3.isEmpty());
		assertFalse(stack2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
		assertFalse(stack2.isFull());				// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
			assertEquals(new Integer(5), stack1.top());

			stack2.push(new Integer(7));
			assertEquals(new Integer(7), stack2.top());

			stack3.push(new Integer(1));
			assertEquals(new Integer(1), stack3.top());
			stack3.push(new Integer(2));
			stack3.push(new Integer(3));
			assertTrue(stack3.isFull());
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
		stack1.push(6);
		stack1.push(7);
		stack1.push(8);					// permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack1.pop()); // levanta excecao apenas se
		stack1.pop();
		stack1.pop();
		stack1.pop();							// stack1 for vazia
	}
}