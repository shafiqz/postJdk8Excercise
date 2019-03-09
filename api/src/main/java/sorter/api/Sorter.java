package sorter.api;

public interface Sorter {

    <T extends Comparable<T>> T[] sort(final T[] input);

}
