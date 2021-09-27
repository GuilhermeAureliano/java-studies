package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isFull()) {
				throw new HashtableOverflowException();
			}

			int contagem = 0;

			while (contagem < capacity()) {
				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, contagem);

				if (table[hash] == null || table[hash].equals(deletedElement) || table[hash].equals(element)) {
					table[hash] = element;
					elements ++;
					break;
				} else {
					contagem ++;
					COLLISIONS ++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !isEmpty()) {

			int contagem = 0;

			while (contagem < capacity()) {
				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, contagem);

				if (table[hash] == null || table[hash].equals(deletedElement)) {
					break;
				} else if (table[hash].equals(element)) {
					table[hash] = deletedElement;
					elements --;
					break;
				}

				contagem ++;
			}
		}
	}

	@Override
	public T search(T element) {

		if (element != null && !isEmpty()) {

			int hash = this.indexOf(element);
			if (hash != -1) {
				return (T) table[hash];
			}
		}

		return null;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null && !isEmpty()) {

			int contagem = 0;

			while (contagem < capacity()) {
				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, contagem);

				if (table[hash] == null || table[hash].equals(deletedElement)) {
					break;
				}
				else if (table[hash].equals(element)) {
					index = hash;
					break;
				}

				contagem ++;
			}
		}

		return index;
	}

}
