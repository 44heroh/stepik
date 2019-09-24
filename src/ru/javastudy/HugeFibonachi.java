package ru.javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Sample Input:
 *
 * 10 2
 * Sample Output:
 *
 * 1
 * */
public class HugeFibonachi {

    public static void main(String[] args) throws IOException {
	// write your code here
        /*Scanner s = new Scanner(System.in);
        Long a = s.nextLong();
        Long b = s.nextLong();*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Long a = Long.parseLong(bufferedReader.readLine());
        Long b = Long.parseLong(bufferedReader.readLine());
        System.out.println(getHugeFibonacci(a, b));
    }

    private static long getHugeFibonacci(Long a, Long b) {
        ArrayList<Long> arr = getPisanoPeriods(b);
        int period = arr.size() - 2;
        int res = (int)(a % period);
        return res;
    }

    private static ArrayList<Long> getPisanoPeriods(Long b) {
        ArrayList<Long> arr = new ArrayList();
        arr.add((long)0);
        arr.add((long)1);
        for(int i = 2; i < b * 6; i++){
            arr.add((arr.get(i - 1) + arr.get(i -2 )) % b);
            if(arr.get(i) == 1 && arr.get(i - 1) == 0){
                break;
            }
        }

        return arr;
    }
}
