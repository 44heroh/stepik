package stepik_4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Sample Input:
 *
 * 3 50
 * 60 20
 * 100 50
 * 120 30
 * Sample Output:
 *
 * 180.000
 * */
public class ContinuesBackPack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double count = Double.parseDouble(bufferedReader.readLine());
        double size = Double.parseDouble(bufferedReader.readLine());

        List<Item> items = new ArrayList();

        for (int i = 0; i < count; i++){
            items.add(i, new Item(Double.parseDouble(bufferedReader.readLine()), Double.parseDouble(bufferedReader.readLine())));
        }

        items.sort(Item.ItemComparator);

        for(Item item : items){
            System.out.println("cost = " + item.coast + " size = " + item.size);
        }

        printTotalcost(items, size);
    }

    private static void printTotalcost(List<Item> items, double size) {
        Double totalCoast = 0D;
        for(int i = 0; i < items.size(); i++){
            if(size >= items.get(i).size){
                totalCoast += items.get(i).coast;
                size -= items.get(i).size;
                System.out.println("if totalCoast = " + totalCoast);
                System.out.println("if size = " + size);
            } else {
                totalCoast += items.get(i).getPartOfTheItemCost(size);
                size -= items.get(i).size;
                System.out.println("else totalCoast = " + totalCoast);
                System.out.println("else size = " + size);
            }
            System.out.println("totalCoast = " + totalCoast);
            System.out.println("size = " + size);

            if(size <= 0){
                break;
            }
        }
        System.out.println(new DecimalFormat("#0.000").format(totalCoast));
    }

    public static class Item implements Comparable<Item> {
        public double coast;
        public double size;

        public Item(double coast, double size) {
            this.coast = coast;
            this.size = size;
        }

        public static Comparator<Item> ItemComparator = new Comparator<Item>(){

            @Override
            public int compare(Item item1, Item item2) {
                if(item1 == null){
                    return -1;
                }
                if(item2 == null){
                    return 1;
                }
                if(item1.equals(item2)){
                    return 0;
                }
                return item1.compareTo(item2);
            }
        };

        @Override
        public int compareTo(Item item) {
            if(getItemCost() < item.getItemCost()){
                return 1;
            } else {
                return -1;
            }
        }

        public Double getItemCost() {
            return (double) this.coast / (double) this.size;
        }

        public Double getPartOfTheItemCost(double size) {
            return ((double) this.coast / (double) this.size) * size;
        }
    }
}
