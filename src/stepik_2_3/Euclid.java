package stepik_2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Euclid {
    public static int res;
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());*/
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(getEuclid(a, b));
    }

    private static long getEuclid(int a, int b) {
        if(a > 0 && b > 0){
            res = 0;
            if(a >= b){
                getEuclid(a % b, b);
            } else if(b >= a) {
                getEuclid(a, b % a);
            }
        } else {
            if(a == 0){
                res = b;
            } else if(b ==0){
                res = a;
            }
        }
        return res;
    }
}
