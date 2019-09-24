package stepik_6_5;

import java.util.Arrays;

public class AlgorithmQuickSort {
    public static void main(String[] args) {
        int[] arr = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(arr));

        int low = 0;
        int hight = arr.length - 1;

        quickSort(arr, low, hight);

        System.out.println("Стало");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int hight) {
        int center = low + (hight - low) / 2;
        System.out.println("center = " + center);
        int oporEl = arr[center];
        System.out.println("oporEl = " + oporEl);

        if(arr.length == 0){
            return;
        }

        if(low > hight){
            return;
        }

        int i = low;
        int j = hight;
        while (i <= j){
            while (arr[i] < oporEl){
                System.out.println("< i = " + i);
                System.out.println("< arr[i] = " + arr[i]);
                i++;
                System.out.println("< i = " + i);
                System.out.println("< arr[i] = " + arr[i]);
            }
            while (arr[j] > oporEl){
                System.out.println("> j = " + j);
                System.out.println("> arr[j] = " + arr[i]);
                j--;
                System.out.println("> j = " + j);
                System.out.println("> arr[j] = " + arr[i]);
            }
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));

        if(low < j){
            quickSort(arr, low, j);
        }

        if(hight > i){
            quickSort(arr, i, hight);
        }
    }
}
