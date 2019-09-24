package stepik_6_4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Sample Input:
 *
 * 5
 * 2 3 9 2 9
 * Sample Output:
 *
 * 2
 * */

public class NumberOfInversions {
    private static long inversions = 0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner= new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        mergeSort(array, 0, array.length-1);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private static int[] mergeSort(int[] array, int leftSide, int rightSide) {
        int center = (leftSide + rightSide) / 2;

        if(leftSide >= rightSide){
            return new int[] {array[leftSide]};
        }

        if(rightSide - leftSide == 1){
            if(array[leftSide] > array[rightSide]){
                ++inversions;
            }
            return new int[] {array[leftSide], array[rightSide]};
        }

        return merge(mergeSort(array, leftSide, center), mergeSort(array, center + 1, rightSide));
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        /*for(int i = 0; i < leftArr.length; i++){
            System.out.println("leftArr key = " + i + " val = " + leftArr[i]);
        }
        for(int i = 0; i < rightArr.length; i++){
            System.out.println("rightArr key = " + i + " val = " + rightArr[i]);
        }
        int[] ArraySorted = IntStream.concat(Arrays.stream(leftArr), Arrays.stream(rightArr)).toArray();
        return ArraySorted;*/

        int[] sortedArray = new int[leftArr.length + rightArr.length];

        int leftCounter = 0;
        int rightCounter = 0;
        int sortedCounter = 0;

        for(int i = 0; i < sortedArray.length; i++){
            if(leftArr[leftCounter] > rightArr[rightCounter]){
                sortedArray[sortedCounter++] = rightArr[rightCounter++];
            } else {
                sortedArray[sortedCounter++] = leftArr[leftCounter++];
            }

            System.out.println("key = " + i + " val = " + sortedArray[i]);
        }

        return sortedArray;
    }
}
