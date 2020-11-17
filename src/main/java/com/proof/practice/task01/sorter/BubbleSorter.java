package com.proof.practice.task01.sorter;

public class BubbleSorter implements forSortMethods {
    public void sort(int[] array) {

        System.out.println("bubble");


        for (int q = 0; q < array.length-1; q++)
            for (int w = 0; w < array.length - q - 1; w++)
                if (array[w] > array[w+1]) {
                    int temp = array[w];
                    array[w] = array[w+1];
                    array[w+1] = temp;
                }

    }
}
