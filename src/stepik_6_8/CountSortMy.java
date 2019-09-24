package stepik_6_8;

import java.util.Arrays;
import java.util.Scanner;

public class CountSortMy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new  int[count];
        int maxEl = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
            if(arr[i] > maxEl){
                maxEl = arr[i];
            }
        }
        System.out.println(Arrays.toString(sort(arr, maxEl)).replaceAll("\\[", "").replaceAll(",", "").replaceAll("]", ""));
    }

    private static int[] sort(int[] arr, int maxEl) {
        int[] temp = new int[maxEl + 1];
        int[] result = new int[arr.length];
        for(int el : arr){
            temp[el] = temp[el] + 1;
        }

        for(int i = 2; i < temp.length; i++){
            temp[i] = temp[i] + temp[i - 1];
        }

        for(int i = arr.length - 1; i >= 0; i--){
            result[temp[arr[i]] - 1] = arr[i];
            temp[arr[i]] = temp[arr[i]] - 1;
        }

        return result;
    }
}
