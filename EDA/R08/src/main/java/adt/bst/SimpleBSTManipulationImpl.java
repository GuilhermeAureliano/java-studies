package adt.bst;

import adt.bt.BTNode;
/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equals(BTNode<T> node1, BTNode<T> node2) {
		boolean result;

		if (node1 == null && node2 == null) {
			return true;

		}
		else {

			if (equals(node1.getLeft(), node2.getLeft()) && equals(node1.getRight(), node2.getRight()) && node1.equals(node2)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilar(BTNode<T> node1, BTNode<T> node2) {
		boolean result;

		if (node1 == null && node2 == null) {
			return true;
		}
		else {
			if (isSimilar(node1.getLeft(), node2.getLeft()) && isSimilar(node1.getRight(), node2.getRight())) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {

		if (k <= tree.size() && k > 0 && !tree.isEmpty()) {
			return orderStatistic(tree, k, tree.minimum());
		}

		return null;
	}

	private T orderStatistic(BST<T> tree, int k, BSTNode<T> node){
		BSTNode<T> sucessor = tree.sucessor(node.getData());
		k--;

		if (node.isEmpty()){
			return null;
		} else {
			if (k != 0) {
				return orderStatistic(tree, k, sucessor);
			} else {
				return node.getData();
			}
		}
	}

}
