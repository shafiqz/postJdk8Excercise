import com.saz.sorter.insertion.InsertionSorter;

module jfx.sorter.insertion {

    requires jfx.sorter.api;

    provides com.saz.sorter.api.Sorter with InsertionSorter;
    provides com.saz.sorter.api.SorterProvider with com.saz.sorter.insertion.InsertionSorterProvider;
}