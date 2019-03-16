module jfx.sorter.selection {

    requires jfx.sorter.api;

    provides com.saz.sorter.api.Sorter with com.saz.sorter.selection.SelectionSorter;
    provides com.saz.sorter.api.SorterProvider with com.saz.sorter.selection.SelectionSorterProvider;
}