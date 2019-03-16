module jfx.sorter.bubble {

    requires jfx.sorter.api;

    provides com.saz.sorter.api.Sorter with com.saz.sorter.bubble.BubbleSorter;
    provides com.saz.sorter.api.SorterProvider with com.saz.sorter.bubble.BubbleSorterProvider;
}