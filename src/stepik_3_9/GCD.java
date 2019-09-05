package stepik_3_9;

import stepik_3_8.FibonachiHugeNoCache;

public class GCD {
    private int gcd(int a, int b){
        if (a == 0) return b;
        if (b == 0) return a;
        if(a >= b){
            return gcd(a % b, b);
        } else {
            return gcd(a, b % a);
        }
    }
    private void run() {
        System.out.println(gcd(1141 * 2231, 1141 * 5412));
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new GCD().run();
        long finishtime = System.currentTimeMillis();
        System.out.println(finishtime - startTime + " ms");
    }
}
