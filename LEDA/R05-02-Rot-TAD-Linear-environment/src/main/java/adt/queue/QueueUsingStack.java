package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if(this.isFull()) {
				throw new QueueOverflowException();
			} 
			
			try {
				this.stack1.push(element);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T retorno = null;
		if (stack1.isEmpty()) {
			while (!stack2.isEmpty()) {
				try {
					stack1.push(stack2.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
		}
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
			try {
				retorno = stack2.pop();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	public T head() {
		T retorno = null;
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			}
			retorno = stack2.top();
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}
}
