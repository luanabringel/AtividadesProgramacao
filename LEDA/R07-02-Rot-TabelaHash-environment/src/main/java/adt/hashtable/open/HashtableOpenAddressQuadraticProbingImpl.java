package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && this.search(element) == null) {

			int probing = 0;
			while (probing < this.capacity()) {
				int hash = this.getHash(element, probing);

				if (this.table[hash] == null || this.table[hash].equals(this.deletedElement)) {
					this.table[hash] = element;
					this.elements++;
					break;
				} else {
					probing++;
					this.COLLISIONS++;
				}
			}

			if (probing == this.capacity()) {
				throw new HashtableOverflowException();
			}

		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probing = 0;

			while (probing < this.capacity()) {
				int hash = this.getHash(element, probing);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					this.table[hash] = this.deletedElement;
					this.elements--;
					break;
				}
				probing++;
			}

		}
	}

	@Override
	public T search(T element) {
		T value = null;
		if (element != null) {
			int probing = 0;

			while (probing < this.capacity()) {
				int hash = this.getHash(element, probing);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					value = element;
					break;
				}
				probing++;
			}

		}
		return value;
	}

	@Override
	public int indexOf(T element) {
		int value = -1;
		if (element != null) {
			int probing = 0;

			while (probing < this.capacity()) {
				int hash = this.getHash(element, probing);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					value = hash;
					break;
				}
				probing++;
			}

		}
		return value;
	}

	private int getHash(T element, int probe) {
		return ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe);
	}
}
