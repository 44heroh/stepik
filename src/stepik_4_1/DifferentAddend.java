package stepik_4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Sample Input 1:
 *
 * 4
 * Sample Output 1:
 *
 * 2
 * 1 3
 * Sample Input 2:
 *
 * 6
 * Sample Output 2:
 *
 * 3
 * 1 2 3
 * */
public class DifferentAddend {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dividend = scan.nextInt();

        List<Integer> result = new ArrayList<>();

        int i = 1;
        int counter = 0;
        int elementsSum = 0;

        while(true){
            if(dividend <= 2){
                result.add(dividend);
                break;
            }

            if(elementsSum + i <= dividend){
                result.add(i);
                elementsSum += i;
                i++;
                counter++;
            } else {
                counter--;
                while (true){
                    if (dividend == elementsSum){
                        break;
                    }
                    result.set(counter == 0 ? 0 : counter, result.get(counter) + 1);
                    elementsSum += 1;
                }
                break;
            }
        }

        System.out.println(result.size());
        System.out.print(result.get(0));
        for(int j = 1; j < result.size(); j++){
            System.out.print(" " + result.get(j));
        }
    }
}
