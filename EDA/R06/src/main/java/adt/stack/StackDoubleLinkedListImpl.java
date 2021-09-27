package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (element != null) {
			if (!this.isFull()) {
				this.top.insertFirst(element);
			} else {
				throw new StackOverflowException();
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {

		T value = this.top();
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		} else {
			this.top.removeFirst();
		}
		return value;
	}

	@Override
	public T top() {
		T value = null;

		if (!this.isEmpty()) {
			T[] array = this.top.toArray();
			value = array[0];
		}

		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {

		return (this.top.size() == this.size);
	}

}
