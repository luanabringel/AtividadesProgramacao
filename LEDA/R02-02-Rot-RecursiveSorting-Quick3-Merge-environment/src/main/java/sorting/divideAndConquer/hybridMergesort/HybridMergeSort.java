package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex){
		if (array.length <= SIZE_LIMIT){
			insertionSort(array, leftIndex, rightIndex);
		} else{
			if (leftIndex < rightIndex){
				int meio = (leftIndex + rightIndex) / 2;
				sort(array, leftIndex, meio);
				sort(array, meio + 1, rightIndex);
				merge(array, leftIndex, meio, rightIndex);
			}
		}
	}
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex){
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			int j = i;
			while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0){
				util.Util.swap(array, j, j - 1);
				j--;
			}
		}
		INSERTIONSORT_APPLICATIONS++;
	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex){
		T[] aux = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++){
			aux[i] = array[i];
		}
		int j = meio + 1;
		int i = leftIndex;
		int x = leftIndex;
		
		while (i <= meio && j <= rightIndex){
			if (aux[i].compareTo(aux[j]) < 0){
				array[x] = aux[i];
				i++;
			} else {
				array[x] = aux[j];
				j++;
			}
			x++;
		}
		while (i <= meio){
			array[x++] = aux[i++];
		}

		while (j <= rightIndex){
			array[x++] = aux[j++];
		}
		MERGESORT_APPLICATIONS++;
	}
}
