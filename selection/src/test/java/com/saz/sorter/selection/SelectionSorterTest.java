package com.saz.sorter.selection;

import com.saz.sorter.api.Sorter;

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

        for (int i = 0; i < sorted.length - 2; ++i) {
            assertTrue(sorted[i] <= sorted[i + 1],
                       "Element " + sorted[i] + " is not less than " + sorted[i + 1]);
        }
    }
}