package com.proof.practice.task01.util;

import java.util.Arrays;

public class SortingTypes {

    public static void bubbleSortWithFor(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++){

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortWithWhile(int[] array){
        boolean isСondition = true;
        while(isСondition){
            isСondition = false;
            for(int i = 1; i < array.length; i++){

                if(array[i] < array[i - 1]){
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;

                    isСondition = true;
                }
            }
        }
    }

    public static void insertionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int index = array[i];
            int cell = i - 1;

            while(cell >= 0 && array[cell] > index){
                array[cell + 1] = array[cell];
                cell--; //var = var - 1;
            }
            array[cell + 1] = index;
        }
    }

    public static void selectionSort(int[] array){
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

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    public static void mergeSort(int[] array){
        int[] firstPart =  new int[array.length / 2];
        int[] secondPart= new int[array.length - (array.length / 2)];

        for(int i = 0; i < firstPart.length; i++){
            firstPart[i] = i;
        }
        for(int i = 0; i < secondPart.length; i++){
            secondPart[i] = i;
        }
        mergeSort(firstPart);
        mergeSort(secondPart);

        int[] mergeOfParts = new int[firstPart.length + secondPart.length];
        int positionFirstPart = 0;
        int positionSecondPart = 0;

        for (int i = 0; i < mergeOfParts.length; i++) {

            if (positionFirstPart == firstPart.length){
                mergeOfParts[i] = secondPart[i - positionSecondPart];
                positionSecondPart++;

            } else if (positionSecondPart == secondPart.length) {
                mergeOfParts[i] = firstPart[i - positionFirstPart];
                positionFirstPart++;

            } else if (firstPart[i - positionFirstPart] < secondPart[i - positionSecondPart]) {
                mergeOfParts[i] = firstPart[i - positionFirstPart];
                positionSecondPart++;

            } else {
                mergeOfParts[i] = secondPart[i - positionSecondPart];
                positionFirstPart++;
            }
        }
    }

    public static void mergeSortExempleFromNet(int[] source, int left, int right) {
        int delimiter = left + ((right - left) / 2) + 1;

        if (delimiter > 0 && right > (left + 1)) {
            mergeSortExempleFromNet(source, left, delimiter - 1);
            mergeSortExempleFromNet(source, delimiter, right);
        }

        int[] buffer = new int[right - left + 1];
        int cursor = left;

        for (int i = 0; i < buffer.length; i++) {
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }
}
