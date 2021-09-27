package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		try {
			this.stack1.push(element);
		} catch (StackOverflowException e){
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			throw  new QueueUnderflowException();
		}

		T value = null;
		try {
			this.stackEmpilhaDesimpilha();
			value = this.stack2.pop();
			this.stackEmpilhaDesimpilha();
		} catch (StackUnderflowException | StackOverflowException e) {
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public T head() {
		T value = null;
		try {
			this.stackEmpilhaDesimpilha();
			value = this.stack2.top();
			this.stackEmpilhaDesimpilha();
		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return (this.stack1.isEmpty() && this.stack2.isEmpty());

	}

	@Override
	public boolean isFull() {
		return (this.stack1.isFull() || this.stack2.isFull());
	}

	private void stackEmpilhaDesimpilha() throws  StackOverflowException, StackUnderflowException {
		if (!this.stack2.isEmpty()) {
			while (!this.stack2.isEmpty()) {
				this.stack1.push(stack2.pop());// desempilha o stack 2 no stack 1
			}
		} else {
			while (!this.stack1.isEmpty()) {
				this.stack2.push(stack1.pop()); // empilha o stack 1 no stack 2
			}
		}
	}

}
