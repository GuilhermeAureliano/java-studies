package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer result = null;
		HeapImpl<Integer> heap = new HeapImpl<Integer>(super.comparator);

		if (array != null && array.length > 0) {

			int aux = 0;
			for (Integer e: array) {
				heap.insert(e);

				if (e < aux) {
					aux = e;
				}
			}

			if (!heap.isEmpty()) {
				int i = 0;
				while (i < array.length) {
					Integer root = heap.extractRootElement();

					if (root == numero) {
						aux = root;
						break;
					} else if (root > aux && root < numero) {
						aux = root;
					}

					i++;
				}
			}

			if (numero > aux) {
				result = aux;
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer result = null;
		this.index = -1;

		if (array != null & array.length > 0) {
			for (Integer e: array) {
				this.insert(e);
			}

			if (!this.isEmpty()) {

				int i = 0;
				while (i < array.length) {

					Integer root = this.rootElement();
					if (root == numero) {
						result = this.rootElement();
						break;
					}

					else if (root > numero) {
						result = this.rootElement();
						break;
					}
					else {
						this.extractRootElement();
					}

					i++;
				}
			}
		}
		return result;
	}

}
