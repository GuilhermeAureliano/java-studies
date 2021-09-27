package adt.avltree;

import adt.bst.BSTNode;

import java.util.*;

import static adt.bt.Util.leftRotation;
import static adt.bt.Util.rightRotation;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {

		if (array != null) {

			Arrays.sort(array);
			Map<Integer, List<T>> auxMapa = new TreeMap<>();
			recursiveMap(auxMapa, 0, array.length - 1, 0, array);

			for (List<T> key: auxMapa.values()) {
				for (T value: key) {
					super.insert(value);
				}
			}
		}
	}

	private void recursiveMap(Map<Integer, List<T>> auxMapa, int leftIndex, int rightIndex, int key, T[] array) {

		if (leftIndex <= rightIndex) {

			int middleIndex = (leftIndex + rightIndex)/2;
			if (!auxMapa.containsKey(key)) {
				auxMapa.put(key, new ArrayList<T>());
			}

			auxMapa.get(key).add(array[middleIndex]);
			recursiveMap(auxMapa, leftIndex, middleIndex - 1, key + 1, array);
			recursiveMap(auxMapa, middleIndex + 1, rightIndex, key + 1, array);
		}
	}

	@Override
	protected void rebalance(BSTNode<T> node) {

		BSTNode<T> auxNode;
		int balance = calculateBalance(node);

		if (!super.isEmpty()) {

			if (balance < -1) {
				if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
					auxNode = leftRotation(node);
					this.RRcounter++;
				} else {
					rightRotation((BSTNode<T>) node.getRight());
					auxNode = leftRotation(node);
					this.RLcounter++;
				}

				if (auxNode.getParent() == null) {
					super.root = auxNode;
				}


			} else if (balance > 1) {
				if (calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
					leftRotation((BSTNode<T>) node.getLeft());
					auxNode = rightRotation(node);
					this.LRcounter++;

				} else {
					auxNode = rightRotation(node);
					this.LLcounter++;
				}

				if (auxNode.getParent() == null) {
					super.root = auxNode;
				}
			}
		}

	}

}
