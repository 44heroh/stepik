package stepik_3_8;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonachi {

    Map<Integer, BigInteger> cache = new HashMap<>();

    int count;

    private BigInteger fibonachi(int n){
        count++;
        if(n < 2){
            return BigInteger.valueOf(n);
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        } else {
            for(int i = 2; i <= n; i++){
                BigInteger res = fibonachi(i - 1).add(fibonachi(i - 2));
                cache.put(i, res);
            }
            return cache.get(n);
        }
    }
    private void run(int n){
        System.out.println(n + ": " + fibonachi(n));
        System.out.println("count = " + count);
    }
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new Fibonachi().run(100000);
        long finishtime = System.currentTimeMillis();
        System.out.println(finishtime - startTime + " ms");
    }
}
