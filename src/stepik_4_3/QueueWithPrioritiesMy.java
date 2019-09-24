package stepik_4_3;

import java.util.Scanner;

class Node1 {
    private int key;

    Node1(int key) {
        this.key = key;
    }

    int getKey() {
        return key;
    }


    void setKey(int key) {
        this.key = key;
    }
}

class Heap1 {
    private Node1[] heapArray;
    private int maxSize;
    private int currentSize;

    Heap1(int maxSize){
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node1[maxSize];
    }

    /**
     * Вставить ключ в кучу
     *
     * @param index ключ
     * @return признак успешности вставки
     */
    boolean insert(int index) {
        if(currentSize == maxSize){
            return false;
        }
        /*System.out.println("index = " + index);
        System.out.println("currentSize = " + currentSize);*/

        Node1 newNode = new Node1(index);
        heapArray[currentSize] = newNode;
        /*System.out.println("heapArray[currentSize] = " + heapArray[currentSize]);
        System.out.println("heapArray[currentSize] = " + heapArray[currentSize]);*/
        tickleUp(currentSize++);
        return true;
    }

    /**
     * Выполнить перемещение узла вверх по куче
     *
     * @param index индекс перемещаемого узла
     */
    void tickleUp(int index) {
        /*System.out.println("tickleUp() =>");
        System.out.println("index = " + index);*/
        int parent = (index - 1) / 2;
        Node1 bottom = heapArray[index];
        /*System.out.println("heapArray[" + index + "].getKey() = " + heapArray[index].getKey());
        System.out.println("heapArray[" + parent + "].getKey() = " + heapArray[parent].getKey());*/

        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        for(int i = 0; i <= index; i++){
            System.out.println("heapArray[" + i + "].getKey() = " + heapArray[i].getKey());
        }
        heapArray[index] = bottom;
    }

    /**
     * Выполнить удаление узла из кучи
     *
     * @return удаленный узел
     */
    Node1 remove() {
        Node1 root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        tickleDown(0);
        return root;
    }

    /**
     * Выполнить перемещение узла вниз по куче
     *
     * @param index индекс перемещаемого узла
     */
    void tickleDown(int index) {
        int largeChild;
        Node1 top = heapArray[index];
        while (index < currentSize / 2)
        {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()){
                largeChild = rightChild;
            } else {
                largeChild = leftChild;
            }

            if(top.getKey() >= heapArray[largeChild].getKey()){
                break;
            }
            heapArray[index] = heapArray[largeChild];
            index = largeChild;
        }
        heapArray[index] = top;
    }
}

public class QueueWithPrioritiesMy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Heap1 heap = new Heap1(size);
        for(int i = 0; i < size; i++){
            if(scanner.next().toLowerCase().equals("extractmax")){
                System.out.println(heap.remove().getKey());
            } else {
                heap.insert(scanner.nextInt());
            }
        }
    }
}
