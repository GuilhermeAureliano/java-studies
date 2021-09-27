package adt.bst;

import java.util.ArrayList;
public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode<T> node) {

		if(node.isEmpty()) {
			return -1;
		}
		return 1 + Math.max(height((BSTNode<T>) node.getLeft()) , height((BSTNode<T>) node.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {

		BSTNode<T> node = new BSTNode<T>();

		if (element != null){
			node = search(root, element);
		}

		return node;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {

		if (node != null && !node.isEmpty()) {
			if (node.getData().compareTo(element) == 0) {
				return node;

			} else if (node.getData().compareTo(element) < 0) {
				node = search((BSTNode<T>) node.getRight(), element);
			} else {
				node = search((BSTNode<T>) node.getLeft(), element);
			}
		}

		return node;

	}

	@Override
	public void insert(T element){

		if (element != null) {
			insert(root, element);
		}

	}

	private void insert(BSTNode<T> node, T element) {

		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(
					new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());

			node.setLeft
					(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());

		}  else {
			if (node.getData().compareTo(element) < 0){
				insert((BSTNode<T>) node.getRight(), element);
			} else {
				insert((BSTNode<T>) node.getLeft(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {

		if (isEmpty()) {
			return null;
		}
		return maximum(root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {

		if (!node.getRight().isEmpty()) {
			return maximum((BSTNode<T>) node.getRight());
		}

		return node;
	}

	@Override
	public BSTNode<T> minimum(){

		if (isEmpty()){
			return null;
		}
		return minimum(root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {

		if (!node.getLeft().isEmpty()) {
			return minimum((BSTNode<T>) node.getLeft());
		}

		return node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {

		BSTNode<T> aux = search(element);

		if (element != null && !aux.isEmpty()) {
			if (aux.getRight().isEmpty()) {
				aux = sucessor(aux);
			}
			else {
				aux = minimum((BSTNode<T>) aux.getRight());
			}

			return aux;
		}

		return null;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> aux = (BSTNode<T>) node.getParent();

		if (node.getRight().equals(node) && aux != null) {
			aux = sucessor((BSTNode<T>) node.getParent());
		}

		return aux;
	}

	@Override
	public BSTNode<T> predecessor(T element) {

		BSTNode<T> aux = search(element);

		if (element != null && !aux.isEmpty()) {

			if (aux.getLeft().isEmpty()) {
				aux = predecessor(aux);

			}
			else {
				aux = maximum((BSTNode<T>) aux.getLeft());
			}
			
			return aux;
		}

		return null;
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {

		BSTNode<T> aux = (BSTNode<T>) node.getParent();

		if (aux != null && aux.getLeft().equals(node)) {
			aux = predecessor((BSTNode<T>) node.getParent());
		}

		return aux;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> toRemove = search(element);
		BSTNode<T> parent = (BSTNode<T>) toRemove.getParent();

		if (!toRemove.isEmpty()) {

			if (toRemove.isLeaf()) {
				toRemove.setData(null);
				toRemove.setLeft(null);
				toRemove.setRight(null);

			}
			else if (toRemove.getLeft().isEmpty() || (toRemove.getRight().isEmpty())) {

				if (parent != null) {

					if (!parent.getLeft().equals(toRemove)) {

						if (!toRemove.getLeft().isEmpty()) {
							parent.setRight(toRemove.getLeft());
							toRemove.getLeft().setParent(parent);
						} else {
							parent.setRight(toRemove.getRight());
							toRemove.getRight().setParent(parent);
						}

					} else {
						if (toRemove.getLeft().isEmpty()) {
							parent.setLeft(toRemove.getRight());
							toRemove.getRight().setParent(parent);
						} else {
							parent.setLeft(toRemove.getLeft());
							toRemove.getLeft().setParent(parent);
						}
					}

				} else {

					if (toRemove.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) toRemove.getRight();
					} else {
						this.root = (BSTNode<T>) toRemove.getLeft();
					}

					this.root.setParent(null);
				}

			}
			else {
				T sucessor = sucessor(toRemove.getData()).getData();
				remove(sucessor);
				toRemove.setData(sucessor);

			}
		}
	}

	@Override
	public T[] preOrder() {

		ArrayList<T> list = new ArrayList<T>();
		preOrder(list, root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node) {

		if (!node.isEmpty()) {
			list.add(node.getData());
			preOrder(list, (BSTNode<T>) node.getLeft());
			preOrder(list, (BSTNode<T>) node.getRight());
		}

	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();
		order(list, root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void order(ArrayList<T> list, BSTNode<T> node) {

		if (!node.isEmpty()) {
			order(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			order(list, (BSTNode<T>) node.getRight());
		}

	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();
		postOrder(list, root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void postOrder(ArrayList<T> list, BSTNode<T> node) {

		if (!node.isEmpty()) {
			postOrder(list, (BSTNode<T>) node.getLeft());
			postOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());

		}

	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
