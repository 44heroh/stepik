package ru.javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Sample Input:
 *
 * 696352
 * Sample Output:
 *
 * 9
 * */
public class FibonachiLast {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
//        int n = 696352;
        long fib = fibLast(n);
        System.out.println(fib);
    }

    public static long fibLast(int n) {
        long[] fib = new long[n + 1];
        if(n == 0){
            return fib[n];
        } else if(n <= 1e+7) {
            fib[0] = 0;
            fib[1] = 1;
            if(n >= 2){
                for(int i = 2; i <= n; i++){
                    fib[i] = (fib[i - 2] + fib[i - 1]) % 10;
                }
            }
            return fib[n];
        }
        return 0;
    }
}
