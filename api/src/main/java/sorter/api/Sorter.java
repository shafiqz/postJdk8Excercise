package sorter.api;

public interface Sorter {

    <T extends Comparable<T>> T[] sort(final T[] input);

    default <T extends Comparable<T>> void swap(T[] input, int idxOne,
                                                int idxTwo) {

        T temp = input[idxOne];
        input[idxOne] = input[idxTwo];
        input[idxTwo] = temp;
    }
}
