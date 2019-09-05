package stepik_3_8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonachiNew {

    List<BigInteger> cache = new ArrayList<>();
    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }

    private BigInteger fibonachi(int n){
        for(int i = cache.size(); i <= n; i++){
            BigInteger res = cache.get(i - 1).add(cache.get(i - 2));
            cache.add(res);
        }
        return cache.get(n);
    }
    private void run(int n){
        System.out.println(n + ": " + fibonachi(n));
    }
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new FibonachiNew().run(100000);
        long finishtime = System.currentTimeMillis();
        System.out.println(finishtime - startTime + " ms");
    }
}
