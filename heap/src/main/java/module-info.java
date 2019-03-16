module jfx.sorter.heap {

    requires jfx.sorter.api;

    provides com.saz.sorter.api.Sorter with com.saz.sorter.heap.HeapSorter;
    provides com.saz.sorter.api.SorterProvider with com.saz.sorter.heap.HeapSorterProvider;
}