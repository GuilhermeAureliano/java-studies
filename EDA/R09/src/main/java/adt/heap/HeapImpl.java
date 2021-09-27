package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
		int left = this.left(position);
		int right = this.right(position);
		int index_max = position;

		if (left < this.size() && this.comparator.compare(this.heap[left], this.heap[position]) < 0) {
			index_max = left;
		}

		if (right < this.size() && this.comparator.compare(this.heap[right], this.heap[index_max]) < 0) {
			index_max = right;
		}

		if (index_max != position) {
			Util.swap(heap, position, index_max);
			this.heapify(index_max);
		}
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		if (element != null) {
			index ++;
			heap[index] = element;

			int i = index;
			while (i > 0 && this.comparator.compare(this.heap[i], this.heap[parent(i)]) < 0) {
				Util.swap(heap, i, parent(i));
				i = parent(i);
			}

		}
	}

	@Override
	public void buildHeap(T[] array) {
		if (array != null) {
			index = array.length - 1;
			heap = array;

			for (int i = parent(index); i >= 0; i--) {
				this.heapify(i);
			}
		}
	}

	@Override
	public T extractRootElement() {
		T root = null;

		if(!this.isEmpty()) {
			root = this.heap[0];
			this.heap[0] = this.heap[index--];
			this.heapify(0);
		}

		return root;
	}

	@Override
	public T rootElement() {
		T result = null;
		if (!this.isEmpty()) {
			result = heap[0];
		}

		return result;
	}

	@Override
	public T[] heapsort(T[] array) {
		Comparator<T> comparator = this.comparator;

		this.setComparator((o1, o2) -> o1.compareTo(o2));
		this.buildHeap(array);

		List<T> list = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			list.add(this.extractRootElement());
		}

		this.setComparator(comparator);
		heap = (T[]) (new Comparable[INITIAL_SIZE]);

		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public int size() {
		return index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
