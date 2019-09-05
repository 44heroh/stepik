package ru.javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonachi {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        long fib = fib(n);
        System.out.println(fib);
    }

    public static long fib(int n) {
        long[] fib = new long[n + 1];
        if(n == 0){
            return fib[n];
        } else {
            fib[0] = 0;
            fib[1] = 1;
            if(n <= 40){
                if(n >= 2){
                    for(int i = 2; i <= n; i++){
                        fib[i] = fib[i - 2] + fib[i - 1];
                    }
                }
            }
            return fib[n];
        }
    }
}
