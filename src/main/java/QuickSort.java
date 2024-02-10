/*
Стандартная быстрая сортировка, использует интерфейс Comparable<E>
 */
public class QuickSort<E extends Comparable<E>>{

    public  <E extends Comparable<E>> void quicksort(MyArrayList<E> list, int low, int high) {
        if (low < high) { // Проверка, если low => high выход из рекурсии
            int pivot = partition(list, low, high);
            // вызов рекурсии для сортировки левой и правой части
            quicksort(list, low, pivot); // рекурсия на левую часть
            quicksort(list, pivot + 1, high); // рекурсия на правую часть
        }
    }

    private static <E extends Comparable<E>> int partition(MyArrayList<E> list, int low, int high) {
        E pivot = list.get(low); // установка пивота на начало массива
        int i = low - 1;
        int j = high + 1;

        while (true) { // проход по массиву с сравнением элементов слева и справа от пивота
            do {
                i++;// переход к следущему элементу
            } while (list.get(i).compareTo(pivot) < 0); // сравнение элемента с пивотом

            do {
                j--; // переход к следущему элементу
            } while (list.get(j).compareTo(pivot) > 0); // сравнение элемента с пивотом
            if (i >= j) { // при совпадении значений, возвращает пивот
                return j;
            }

            E temp = list.get(i);// перестоновка меньшего и большего
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}