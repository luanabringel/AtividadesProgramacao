package sorting.divideAndConquer.quicksort3;
import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex){
		if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length){
			if(leftIndex < rightIndex){
			int iPivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, iPivot - 1);
			sort(array, iPivot + 1, rightIndex);
			}
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex){
		int iPivot = indicePivot(array, leftIndex, rightIndex);
		util.Util.swap(array, leftIndex, iPivot);
		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = i + 1; j <= rightIndex; j++){
			if (array[j].compareTo(pivot) <= 0){
				i++;
				util.Util.swap(array, i, j);
			}
		}
		util.Util.swap(array, leftIndex, i);
		return i;
	}

	public int indicePivot(T[] array, int leftIndex, int rightIndex){
		int meio = (leftIndex + rightIndex) / 2;
		T[] pivots = (T[]) new Comparable[3];

		if (array[leftIndex].compareTo(array[meio]) <= 0 && array[leftIndex].compareTo(array[rightIndex]) <= 0){
			pivots[0] = array[leftIndex];
			if (array[meio].compareTo(array[rightIndex]) <= 0){
				pivots[1] = array[meio];
				pivots[2] = array[rightIndex];
			}else {
				pivots[1] = array[rightIndex];
				pivots[2] = array[meio];
			}
		}
		else if (array[meio].compareTo(array[leftIndex]) <= 0 && array[meio].compareTo(array[rightIndex]) <= 0){
			pivots[0] = array[meio];
			if (array[leftIndex].compareTo(array[rightIndex]) <= 0){
				pivots[1] = array[leftIndex];
				pivots[2] = array[rightIndex];
			} else{
				pivots[1] = array[rightIndex];
				pivots[2] = array[leftIndex];
			}
		}
		else{
			pivots[0] = array[rightIndex];
			if (array[leftIndex].compareTo(array[meio]) <= 0){
				pivots[1] = array[leftIndex];
				pivots[2] = array[meio];
			} else{
				pivots[1] = array[meio];
				pivots[2] = array[leftIndex];
			}
		}
		int retornaIpivot = rightIndex;
		
		if (pivots[1].compareTo(array[leftIndex]) == 0){
			retornaIpivot = leftIndex;
		} else if (pivots[1].compareTo(array[meio]) == 0){
			retornaIpivot = meio;
		}
		return retornaIpivot;
	}
}
