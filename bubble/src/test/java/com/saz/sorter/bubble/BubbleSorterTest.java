package com.saz.sorter.bubble;

import com.saz.sorter.api.Sorter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertTrue;


class BubbleSorterTest {

    private ThreadLocalRandom random = ThreadLocalRandom.current();
    int arraySize = 10000;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void sort() {

        Integer[] array = new Integer[arraySize];
        for (int i = 0; i <= array.length - 1; ++i) {
            array[i] = random.nextInt();
        }

        Sorter sorter = new BubbleSorter();
        Integer[] sorted = sorter.sort(array);

        for (int i = 1; i <= sorted.length - 1; ++i) {
            assertTrue(sorted[i - 1] <= sorted[i],
                       "Element " + sorted[i - 1] + " is not less than " + sorted[i]);
        }
    }
}