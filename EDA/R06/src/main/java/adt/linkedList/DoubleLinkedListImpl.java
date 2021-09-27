package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {

		if (element != null) {

			if (!this.isEmpty()) {
				DoubleLinkedListNode<T> auxHead = new DoubleLinkedListNode<>();
				auxHead.setData(this.getHead().getData());
				auxHead.setNext(this.getHead().getNext());
				DoubleLinkedListNode<T> newNode =
						new DoubleLinkedListNode<T>(element,
								auxHead,
								new DoubleLinkedListNode<T>());
				this.setHead(newNode);
			} else {
				DoubleLinkedListNode<T> newNode =
						new DoubleLinkedListNode<T>(element,
								new DoubleLinkedListNode<T>(),
								new DoubleLinkedListNode<T>());
				this.last = newNode;
				this.head = newNode;
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()){

			if(!this.getHead().isNIL()) {
				this.setHead(this.getHead().getNext());

				if (this.getHead().isNIL()) {
					this.setLast((DoubleLinkedListNode<T>) this.getHead());
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()) {
			if (this.getHead().isNIL()) {
				setLast(this.last.getPrevious());
				this.last.setNext(new DoubleLinkedListNode<>());

				} else {
				this.setLast(new DoubleLinkedListNode<T>());
				this.setHead(this.last);

			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
