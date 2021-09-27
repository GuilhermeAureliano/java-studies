package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		boolean input = verificaIndices(array, leftIndex, rightIndex);

		if (input) {
			int max = array[leftIndex];
			int min = array[leftIndex];

			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i] > max) {
					max = array[i];
				}
				if (array[i] < min) {
					min = array[i];
				}
			}

			int[] arrayAux = new int[max - min + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAux[array[i] - min] += 1;
			}

			for (int i = 1; i < arrayAux.length; i++) {
				arrayAux[i] += arrayAux[i - 1];
			}

			int[] arrayOrder = new int[rightIndex - leftIndex + 1];
			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayAux[array[i] - min] -= 1;
				arrayOrder[arrayAux[array[i] -min]] = array[i];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayOrder[i - leftIndex];
			}
		}
	}

	private boolean verificaIndices(Integer[] array, int leftIndex, int rightIndex) {
		boolean retorno = true;
		if ((array == null) || (array.length == 0)) {
			retorno = false;
		}
		if ((leftIndex < 0) || (leftIndex >= rightIndex)) {
			retorno = false;
		}
		if ((rightIndex < 0) || (rightIndex >= array.length)) {
			retorno = false;
		}
		return retorno;
	}
}
