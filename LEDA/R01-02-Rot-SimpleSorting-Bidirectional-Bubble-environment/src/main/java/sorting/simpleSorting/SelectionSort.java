package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex){
		if(leftIndex >= 0 & rightIndex < array.length & leftIndex < rightIndex){
			for(int i = leftIndex; i < rightIndex + 1; i++) {
				int menor = i;
				for(int j = i+1;j < rightIndex + 1; j++) {
					if(array[j].compareTo(array[menor]) < 0) {
						util.Util.swap(array, menor, j);
					}
				}
			}
		}
	}
}
