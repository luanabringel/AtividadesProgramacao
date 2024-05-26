package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>();
			node.setData(element);
			node.setNext(this.getHead());
			node.setPrevious(new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(node);

			if (this.getHead().isNIL()) {
				this.setLast(node);
			}
			this.setHead(node);
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			this.getLast().setNext(newLast);

			if (this.getLast().isNIL()) {
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}
	
	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.setHead(this.getHead().getNext());
			if (this.isEmpty()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.getPrevious();

			if (this.last.isNIL()) {
				this.head = this.last;
			}
			this.last.setNext(new DoubleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.next;
				}
				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T resultado = null;
		if (!this.isEmpty() && element != null) {
			DoubleLinkedListNode<T> currentHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> currentLast = this.getLast();

			while (!currentHead.equals(currentLast) && !currentHead.getNext().equals(currentLast) && !currentHead.getData().equals(element)
					&& !currentLast.getData().equals(element)) {
				currentHead = (DoubleLinkedListNode<T>) currentHead.getNext();
				currentLast = currentLast.getPrevious();
			}
			if (currentHead.getData().equals(element)) {
				resultado = currentHead.getData();
			}
			if (currentLast.getData().equals(element)) {
				resultado = currentLast.getData();
			}
		}
		return resultado;
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
