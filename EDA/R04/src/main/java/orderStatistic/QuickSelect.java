package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os daods em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a completixade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 */
	public T quickSelect(T[] array, int k) {
		T num = null;
		boolean input = verificaEntradas(array, k);

		if (input) {
			int index = QuickSelectRecursive(array, k, 0, array.length-1);
			if (index != 0) {
				num = array[index];
			}
		}
		return num;
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int pivotloc = leftIndex;

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i].compareTo(pivot) < 0) {
				pivotloc++;
				Util.swap(array, pivotloc, i);

			}
		}

		Util.swap(array, leftIndex, pivotloc);
		return pivotloc;

	}
	private int QuickSelectRecursive(T[] array, int k, int leftIndex, int rightIndex) {
		int partition = partition(array, leftIndex, rightIndex);

		if (partition != (k - 1)) {
			if (partition < (k - 1)) {
				return QuickSelectRecursive(array, k, partition + 1, rightIndex);
			} else {
				return QuickSelectRecursive(array, k, leftIndex, partition - 1);
			}
		} else {
			return partition;
		}
	}

	private boolean verificaEntradas(T[] array, int k) {
		boolean resp = true;
		if (array.length < 1 || array.length < k || k < 1) {
			resp = false;
		}

		return resp;
	}

}