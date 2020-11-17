package com.proof.practice.task01.util;

public class SortingTypes {

    public static void main(String[] args) {



    }

    // done мой код
    public static void bubbleSortWithFor(int[] array){

        for(int q = array.length - 1; q >= 0 ; q--){

            for(int w = 0; w < q; w++){

                if(array[w] > array[w + 1]){

                    int temp = array[w];
                    array[w] = array[w + 1];
                    array[w + 1] = temp;

                }

            }

        }

    }
    // done мой код
    public static void bubbleSortWithWhile(int[] array){

        boolean variableBoo = true;

        while(variableBoo){

            variableBoo = false;

            for(int q = 1; q < array.length; q++){

                if(array[q] < array[q - 1]){

                    int temp = array[q];
                    array[q] = array[q - 1];
                    array[q - 1] = temp;

                    variableBoo = true;

                }

            }

        }

    }
    // done мой код
    public static void insertionSort(int[] array){

        for(int first = 0; first < array.length; first++){

            int index = array[first];

            int cell = first - 1;

            while(cell >= 0 && array[cell] > index){

                array[cell + 1] = array[cell];
                cell--; //var = var - 1;

            }

            array[cell + 1] = index;

            // second way
//            for( ; var >= 0; var++){
//
//                if(value < array[cell]){
//
//                   array[cell + 1] = array[cell];
//
//                  }else{break};
//
//            }
//              array[cell + 1] = index;

        }

    }
    // done мой код
    public static void selectionSort(int[] array){

        for(int first = 0; first < array.length; first++){

            int minIndex = first;

            for(int q = first; q < array.length; q++){

                if(array[q] < array[minIndex]){

                    minIndex = q;

                }

            }

            int temp = first;
            first = minIndex;
            minIndex = temp;

        }

    }

    // не мой код
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {

// Двигаем левый маркер слева направо пока элемент меньше, чем pivot

            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

// Двигаем правый маркер, пока элемент больше, чем pivot

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }

// Проверим, не нужно обменять местами элементы, на которые указывают маркеры

            if (leftMarker <= rightMarker) {

// Левый маркер будет меньше правого только если мы должны выполнить swap

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }

// Сдвигаем маркеры, чтобы получить новые границы

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


// Выполняем рекурсивно для частей

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
    // мой код
    public static void mergeSort(int[] Array){


        int[] firstPart =  new int[Array.length / 2];
        int[] secondPart= new int[Array.length - (Array.length / 2)];


        for(int q = 0; q < firstPart.length; q++){

            firstPart[q] = q;

        }

        for(int q = 0; q < secondPart.length; q++){

            secondPart[q] = q;

        }

        // возможно вместо циклов выше, стоит сделать так:
        //int[] firstPart = Arrays.copyOf(Array, Array.length / 2);
        //int[] secondPart = Arrays.copyOf(Array, Array.length - (Array.length / 2));

        //рекурсия, на сколько я понял она должна повторно поделить 1ую(левую) и 2ую(правую) части массива
        mergeSort(firstPart);
        mergeSort(secondPart);


        int[] mergeOfParts = new int[firstPart.length + secondPart.length];

        int position_firstPart = 0;
        int position_secondPart = 0;

        // тут происходит слияние двух массивов, с учетом если вдруг какой то массив закончиться раньше
        for (int q = 0; q < mergeOfParts.length; q++) {

            if (position_firstPart == firstPart.length){

                mergeOfParts[q] = secondPart[q - position_secondPart];
                position_secondPart++;

            } else if (position_secondPart == secondPart.length) {

                mergeOfParts[q] = firstPart[q - position_firstPart];
                position_firstPart++;

            } else if (firstPart[q - position_firstPart] < secondPart[q - position_secondPart]) {

                mergeOfParts[q] = firstPart[q - position_firstPart];
                position_secondPart++;

            } else {

                mergeOfParts[q] = secondPart[q - position_secondPart];
                position_firstPart++;

            }


        }

    }
    //  не мой код, я его разобрал, и понимаю что тут происходит
    public static void mergeSort2(int[] source, int left, int right) {

// Выберем разделитель, т.е. разделим пополам входной массив

        int delimiter = left + ((right - left) / 2) + 1;

// Выполним рекурсивно данную функцию для двух половинок ,если сможем разбить(

        if (delimiter > 0 && right > (left + 1)) {
            mergeSort2(source, left, delimiter - 1);
            mergeSort2(source, delimiter, right);
        }

// Создаём временный массив с нужным размером

        int[] buffer = new int[right - left + 1];

// Начиная от указанной левой границы идём по каждому элементу

        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {

// Мы используем delimeter чтобы указывать на элемент из правой части


// Если delimeter > right, значит в правой части не осталось недобавленных элементов

            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }

        // c массива buffer начиная с нулевого элемента и все остольные, копирую в source
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }





}
