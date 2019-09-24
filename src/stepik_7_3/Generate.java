package stepik_7_3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Generate {
    public static void main(String[] args) throws FileNotFoundException {
        new Generate().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("src/stepik_7_3/input.txt");
        int n = 100000;
        int k = 100000;
        Random random = new Random();
        int[] a = new int[n];
        int[] b = new int[k];
        for(int i = 0; i < n; i++){
            a[i] = random.nextInt(1000000000);
            System.out.println(a[i]);
        }
        Arrays.sort(a);
        for(int i = 0; i < k; i++){
            b[i] = a[random.nextInt(n)];
            System.out.println(b[i]);
        }

        printWriter.print(n);
        for(int i = 0; i < n; i++){
            printWriter.print(" " + a[i]);
        }
        printWriter.println();

        printWriter.print(n);
        for(int i = 0; i < k; i++){
            printWriter.print(" " + b[i]);
        }
        printWriter.println();
        printWriter.close();
    }
}
