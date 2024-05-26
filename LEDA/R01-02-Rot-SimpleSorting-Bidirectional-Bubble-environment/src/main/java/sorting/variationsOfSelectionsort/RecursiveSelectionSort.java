package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex){
		if(leftIndex >= 0 & rightIndex < array.length & leftIndex < rightIndex){
			int menor = leftIndex;
			for (int j = leftIndex + 1; j < rightIndex + 1; j++){
				if (array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
			}
			util.Util.swap(array, menor, leftIndex);
			if (leftIndex < rightIndex){
				sort(array, leftIndex + 1, rightIndex);
			}
		}
	}
}
