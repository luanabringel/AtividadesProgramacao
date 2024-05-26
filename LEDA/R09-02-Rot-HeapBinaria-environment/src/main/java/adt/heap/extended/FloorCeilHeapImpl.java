package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor (Integer[] array, double numero) {
		if(array != null) {
			for (Integer elemento : array) {
				this.insert(elemento);
			}
		}
		return this.recursiveFloor(numero, null);
	}

	public Integer recursiveFloor (double numero, Integer floor) {
		Integer raiz = this.extractRootElement();
		if (raiz != null)
			if (numero >= raiz && (floor == null || raiz >= floor)) {
				floor = this.recursiveFloor(numero, raiz);
			}
			else {
				floor = this.recursiveFloor(numero, floor);
			}
		return floor;
	}

	@Override
	public Integer ceil (Integer[] array, double numero) {
		if(array != null) {
			for (Integer elemento : array) {
				this.insert(elemento);
			}
		}
		return this.recursiveCeil(numero, null);
	}

	public Integer recursiveCeil (double numero, Integer ceil) {
		Integer raiz = this.extractRootElement();
		if (raiz != null) {
			if (numero <= raiz && (ceil == null || raiz <= ceil)) {
				ceil = this.recursiveCeil(numero, raiz);
			}
			else {
				ceil = this.recursiveCeil(numero, ceil);
			}
		}
		return ceil;
	}
}
