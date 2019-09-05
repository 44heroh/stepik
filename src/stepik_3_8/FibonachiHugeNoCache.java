package stepik_3_8;

import java.util.ArrayList;
import java.util.List;

public class FibonachiHugeNoCache {
    private static final int MOD = (int) (1e9+7);

    private int fibonachi(int n){
        int a = 0;
        int b = 1;
        for(int i = 0; i < n; i++){
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return a;
    }
    private void run(int n){
        System.out.println(n + ": " + fibonachi(n));
    }
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new FibonachiHugeNoCache().run(100000);
        long finishtime = System.currentTimeMillis();
        System.out.println(finishtime - startTime + " ms");
    }
}
