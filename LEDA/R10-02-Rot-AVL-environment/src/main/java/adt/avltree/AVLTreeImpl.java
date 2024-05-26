package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.
	@Override
	public void insert(T element) {
		if (element != null) {
			recursiveInsert(this.root, element);
		}
	}

	@SuppressWarnings("unchecked")
	private void recursiveInsert(BSTNode<T> current, T element) {
		if (current.isEmpty()) {
			current.setData(element);
			current.setLeft(new BSTNode.Builder<T>().parent(current).build());
			current.setRight(new BSTNode.Builder<T>().parent(current).build());
		} else {
			if (element.compareTo(current.getData()) < 0) {
				recursiveInsert((BSTNode<T>) current.getLeft(), element);
			} else {
				recursiveInsert((BSTNode<T>) current.getRight(), element);
			}
			rebalance(current);
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			this.remove(node);
		}
	}

	private void remove(BSTNode<T> nodeElement) {
		if (nodeElement.isLeaf()) {
			nodeElement.setData(null);
			nodeElement.setLeft(null);
			nodeElement.setRight(null);
			rebalanceUp(nodeElement);

		} else if (!nodeElement.getLeft().isEmpty() && nodeElement.getRight().isEmpty()) {
			if (nodeElement.equals(this.root)) {
				this.root = (BSTNode<T>) nodeElement.getLeft();
				this.root.setParent(null);
			} else {
				nodeElement.getLeft().setParent(nodeElement.getParent());

				if (nodeElement.getData().compareTo(nodeElement.getParent().getData()) < 0) {
					nodeElement.getParent().setLeft(nodeElement.getLeft());
				} else {
					nodeElement.getParent().setRight(nodeElement.getLeft());
				}
			}
			rebalanceUp(nodeElement);
			
		} else if (nodeElement.getLeft().isEmpty() && !nodeElement.getRight().isEmpty()) {
			if (nodeElement.equals(this.root)) {
				this.root = (BSTNode<T>) nodeElement.getRight();
				this.root.setParent(null);
			} else {
				nodeElement.getRight().setParent(nodeElement.getParent());

				if (nodeElement.getData().compareTo(nodeElement.getParent().getData()) < 0) {
					nodeElement.getParent().setLeft(nodeElement.getRight());
				} else {
					nodeElement.getParent().setRight(nodeElement.getRight());
				}
			}
			rebalanceUp(nodeElement);

		} else {
			BSTNode<T> sucessor = this.sucessor(nodeElement.getData());
			T elemento = sucessor.getData();
			this.remove(sucessor);
			nodeElement.setData(elemento);
		}

	}

	protected int calculateBalance(BSTNode<T> node) {
		int balance = 0;
		if (!node.isEmpty()) {
			balance = this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		}
		return balance;
	}

	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);
		BSTNode<T> auxiliador = null;
		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					auxiliador = Util.rightRotation(node);
				} else {
					Util.leftRotation((BSTNode<T>) node.getLeft());
					auxiliador = Util.rightRotation(node);
				}
			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					auxiliador = Util.leftRotation(node);
				} else {
					Util.rightRotation((BSTNode<T>) node.getRight());
					auxiliador = Util.leftRotation(node);
				}
			}
		}
		if (this.getRoot().equals(node) && auxiliador != null) {
			this.root = auxiliador;
		}
	}

	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
}
