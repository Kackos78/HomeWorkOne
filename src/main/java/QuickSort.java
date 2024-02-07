/*

 */
public class QuickSort<E extends Comparable<E>>{

    public  <E extends Comparable<E>> void quicksort(MyArrayList<E> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            quicksort(list, low, pivot);
            quicksort(list, pivot + 1, high);
        }
    }

    private static <E extends Comparable<E>> int partition(MyArrayList<E> list, int low, int high) {
        E pivot = list.get(low);
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (list.get(i).compareTo(pivot) < 0);

            do {
                j--;
            } while (list.get(j).compareTo(pivot) > 0);
            if (i >= j) {
                return j;
            }

            E temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}