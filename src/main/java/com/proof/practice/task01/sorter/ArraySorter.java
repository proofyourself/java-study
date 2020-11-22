package com.proof.practice.task01.sorter;

public class ArraySorter {
    private static final BubbleSorter BUBBLE_SORTER = new BubbleSorter();
    private static final SelectionSorter SELECTION_SORTER = new SelectionSorter();
    private static final MergeSorter MERGE_SORTER = new MergeSorter();

    public static void main(String[] args) {
        int[] array = {1,3,7,-4,-5,100,10000,0};
        ArraySorter sorter = new ArraySorter();
        sorter.sort(array, SortType.BUBBLE_SORT);
    }

    public void sort(int[] array, SortType sortType){
        if(sortType == SortType.BUBBLE_SORT){
            BUBBLE_SORTER.sort(array);
        }else if(sortType == SortType.SelectionSorter){
            SELECTION_SORTER.sort(array);
        }else if(sortType == SortType.MergeSorter){
            MERGE_SORTER.sort(array);
        }
    }
}

