package problems;
public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer floor = null;
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		boolean input = verificaEntradas(array, leftIndex, rightIndex);

		if (input){
			Integer result = binarySearchRecursive(array, x, leftIndex, rightIndex);
			if (result != -1) {
				floor = array[result];
			}
		}

		return floor;
	}

	private static Integer binarySearchRecursive(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer floor = -1;
		int middle = (leftIndex + rightIndex) / 2 ;

		if (leftIndex <= rightIndex) {

			if (x.compareTo(array[middle]) == 0) {
				floor = middle;

			} else {
				if (x.compareTo(array[middle]) > 0){
					return binarySearchRecursive(array, x, middle + 1, rightIndex);
				} else {
					return binarySearchRecursive(array, x ,leftIndex, middle - 1);
				}
			}
		} else {
			if (middle == rightIndex && middle >= 0){
				floor = middle;
			}
		}
		return floor;
	}

	private boolean verificaEntradas(Integer[] array, int ini, int fim) {
		boolean resp = true;
		if (ini < 0 || ini > fim || ini >= array.length) {
			resp = false;
		} else if (fim < 0 || fim >= array.length) {
			resp = false;
		}

		return resp;
	}
}
