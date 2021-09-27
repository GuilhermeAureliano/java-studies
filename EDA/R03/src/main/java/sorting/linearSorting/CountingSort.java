package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		boolean input = verificaIndices(array, leftIndex, rightIndex);

		if (input) {
			int maior = array[leftIndex];
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i] > maior) {
					maior = array[i];
				}
			}

			int[] arrayAux = new int[maior + 1];
			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAux[array[i]] += 1;
			}

			for (int i = 0; i < arrayAux.length - 1; i++) {
				arrayAux[i + 1] += arrayAux[i];
			}

			int[] arrayOrder = new int[array.length];
			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayOrder[arrayAux[array[i]] - 1] = array[i];
				arrayAux[array[i]] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayOrder[i-leftIndex];
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
