package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x){
		for (Integer num : array) {
			if (num == null){
				return null;
			}
		}
		sorting(array, 0, array.length - 1);
		return procura(array, 0, array.length - 1, x);
	}

	private Integer procura(Integer[] array, int leftIndex, int rightIndex, Integer x){
		if (leftIndex > rightIndex){
			return null;
		}

		if (x == null){
			return null;
		}

		if (array[rightIndex] <= x){
			return array[rightIndex];
		}

		int meio = (leftIndex + rightIndex) / 2;

		if (meio > 0 && array[meio - 1] <= x && x < array[meio]){
            return array[meio - 1];
		}

        if (x < array[meio]){
            return procura(array, leftIndex, meio - 1, x);
		}

        return procura(array, meio + 1, rightIndex, x);
	}

	private void sorting(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 1){
			if (leftIndex < rightIndex) {
				int index_pivot = partition(array, leftIndex, rightIndex);
				sorting(array, leftIndex, index_pivot - 1);
				sorting(array, index_pivot + 1, rightIndex);	
			}
		}
	}
	
	
	private int partition(Integer[] array, int leftIndex, int rightIndex) {	
		int i = leftIndex;
		Integer pivot = array[leftIndex];
		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				util.Util.swap(array, i, j);	
			}
		}
			
		util.Util.swap(array,leftIndex,i);
		return i;		
	}
}
