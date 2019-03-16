module jfx.sorter.quick {

    requires jfx.sorter.api;

    provides com.saz.sorter.api.Sorter with com.saz.sorter.quick.QuickSorter;
    provides com.saz.sorter.api.SorterProvider with com.saz.sorter.quick.QuickSorterProvider;
}