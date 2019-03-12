import com.saz.sorter.insertion.InsertionSorter;

module jfx.sorter.insertion {

    requires jfx.sorter.api;
    uses com.saz.sorter.api.Sorter;
    uses com.saz.sorter.api.SorterProvider;
    provides com.saz.sorter.api.Sorter with InsertionSorter;
    //provides com.saz.sorter.api.SorterProvider;
}