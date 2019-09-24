package stepik_8_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LargestNonIncreasingSubSequence {
    private static final boolean useBinarySearch = true;
    private static final boolean printValues = false;

    private static int elementsNumber;
    private static int lisSize = 0;
    private static int[] inputValues;
    private static int[] tail;
    private static int[] pos;
    private static int[] prev;

    private static void fillArrays() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/stepik_8_2/input-2.txt"));
        elementsNumber = scanner.nextInt();
        inputValues = new int[elementsNumber];

        for (int i = elementsNumber - 1; i >= 0; i--){
            inputValues[i] = scanner.nextInt();
        }
        scanner.close();

        tail = new int[elementsNumber + 1];
        Arrays.fill(tail, Integer.MAX_VALUE);
        tail[0] = Integer.MIN_VALUE;

        pos = new int[elementsNumber + 1];
        Arrays.fill(pos, 0);
        pos[0] = -1;

        prev= new int[elementsNumber + 1];
        Arrays.fill(prev, -1);
    }

    private static int binarySearch(int inputValue) {
        int left = 0;
        int right = lisSize + 1;
        int middle = 0;
        while (right > left){
            middle = (right + left) / 2 + 1;
            if(middle - 1 >= 0 && tail[middle -1] <= inputValue && tail[middle] > inputValue){
                return middle;
            }

            if(tail[middle] > inputValue){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if(tail[right] > inputValue){
            return right;
        } else if(tail[left] > inputValue){
            return left;
        } else {
            return middle;
        }
    }

    private static void findLIS() {
        for(int i = 0; i < elementsNumber; i++){
            int position = binarySearch(inputValues[i]);
            if(tail[position - 1] <= inputValues[i] && tail[position] > inputValues[i]){
                tail[position] = inputValues[i];
                pos[position] = i;
                prev[i] = pos[position - 1];

                lisSize = position > lisSize ? position : lisSize;
            }
        }
    }

    private static void printResults() {
        StringBuilder stringBuilder = new StringBuilder();
        int position = pos[lisSize];
        while (position != -1){
            stringBuilder.append(elementsNumber - position + " ");
            position = prev[position];
        }

        System.out.println(lisSize);
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws FileNotFoundException {
        fillArrays();
        findLIS();
        printResults();
    }
}
