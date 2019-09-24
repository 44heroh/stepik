package stepik_8_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LargestSequentialSubSequence {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(new File("src/stepik_8_2/input.txt"));
        int[] arr = new int[scanner.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(getSequenceLength(arr));
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private static int getSequenceLength(int[] arr) {
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = 1;
            for(int j = 0; j <= i - 1; j++){
                if((arr[i] % arr[j] == 0) && (res[j] + 1 > res[i])){
                    res[i] = res[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < res[i]){
                max = res[i];
            }
        }

        return max;
    }
}
