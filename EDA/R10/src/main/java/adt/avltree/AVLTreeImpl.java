package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

import static adt.bt.Util.leftRotation;
import static adt.bt.Util.rightRotation;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int balance = 0;

		if (!node.isEmpty() && node != null) {
			balance = this.height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}

		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);
		BSTNode<T> auxNode;

		if (balance < -1) {
			if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
				auxNode = leftRotation(node);

			} else {
				auxNode = leftRotation(node);
				rightRotation((BSTNode<T>) node.getRight());
			}

			if (auxNode.getParent() == null){
				super.root = auxNode;
			}

		} else if (balance > 1) {
			if (this.calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
				auxNode = rightRotation(node);
				leftRotation((BSTNode<T>) node.getLeft());

			} else {
				auxNode = rightRotation(node);
			}

			if (auxNode.getParent() == null) {
				super.root = auxNode;
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while (!parent.isEmpty() && parent != null) {
			this.rebalance(parent);
		}
	}

	@Override
	public void insert(T element) {

		if (element != null) {
			insert(super.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());
			node.setRight(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());
		} else {

			if (node.getData().compareTo(element) < 0) {
				insert((BSTNode<T>) node.getRight(), element);
			}
			else {
				insert((BSTNode<T>) node.getLeft(), element);

			}
			this.rebalance(node);
		}
	}


	@Override
	public void remove(T element) {

		if (element != null) {
			super.remove(element);
			BSTNode<T> auxNode = super.search(element);
			this.rebalanceUp(auxNode);
		}
	}
}
