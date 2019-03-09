package com.saz.sorter.selection;

import sorter.api.Sorter;

import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSorterTest {

    private ThreadLocalRandom random = ThreadLocalRandom.current();
    int arraySize = 100;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void sort() {

        Integer[] array = new Integer[100];
        for (int i = 0; i <= array.length - 1; ++i) {
            array[i] = random.nextInt();
        }

        Sorter sorter = new SelectionSorter();
        Integer[] sorted = sorter.sort(array);

        for (int i = 1; i <= sorted.length - 1; ++i) {
            assertTrue(sorted[i - 1] <= sorted[i],
                       "Element " + sorted[i - 1] + " is not less than " + sorted[i]);
        }
    }
}