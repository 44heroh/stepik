package stepik_4_2;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Sample Input 1:
 *
 * 1 1
 * a: 0
 * 0
 * Sample Output 1:
 *
 * a
 * Sample Input 2:
 *
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 * Sample Output 2:
 *
 * abacabad
 */
public class HuffmanDecoding {

    private static final char emptyNodeChar = 216;
    private static final char leftTurnCharacter = '0';

    /**
     * Класс представляющий дерево
     */
    private static class Tree {
        private Node root;

        Tree(Node root){
            this.root = root;
        }

        /**
         * @return корневой элемент дерева
         */
        Node getRoot(){
            return root;
        }
    }

    /**
     * Класс представляющий узел дерева
     */
    private static class Node {
        int key;
        int value;
        Node leftChild;
        Node rightChild;

        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Character, String> codeTable = new LinkedHashMap<>();
        int count = scanner.nextInt();
        int size = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++){
            String charAndFrequency = scanner.nextLine();
            codeTable.put((charAndFrequency.substring(0, charAndFrequency.indexOf(':')).trim().charAt(0)), charAndFrequency.substring(charAndFrequency.indexOf(':') + 1).trim());
            System.out.println((charAndFrequency.substring(0, charAndFrequency.indexOf(':')).trim().charAt(0)));
            System.out.println(charAndFrequency.substring(charAndFrequency.indexOf(':') + 1).trim());
        }
        String encodedString = scanner.nextLine();
        codeTable = codeTable
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(decode(encodedString, codeTable));
    }

    private static String decode(String encodedString, HashMap<Character, String> codeTable) {
        Tree huffmanDecodeTree = createDecodingTree(codeTable);
        StringBuilder decodeMessage = new StringBuilder();

        Node current = huffmanDecodeTree.getRoot();
        for(char ch : encodedString.toCharArray()){
            System.out.println("ch = " + ch);
            if(ch == leftTurnCharacter){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if(current.key != emptyNodeChar){
                System.out.println("current.key = " + (char) current.key);
                decodeMessage.append((char) current.key);
                current = huffmanDecodeTree.getRoot();
            }
        }
        return decodeMessage.toString();
    }


    /**
     * Построить дерево Хаффмана для декодирования сообщения
     *
     * @param codeTable таблица двоичных кодовcodeTable
     * @return дерево Хаффмана
     */
    private static Tree createDecodingTree(HashMap<Character, String> codeTable) {
        Tree huffmanDecoding = new Tree(new Node(emptyNodeChar, emptyNodeChar));
        Node rootNode = huffmanDecoding.getRoot();
        for (Map.Entry<Character, String> entry : codeTable.entrySet()) {
            Character key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key = " + key + " value = " + value);
            Node currentNode = rootNode;
            System.out.println("currentNode = " + currentNode.value);
            for (char ch : value.toCharArray()) {
                if (ch == leftTurnCharacter) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node(emptyNodeChar, emptyNodeChar);
                    }
                    currentNode = currentNode.leftChild;
                    System.out.println("currentNode.leftChild.key = " + currentNode.key + " currentNode.leftChild.value = " + currentNode.value);
                } else {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node(emptyNodeChar, emptyNodeChar);
                    }
                    currentNode = currentNode.rightChild;
                    System.out.println("currentNode.rightChild.key = " + currentNode.key + " currentNode.rightChild.value = " + currentNode.value);
                }
            }

            currentNode.key = key;
        }

        return huffmanDecoding;
    }
}
