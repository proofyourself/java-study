package com.proof.practice.task01.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingForTestsTest {

    SortingForTests sortingForTests = new SortingForTests();

    @Test
    public void shouldSortArrayWithBubbleSortWithWhile() {

        int[] array = {-1, 2, 1, 4, 3, 0};

        sortingForTests.bubbleSortWithWhile(array);
    }

    @Test
    public void shouldSortArrayWithInsertionSortForTest() {

        int[] array = {-1, 2, 1, 4, 3, 0};

        sortingForTests.insertionSortForTest(array);
    }

}