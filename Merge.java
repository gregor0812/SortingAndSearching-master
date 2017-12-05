package ClassroomAssingment;

/**
 * Created by Gregor on 03/12/2017.
 */
public class Merge {


	private Merge() {
	}

	public static void merge(Comparable[] array, Comparable[] tempArray, int laag, int midden, int hoog) {

		assert isSorted(array, laag, midden);
		assert isSorted(array, midden+1, hoog);

		int i = laag, j = midden + 1;
		for (int k = laag; k <= hoog; k++)
			if (i > midden) {
				tempArray[k] = array[j++];
			} else if (j > hoog) {
				tempArray[k] = array[i++];
			} else if (less(array[j], array[i])) {
				tempArray[k] = array[j++];
			} else {
				tempArray[k] = array[i++];
			}
		assert isSorted(tempArray, laag, hoog);
	}


	public static void sort(Comparable[] array) {
		Comparable[] tempArray = array.clone();
		sort(tempArray,array,0, array.length - 1);
		assert isSorted(array);
	}


	private static boolean isSorted(Comparable[] array, int laag, int hoog) {
		for (int i = laag + 1; i <= hoog; i++) {


			if (less(array[i], array[i - 1])) {
				return false;
			}
		}
		return true;
	}
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}



	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void sort(Comparable[] array, Comparable[] tempArray, int laag, int hoog) {

		if (hoog <= laag+10){
			insertionSort(tempArray,laag,hoog);
			return;
		}
			int mid = (laag + (hoog - laag) / 2);
			sort(tempArray, array, laag, mid);
			sort(tempArray, array, mid + 1, hoog);

		if (!less(array[mid+1], array[mid])) {
			System.arraycopy(array, laag, tempArray, laag, hoog - laag + 1);
			return;
		}
			merge(array, tempArray, laag, mid, hoog);

	}

	private static void insertionSort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}


	

