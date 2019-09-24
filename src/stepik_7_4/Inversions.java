package stepik_7_4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Inversions {

    private int[] temp;
    private int[] a;
    private long count = 0;

    private void merge(int l, int m, int r){
        int i = l;
        int j = m;
        System.out.println(Arrays.toString(temp));
        for(int k = l; k < r; k++){
            if(j == r || (i < m && a[i] <= a[j])){
                temp[k] = a[i];
                i++;
            } else {
                count += m - i;
                temp[k] = a[j];
                j++;
            }
        }
        System.arraycopy(temp, l, a, l, r - l);
    }

    private void mergeSort(int l, int r) {
        if(r <= l + 1) return;
//        int n = a.length;
        int m = (l + r) >> 1; //= int m = n / 2;
        mergeSort(l, m);
        mergeSort(m, r);
        merge(l, m, r);
        /*System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, n - m);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);*/
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Inversions().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/stepik_7_4/input.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];
        String[] tokens = bufferedReader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(tokens[i]);
        }

        /*Scanner in = new Scanner(new File("src/stepik_7_4/input-test.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }*/
        /*Arrays.sort(a);
        System.out.println(Arrays.toString(a));*/
       /* for(int i = 0; i < n; i++){
            System.out.println(a[i]);
        }*/
        temp = new int[n];
        mergeSort(0, n);
        System.out.println(Arrays.toString(temp));
        System.out.println(count);
//        System.out.println(Arrays.toString(sortedA));
//        System.out.println(Arrays.toString(merge(new int[]{2, 5, 6, 14, 25}, new int[]{1, 3, 4, 5, 7, 8})));
    }
}
