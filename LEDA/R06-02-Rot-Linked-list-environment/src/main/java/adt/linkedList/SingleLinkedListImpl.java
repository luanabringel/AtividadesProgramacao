package adt.linkedList;
public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int tamanho = 0;
		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = head;
			tamanho = 1;
			while (!aux.getNext().isNIL()) {
				aux = aux.getNext();
				tamanho++;
			}
		}
		return tamanho;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> current = this.head;

		if (element != null) {
			while (!current.isNIL() && !current.getData().equals(element)) {
				current = current.getNext();
			}
		}
		return current.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = getHead();
			if (this.isEmpty()) {
				SingleLinkedListNode<T> newAux = new SingleLinkedListNode<>(element, this.getHead());
				this.setHead(newAux);
			} else {
				while (!aux.isNIL()) {
					aux = aux.getNext();
				}
				aux.data = element;
				aux.next = new SingleLinkedListNode<>();
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			if (this.getHead().getData().equals(element)) {
				this.setHead(this.getHead().getNext());
			} else {
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = aux.getNext();
				}
				if (!aux.isNIL()) {
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}
			}

		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = getHead();
		T[] array = (T[]) new Comparable[this.size()];
		int indexCounter = 0;
		while (!aux.isNIL()) {
			array[indexCounter] = aux.getData();
			indexCounter++;
			aux = aux.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
