package stepik_6_7;

import java.util.Arrays;

public class HeapSortMy {
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {1,12,9,5,6,10};

        HeapSortMy hs = new HeapSortMy();
        hs.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    private void sort(int[] arr) {
        int n = arr.length;

        //Построить max кучу
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        //Сортировка кучи
        for(int i =  n - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int large = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[large]){
            large = left;
        }

        if(right < n && arr[right] > arr[large]){
            large = right;
        }

        if(large != i){
            int temp = arr[i];
            arr[i] = arr[large];
            arr[large] = temp;
            heapify(arr, n, large);
        }
    }
}
