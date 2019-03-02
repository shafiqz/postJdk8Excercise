package com.saz.sorter.api;

import java.util.List;

public interface Sorter {

    <T> List<T> sort(final List<T> input);
}
