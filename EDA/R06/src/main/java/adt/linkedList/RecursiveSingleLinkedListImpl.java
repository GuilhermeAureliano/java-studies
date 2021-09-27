package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return (this.getData() == null);
	}

	@Override
	public int size() {
		int size;

		if (this.isEmpty()) {
			size = 0;
		} else {
			size = 1 + this.getNext().size();
		}

		return size;
	}

	@Override
	public T search(T element) {
		T value = null;

		if (!this.isEmpty()) {
			if (this.getData().equals(element)) {
				value = element;
			} else {
				value = this.getNext().search(element);
			}
		}

		return value;

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				this.getNext().insert(element);
			} else {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {

				if (this.getNext() != null) {
					this.next.remove(element);

				}
				if (this.getData().equals(element)) {
					if (this.getNext() != null) {
						this.setData(this.next.data);
						this.setNext(this.next.next);
					} else {
						this.setData(null);
					}
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];

		adicionaNoArrayRecursive(array, 0);
		return array;
	}

	private void adicionaNoArrayRecursive(T[] array, int i) {

		if (!this.isEmpty()) {
			array[i] = this.getData();
			this.getNext().adicionaNoArrayRecursive(array, i + 1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
