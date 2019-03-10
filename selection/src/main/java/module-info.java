module jfx.sorter.selection {

    requires jfx.sorter.api;
    uses com.saz.sorter.api.Sorter;
    uses com.saz.sorter.api.SorterProvider;
    provides com.saz.sorter.api.Sorter with com.saz.sorter.selection.SelectionSorter;
    //provides com.saz.sorter.api.SorterProvider;
}