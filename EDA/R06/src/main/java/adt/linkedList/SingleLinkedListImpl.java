package adt.linkedList;

import java.util.ArrayList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> node = this.head;

		while (!node.isNIL()) {
			size ++;
			node = node.getNext();
		}

		return size;
	}

	@Override
	public T search(T element) {
		T value = null;
		SingleLinkedListNode<T> node = this.head;

		if (element != null) {
			while (!node.isNIL()) {
				if (node.getData().equals(element)) {
					value = node.getData();
				} node = node.getNext();
			}
		}
		return value;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> node = this.head;

			if (!this.isEmpty()) {
				while (!node.isNIL()) {
					node = node.getNext();
				}
				node.setData(element);
				node.setNext(new SingleLinkedListNode<>());

			} else {
				SingleLinkedListNode<T> aux = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
				this.setHead(aux);

			}
		}


	}

	@Override
	public void remove(T element) {
		if (element != null && this.isEmpty() == false) {

			if (this.getHead().getData().equals(element)) {
				this.head = this.head.getNext();
			} else {
				SingleLinkedListNode<T> node = this.head;
				SingleLinkedListNode<T> bNode = this.head;

				while (!node.getData().equals(element) && !node.isNIL()) {
					bNode = node;
					node = node.getNext();
				}

				if (!node.isNIL()) {
					bNode.setNext(node.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		SingleLinkedListNode<T> node = this.head;
		while (!node.isNIL()) {
			for (int i = 0; i < array.length; i++) {
				array[i] = node.getData();
				node = node.getNext();
			}
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
