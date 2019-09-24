package stepik_6_1;

import java.util.Scanner;

public class BinarySearchMy {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner= new Scanner(System.in);
        int firstArray[] = new int[scanner.nextInt()];
        for(int i = 0; i < firstArray.length; i++){
            firstArray[i] = scanner.nextInt();
        }

        int elementCount = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < elementCount; i++){
            if(i != 0){
                stringBuilder.append(" ");
            }
            stringBuilder.append(binarySearch(firstArray, scanner.nextInt()));
        }
        System.out.println(stringBuilder.toString());
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    public static int binarySearch(int[] firstArray, int searchVal) {
        int retVal = -1;
        int left = 0;
        int right = firstArray.length - 1;

        while (true){
            int center = (right + left) / 2;
            System.out.println("start center = "  + center);
            System.out.println("start leftSize = "  + left);
            System.out.println("start rightSize = "  + right);
            if(firstArray[center] == searchVal){
                System.out.println("start retVal = "  + retVal);
                retVal = center + 1;
                System.out.println("end retVal = "  + retVal);
                break;
            } else if(firstArray[center] < searchVal){
                left = center + 1;
            } else if(firstArray[center] > searchVal){
                right = center - 1;
            }

            System.out.println("end center = "  + center);
            System.out.println("end leftSize = "  + left);
            System.out.println("end rightSize = "  + right);

            if(left > right){
                break;
            }
        }
        return retVal;
    }
}
