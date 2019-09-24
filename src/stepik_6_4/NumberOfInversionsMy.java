package stepik_6_4;

import java.util.Scanner;

public class NumberOfInversionsMy {
    private static int inversions = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner= new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        mergeSort(array, 0, array.length - 1);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private static int[] mergeSort(int[] array, int left, int right) {
        int center = (left + right) / 2;

        if(left >= right){
            return new int[]{array[left]};
        }

        if(right - left == 1){
            System.out.println("right = " + right + " left = " + left);
            if(array[left] > array[right]){
                inversions++;
                System.out.println("array[left] = " + array[left] + " array[right] = " + array[right]);
                return new int[]{array[right], array[left]};
            }
            return new int[]{array[left], array[right]};
        }

        return merge(mergeSort(array, left, center), mergeSort(array, center + 1, right));
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        System.out.println("New recursion START _____________________________");
        System.out.println("leftArr.length = " + leftArr.length + " rightArr.length = " + rightArr.length);
        int[] sortedArr = new int[leftArr.length + rightArr.length];
        int leftCount = 0;
        int rightCount = 0;
        int sortedCount = 0;

        for(int i = 0; i < sortedArr.length; i++){
            if(leftCount == leftArr.length){
                System.out.println("left == leftCount = " + leftCount + " leftArr.length = " + leftArr.length);
                int r = rightCount++;
                int s = sortedCount++;
                int res = sortedArr[s] = rightArr[r];
                System.out.println("left == rightCount = " + r + " sortedCount = " + s + " res = " + res);
                continue;
            }

            if(rightCount == rightArr.length){
                System.out.println("right == rightCount = " + rightCount + " rightArr.length = " + rightArr.length);
                int l = leftCount++;
                int s = sortedCount++;
                int res = sortedArr[s] = leftArr[l];
                System.out.println("right == leftCount = " + l + " sortedCount = " + s + " res = " + res);
                continue;
            }

            if(leftArr[leftCount] > rightArr[rightCount]){
                System.out.println("> inversions = " + inversions);
                System.out.println("> inversions = leftArr.length (" + leftArr.length + ") - leftCount (" + leftCount + ")");
                inversions = leftArr.length - leftCount;
                System.out.println("> leftCount = " + leftCount + " rightCount = " + rightCount);
                System.out.println("> leftArr[leftCount] = " + leftArr[leftCount] + " rightArr[rightCount] = " + rightArr[rightCount]);
                int r = rightCount++;
                int s = sortedCount++;
                int res = sortedArr[s] = rightArr[r];
                System.out.println("> rightCount = " + r + " sortedCount = " + s + " res = " + res);
            } else {
                System.out.println("< leftCount = " + leftCount + " rightCount = " + rightCount);
                System.out.println("< leftArr[leftCount] = " + leftArr[leftCount] + " rightArr[rightCount] = " + rightArr[rightCount]);
                int l = leftCount++;
                int s = sortedCount++;
                int res = sortedArr[s] = leftArr[l];
                System.out.println("< leftCount = " + l + " sortedCount = " + s + " res = " + res);
            }
        }

        for(int i = 0; i < sortedArr.length; i++){
            System.out.println("key = " + i + " val = " + sortedArr[i]);
        }
        System.out.println("New recursion END _____________________________");

        return sortedArr;
    }

}
