package stepik_5_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyKnapsack {
    class Item implements Comparable<Item>{
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", price=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item item) {
            long r1 = (long) cost * item.weight;
            long r2 = (long) item.cost * weight;
            /*double r1 = (double) cost / weight;
            double r2 = (double) item.cost / item.weight;*/
            return -Double.compare(r1, r2);
        }
    }
    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/stepik_5_5/input.txt"));
        int n = in.nextInt();
        int w = in.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++){
            items[i] = new Item(in.nextInt(), in.nextInt());
        }
        /*Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double r1 = (double) item1.cost / item1.price;
                double r2 = (double) item2.cost / item2.price;
                return -Double.compare(r1, r2);
            }
        });*/
        Arrays.sort(items);
        double result = 0;
        for (Item item : items){
            if(item.weight <= w){
                result += item.cost;
                w -= item.weight;
            } else {
                result += (double) item.cost * w / item.weight;
                break;
            }
        }

        System.out.println(result);
    }
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new GreedyKnapsack().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
