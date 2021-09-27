package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (!this.isFull()) {
			this.list.insert(element);
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T value = this.head();
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			this.list.removeFirst();
		}
		return value;
	}

	@Override
	public T head() {
		T value = null;

		if (!this.isEmpty()) {
			T[] array = this.list.toArray();
			value = array[0];
		}

		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.list.size() == this.size;
	}

}
