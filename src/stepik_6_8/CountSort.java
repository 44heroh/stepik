package stepik_6_8;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
        int count = 5;
//        int[] arr = new  int[count];
        int[] arr = new int[]{2, 3, 9, 2, 9};
        System.out.println(Arrays.toString(arr));
        int maxEl = 0;
        for (int i = 0; i < arr.length; i++){
//            arr[i] = scanner.nextInt();
            if(arr[i] > maxEl){
                maxEl = arr[i];
            }
        }
        System.out.println(Arrays.toString(sort(arr, maxEl)));
    }

    private static int[] sort(int[] arr, int maxEl) {
        int[] temp = new int[maxEl + 1];
        int[] result = new int[arr.length];
        for(int el : arr){
            System.out.println("el = " + el);
            temp[el] = temp[el] + 1;
            System.out.println("temp[el] = " + temp[el]);
        }

        System.out.println(Arrays.toString(temp));

        for (int i = 2; i < temp.length; i++)
        {
            System.out.println("i = " + i);
            System.out.println("temp[i] = " + temp[i] + " + " + temp[i - 1]);
            temp[i] = temp[i] + temp[i - 1];
            System.out.println(temp[i] + " = ");
        }

        System.out.println(Arrays.toString(temp));

        for (int i = arr.length - 1; i >= 0; i--)
        {
            System.out.println("arr[i] = " + result[temp[arr[i]] - 1]);
            System.out.println("temp[" + arr[i] + "] - 1 = " + (temp[arr[i]] - 1));
            result[temp[arr[i]] - 1] = arr[i];
            System.out.println("arr[i] = " + result[temp[arr[i]] - 1]);
//            System.out.println("result[i] = " + (temp[arr[i]] - 1));
            System.out.println("temp[" + arr[i] + "] = " + (temp[arr[i]] - 1));
            temp[arr[i]] = temp[arr[i]] - 1;
            System.out.println(Arrays.toString(result));
            System.out.println(Arrays.toString(temp));
//            System.out.println(temp[arr[i]] + " - 1 = " + (temp[arr[i]] - 1));
        }

        return result;
    }
}
