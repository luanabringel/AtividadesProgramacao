package adt.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adt.bst.BSTNode;
import adt.bt.Util;

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
		if (array != null && array.length > 0) {
			List<T> lista = new ArrayList<>();
			for (T element : preOrder()){
				lista.add(element);
			} for (T element : array){
				if (!lista.contains(element)) {
					lista.add(element);
				}
			}
			this.root = new BSTNode<>();
			Collections.sort(lista);
			Map<Integer, List<T>> mapa = new HashMap<>();
			auxFillWithoutRebalance(mapa, 0, 0, lista.size() - 1, lista);

			int altura = 0;
			while (mapa.containsKey(altura)) {
				for (T element : mapa.get(altura)){
					insert(element);
				}
				altura++;
			}
  		}
	}

	@Override
	protected void rebalance(BSTNode<T> node) {

		int balance = calculateBalance(node);

		if (balance > 1){
			rebalanceLeft(node);
		} else if (balance < -1){
			rebalanceRight(node);
		}
	}
	
	private void rebalanceRight(BSTNode<T> node) {
		BSTNode<T> auxiliador;
		if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
			auxiliador = Util.leftRotation(node);
			RRcounter++;
		} else {	
			Util.rightRotation((BSTNode<T>) node.getRight());
			auxiliador = Util.leftRotation(node);
			RLcounter++;
		}
		if (auxiliador.getParent() == null){
			this.root = auxiliador;
		}
	}

	private void rebalanceLeft(BSTNode<T> node) {
		BSTNode<T> current;
		if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
			current = Util.rightRotation(node);
			LLcounter++;
		} else {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			current = Util.rightRotation(node);
			LRcounter++;
		}
		if (current.getParent() == null){
			this.root = current;
		}
	}
	
	private void auxFillWithoutRebalance(Map<Integer, List<T>> map, int height, int leftIndex, int rightIndex, List<T> array) {
		if (leftIndex <= rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			T elemento = array.get(meio);
			if (!map.containsKey(height)){
				map.put(height, new ArrayList<T>());
			}
			map.get(height).add(elemento);
			auxFillWithoutRebalance(map, height + 1, leftIndex, meio - 1, array);
			auxFillWithoutRebalance(map, height + 1, meio + 1, rightIndex, array);
		}
	}
}
