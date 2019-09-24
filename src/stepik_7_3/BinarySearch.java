package stepik_7_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySearch {

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/stepik_7_3/input.txt"));
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        int k = in.nextInt();
        int[] b = new int[k];

        for(int i = 0; i < k; i++){
            b[i] = in.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(a[i], i + 1);
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < k; i++){
//            int pos = binarySearchRepeatsItemL(a, b[i]);
            int pos = map.containsKey(b[i]) ? map.get(b[i]) : -1;
            res.append(pos + " ");
//            System.out.print(pos + " ");
        }
        System.out.println(res);
    }

    private int binarySearch(int[] a, int x){
        int l = -1;
        int r = a.length;
        while (r >= l){
            int m = (l + r) >> 1;
            if(a[m] == x){
                return m + 1;
            } else if(a[m] > x){
                r = m -1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    private int binarySearchRepeatsItemR(int[] a, int x){
        int l = - 1;
        int r = a.length;
        while (r > l + 1){
            int m = (l + r) >> 1;
            if(a[m] < x){
                l = m;
            } else {
                r = m;
            }
        }
        if(r < a.length && a[r] == x){
            return r + 1;
        } else {
            return -1;
        }
    }

    private int binarySearchRepeatsItemL(int[] a, int x){
        int l = - 1;
        int r = a.length;
        while (r > l + 1){
            int m = (l + r) >> 1;
            if(a[m] <= x){
                l = m;
            } else {
                r = m;
            }
        }
        if(r > 0 && a[l] == x){
            return l + 1;
        } else {
            return -1;
        }
    }

    private int linearSearch(int[] a, int x) {
        for(int i = 0; i < a.length; i++){
            if(a[i] == x) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
