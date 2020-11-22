package com.proof.practice.task01.sorter;

public class MergeSorter implements Sorter {
    public void sort(int[] array) {
        int[] firstPart =  new int[array.length / 2];
        int[] secondPart= new int[array.length - (array.length / 2)];

        for(int i = 0; i < firstPart.length; i++){
            firstPart[i] = i;
        }
        for(int i = 0; i < secondPart.length; i++){
            secondPart[i] = i;
        }
        sort(firstPart);
        sort(secondPart);

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
}

