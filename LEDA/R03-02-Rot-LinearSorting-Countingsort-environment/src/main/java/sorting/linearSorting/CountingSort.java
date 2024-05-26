package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex){
			int menor = pegarMenor(array, leftIndex, rightIndex);
			int tamanho = pegarMaior(array, leftIndex, rightIndex);
			
			if (menor == 0){
				tamanho += 1;
			}
			
			int[] C = new int[tamanho];
			for(int i = leftIndex; i <= rightIndex; i++){
				int num = array[i];
				int index = num - menor;

				C[index] += 1;
			}
			for(int i = 1; i < C.length; i++){
				C[i] += C[i - 1];
			}

			int[] B = new int[array.length];
			for(int i = 0; i < array.length; i++){
				B[i] = array[i];
			}

			for(int i = rightIndex; i >= leftIndex; i--){
				int num = B[i];
				int j = num - menor;
				C[j]--;
				int posicao = C[j] + leftIndex;
				array[posicao] = num;
			}
		}
	}
	
	private static int pegarMenor(Integer[] array, int leftIndex, int rightIndex){
		int menor = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (menor > array[i]) {
				menor = array[i];
			}
		}
		return menor;
	}

	private static int pegarMaior(Integer[] array, int leftIndex, int rightIndex){
		int maior = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (maior < array[i]) {
				maior = array[i];
			}
		}
		return maior;
	}
}
