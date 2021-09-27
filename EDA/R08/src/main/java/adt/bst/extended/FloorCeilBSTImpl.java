package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {

		BSTImpl<Integer> tree = new BSTImpl<Integer>();

		if (array.length < 0){
			return null;
		}
		else {

			int k = 0;
			for (int i = 0; i < array.length; i ++) {
				if (array[i] <= k) {
					k = array[i];
				}
				tree.insert(array[i]);
			}

			return floor(tree.getRoot(), numero, k);
		}
	}

	private Integer floor(BSTNode<Integer> node, double numero, int k) {

		Integer result = null;

		if (!node.isEmpty()) {

			if (node.getData() == numero) {
				return node.getData();

			} else if (node.getData() > numero) {
				return floor((BSTNode<Integer>) node.getLeft(), numero, k);

			} else {
				Integer floor = floor((BSTNode<Integer>) node.getRight(), numero, k);

				if (floor != null){
					return floor;

				} else if (node.getData() < k) {
					result = floor;
				} else {
					result = node.getData();
				}
			}
		}
		return result;
	}


	@Override
	public Integer ceil(Integer[] array, double numero) {

		if (array.length < 0) {
			return null;
		}

		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		for (int i = 0; i < array.length; i ++) {
			tree.insert(array[i]);
		}

		return ceil(tree.getRoot(), numero);
	}

	private Integer ceil(BSTNode<Integer> node, double numero) {
		Integer result = null;

		if (!node.isEmpty()) {

			if (node.getData() == numero) {
				return node.getData();

			} else if (node.getData() < numero) {

				return ceil((BSTNode<Integer>) node.getRight(), numero);

			} else {

				Integer ceil = ceil((BSTNode<Integer>) node.getLeft(), numero);

				if (ceil == null) {
					return node.getData();

				} else if (ceil < numero) {
					result = node.getData();

				} else {
					result = ceil;
				}
			}
		}
		return result;
	}


}
