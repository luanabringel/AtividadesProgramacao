package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= 0 & rightIndex < array.length & leftIndex < rightIndex){
			boolean trocar = true;
			while(trocar) {
				trocar = false;
				for(int i = leftIndex; i < rightIndex; i++) {
					if(array[i].compareTo(array[i+1]) > 0) {
						util.Util.swap(array, i, i+1);
						trocar = true;
					}
					for(int j = rightIndex; j > leftIndex; j--) {
						if(array[j].compareTo(array[j-1]) < 0) {
							util.Util.swap(array, j, j-1);
							trocar = true;
						}
					}	
				}
			}
		}
	}
}
