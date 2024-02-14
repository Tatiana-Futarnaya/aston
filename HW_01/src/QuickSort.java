import java.util.Comparator;

public class QuickSort{

    public static <E extends Comparable<E>> void quickSort(MyArray<E> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Comparator<E> comparator = Comparator.naturalOrder();
        quickSortHelper(list, 0, list.size() - 1, comparator);
    }

    private static <E> void quickSortHelper(MyArray<E> list, int indexStart, int indexEnd, Comparator<E> comparator) {
        if (indexStart < indexEnd) {
            int pivotIndex = partition(list, indexStart, indexEnd, comparator);
            quickSortHelper(list, indexStart, pivotIndex - 1, comparator);
            quickSortHelper(list, pivotIndex + 1, indexEnd, comparator);
        }
    }

    private static <E> int partition(MyArray<E> list, int indexStart, int indexEnd, Comparator<E> comparator) {
        E pivot = list.get(indexEnd);
        int i = indexStart - 1;
        for (int j = indexStart; j < indexEnd; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, indexEnd);
        return i + 1;
    }

    private static <E> void swap(MyArray<E> list, int i, int j)  {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
