/*
package stepik_4_3;
import java.util.Scanner;

class Node {
    private int key;

    Node(int key) {
        this.key = key;
    }

    int getKey() {
        return key;
    }


    void setKey(int key) {
        this.key = key;
    }
}

class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    Heap(int maxSize){
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    boolean insert(int index) {
        if(currentSize == maxSize){
            return false;
        }

        Node newNode = new Node(index);
        heapArray[currentSize] = newNode;
        tickleUp(currentSize++);
        return true;
    }

    Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        tickleDown(0);
        return root;
    }

    void tickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    void tickleDown(int index) {
        int largeChild;
        Node top = heapArray[index];
        while (index < currentSize / 2){
            int leftChild = 2 * index + 1;
            int rightChild = index + 1;
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


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Heap heap = new Heap(size);
        for(int i = 0; i < size; i++){
            if(scanner.next().toLowerCase().equals("extractmax")){
                System.out.println(heap.remove().getKey());
            } else {
                heap.insert(scanner.nextInt());
            }
        }
    }
}
*/
