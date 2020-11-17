package com.proof.practice.task01.sorter;

public class ArraySorter {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,2,5,6,4,7};

        ArraySorter obj = new ArraySorter();

        obj.sort(arr, SortType.BUBBLE_SORT);

        for(int cell : arr){

            System.out.print(arr[cell] + ' ');

        }

    }

    public void sort(int[] array, SortType BUBBLE_SORT){

        System.out.println(BUBBLE_SORT);

    }

}

