package stepik_6_1;

import java.util.Scanner;
/**
 * Sample Input:
 *
 * 5 1 5 8 12 13
 * 5 8 1 23 1 11
 * Sample Output:
 *
 * 3 1 -1 1 -1
 * */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstArray[] = new int[scanner.nextInt()];
        for(int i = 0; i < firstArray.length; i++){
            firstArray[i] = scanner.nextInt();
        }

        for (int index : firstArray){
            System.out.println("index = " + index);
        }

        int elementsCount = scanner.nextInt();
        System.out.println("elementsCount = " + elementsCount);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < elementsCount; i++){
            if(i != 0){
                builder.append(" ");
            }
            System.out.println(binnarySearch(firstArray, scanner.nextInt()));
        }
    }

    public static int binnarySearch(int[] firstArray, int searchValue) {
        int retValue = -1;
        int leftSize = 0;
        int rightSize = firstArray.length - 1;

        while(true){
            int center = (leftSize + rightSize) / 2;

            System.out.println("start center = "  + center);
            System.out.println("start leftSize = "  + leftSize);
            System.out.println("start rightSize = "  + rightSize);

            if(firstArray[center] == searchValue){
                retValue = center + 1;
                break;
            } else if(firstArray[center] < searchValue){
                leftSize = center + 1;
            } else if(firstArray[center] > searchValue){
                rightSize = center - 1;
            }

            System.out.println("end center = "  + center);
            System.out.println("end leftSize = "  + leftSize);
            System.out.println("end rightSize = "  + rightSize);

            if(leftSize > rightSize){
                break;
            }
        }

        return retValue;
    }
}
