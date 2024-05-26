package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (element != null) {
			this.list.insert(element);
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T resultado = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		this.list.removeFirst();
		return resultado;
	}

	@Override
	public T head() {
		T valor = null;
		if (!isEmpty()) {
			valor = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		}
		return valor;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == this.list.size();
	}
}
