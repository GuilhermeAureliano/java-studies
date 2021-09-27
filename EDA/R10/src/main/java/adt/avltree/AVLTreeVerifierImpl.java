package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		boolean result = true;

		if (!avlTree.isEmpty()) {
			if (!isBST()) {
				result = false;
			}
			else {
				result = isAVLTree(getAVLTree().getRoot());
			}
		}
		return result;
	}

	private boolean isAVLTree(BSTNode<T> node) {
		boolean result = true;
		int balance = avlTree.calculateBalance(node);

		if (balance > 1 || balance < -1) {
			result = false;

		}
		else {
			BSTNode<T> left = (BSTNode<T>) node.getLeft();
			BSTNode<T> right = (BSTNode<T>) node.getRight();

			if (left != null) {
				result = isAVLTree(left);
			}
			if (right != null && result != false) {
				result = isAVLTree(right);
			}
		}
		return result;
	}

}
