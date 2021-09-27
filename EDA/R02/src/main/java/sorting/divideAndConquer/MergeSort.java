package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean input = verificaIndices(array, leftIndex, rightIndex);
		if (input) {
			int middle = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			merge(array, leftIndex, rightIndex);
		} else {
			return;
		}
	}
	private void merge(T[] array, int leftIndex, int rightIndex) {
		T[] v = (T[]) new Comparable[array.length];

		for (int i = leftIndex; i<= rightIndex; i++) {
			v[i] = array[i];
		}

		int middle = (leftIndex + rightIndex) / 2;
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while ((i <= middle) && (j <= rightIndex)) {
			if (v[i].compareTo(v[j]) < 0) {
				array[k] = v[i];
				i++;

			} else {
				array[k] = v[j];
				j++;
			}
			k++;

		}
		while (i <= middle) {
			array[k] = v[i];
			i++;
			k++;
		}
		while (j <= rightIndex) {
			array[k] = v[j];
			j++;
			k++;
		}
	}

	private boolean verificaIndices(T[] array, int leftIndex, int rightIndex) {
		if ((array == null) || (array.length == 0)) {
			return false;
		}
		if ((leftIndex < 0) || (leftIndex >= rightIndex)) {
			return false;
		}
		if ((rightIndex < 0) || (rightIndex >= array.length)) {
			return false;
		}
		return true;
	}
}
