package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean input = verificaIndices(array, leftIndex, rightIndex);
		if (input) {
			int pivot = partition(array, leftIndex, rightIndex);

			sort(array, leftIndex, pivot -1);
			sort(array, pivot + 1, rightIndex);
		} else {
			return;
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex)  {
		int threeWay = Pivot(array, leftIndex, rightIndex);
		Util.swap(array, leftIndex, threeWay);

		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

	private int Pivot(T[] array, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;

		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		} else if (array[leftIndex].compareTo(array[middle]) > 0) {
			Util.swap(array, leftIndex, middle);
		} else if (array[middle].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, middle, rightIndex);
		}

		return middle;
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
