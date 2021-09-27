package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (isEmpty()) {
			this.head = (this.head + 1) % array.length;
		}
		this.tail = (this.tail + 1) % array.length;
		this.array[this.tail] = element;
		this.elements ++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T value = this.head();
		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		}
		this.head = (this.head + 1) % this.elements;
		this.elements --;
		return value;
	}

	@Override
	public T head() {
		if (!this.isEmpty()) {
			return this.array[this.head];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
