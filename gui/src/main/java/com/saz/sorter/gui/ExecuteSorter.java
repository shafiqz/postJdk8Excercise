package com.saz.sorter.gui;

import com.saz.sorter.api.Sorter;

import java.util.function.Function;

public class ExecuteSorter implements Runnable {

    private Sorter sorter;
    private Integer[] arrayToSort;
    private Function<Long, Void> doneCallBack;

    public ExecuteSorter(Sorter sorter,
                         Integer[] arrayToSort,
                         Function<Long, Void> doneCallBack) {

        this.sorter = sorter;
        this.arrayToSort = arrayToSort;
        this.doneCallBack = doneCallBack;

    }

    @Override
    public void run() {

        var startTime = System.currentTimeMillis();
        sorter.sort(arrayToSort);
        var endTime = System.currentTimeMillis();

        doneCallBack.apply(endTime - startTime);
    }
}
