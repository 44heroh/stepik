package stepik_3_8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class FibonachiHuge {
    private static final int MOD = (int) (1e9+7);

    List<Integer> cache = new ArrayList<>();
    {
        cache.add(0);
        cache.add(1);
    }

    private int fibonachi(int n){
        for(int i = cache.size(); i <= n; i++){
            int res = (cache.get(i - 1) + cache.get(i - 2)) % MOD;
            cache.add(res);
        }
        return cache.get(n);
    }
    private void run(int n){
        System.out.println(n + ": " + fibonachi(n));
    }
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new FibonachiHuge().run(100000);
        long finishtime = System.currentTimeMillis();
        System.out.println(finishtime - startTime + " ms");
    }
}
