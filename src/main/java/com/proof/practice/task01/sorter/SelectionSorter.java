package com.proof.practice.task01.sorter;

public class SelectionSorter implements Sorter{
    public void sort(int[] array) {
        for(int i = 0; i < array.length; i++){
            int minIndex = i;

            for(int j = i; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = i;
            i = minIndex;
            minIndex = temp;
        }
    }
}
