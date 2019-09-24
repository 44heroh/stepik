package stepik_6_4;

import java.util.Scanner;

public class NumberOfInversionsNew {
    private static int inversions = 0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner= new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        mergeSort(array, 0, array.length - 1);
        System.out.println(inversions);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private static int[] mergeSort(int[] array, int leftSide, int rightSide) {
        int center = (leftSide + rightSide) / 2;
        if(leftSide == rightSide){
            return new int[]{array[leftSide]};
        }

        if(rightSide - leftSide == 1){
            if(array[leftSide] > array[rightSide]){
                inversions++;
                return new int[]{array[rightSide], array[leftSide]};
            }
            return new int[]{array[leftSide], array[rightSide]};
        }

        return merge(mergeSort(array, leftSide, center), mergeSort(array, center + 1, rightSide));
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int[] sortedArr = new int[leftArr.length + rightArr.length];
        int leftCount = 0;
        int rightCount = 0;
        int sortCount = 0;

        for(int i = 0; i < sortedArr.length; i++){
            if(leftCount == leftArr.length){
                sortedArr[sortCount++] = rightArr[rightCount++];
                continue;
            }
            if(rightCount == rightArr.length){
                sortedArr[sortCount++] = leftArr[leftCount++];
                continue;
            }

            if(leftArr[leftCount] > rightArr[rightCount]){
                inversions += leftArr.length - leftCount;
                sortedArr[sortCount++] = rightArr[rightCount++];
            } else {
                sortedArr[sortCount++] = leftArr[leftCount++];
            }
        }

        return sortedArr;
    }
}
