package stepik_4_2;

import java.util.*;
import java.util.stream.Collectors;
/**
 *Sample Input 1:
 *
 * a
 *
 * Sample Output 1:
 *
 * 1 1
 * a: 0
 * 0
 * Sample Input 2:
 *
 * abacabad
 *
 * Sample Output 2:
 *
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 * */
public class HuffmanEncoding {
    private static final char emptyNodeChar = 216;
    private static final char leftTurnCharacter = '0';
    private static final char rightTurnCharacter = '1';

    /**
     * Создание частотной таблицы
     *
     * @param message сообщение
     * @return частотная таблица
     */

    private static HashMap<Character, Integer> makeFrequencyTable(String message) {
        LinkedHashMap<Character, Integer> frequencyTable = new LinkedHashMap<>();
        for(char ch : message.toCharArray()){
            if(frequencyTable.containsKey(ch)){
                frequencyTable.computeIfPresent(ch, (k, v) -> v + 1);
            } else {
                frequencyTable.put(ch, 1);
            }
        }

        frequencyTable = frequencyTable
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return frequencyTable;
    }

    /**
     * Создание кодовой таблицы
     *
     * @param message сообщение
     * @return кодовая таблица
     */
    private static HashMap<Character, String> makeCodeTable(String message) {
        Tree huffmanTree = makeTree(message);
        HashMap<Character, String> codeTable = new LinkedHashMap<>();

        for(char ch : message.toCharArray()){
            if(!codeTable.containsKey(ch)){
                codeTable.put(ch, getBinaryCharacterCode(huffmanTree.getRoot(), ch, new StringBuilder()));
            }
        }

        return codeTable;
    }

    /**
     * Рекурсивное получение двоичного кода для символа
     * при помощи дерева Хаффмана
     *
     * @param rootNode               корневой элемент дерева Хаффмана
     * @param character              символ
     * @param binaryCharacterBuilder постротель двоичного кода
     * @return двоичный код символа
     */
    private static String getBinaryCharacterCode(Node rootNode, char character, StringBuilder binaryCharacterBuilder) {
        String result = "";

        if(binaryCharacterBuilder == null){
            binaryCharacterBuilder = new StringBuilder();
        }

        if(rootNode.key == (int) character){
            return binaryCharacterBuilder.toString();
        }

        if(rootNode.leftChild != null){
            result = getBinaryCharacterCode(rootNode.leftChild, character, binaryCharacterBuilder.append(leftTurnCharacter));
            if(result != null && !result.equals("")){
                return result;
            }
        }

        if(rootNode.rightChild != null){
            result = getBinaryCharacterCode(rootNode.rightChild, character, binaryCharacterBuilder.append(rightTurnCharacter));
            if(result != null && !result.equals("")){
                return result;
            }
        }
        binaryCharacterBuilder.deleteCharAt(binaryCharacterBuilder.length() - 1);
        return result;
    }

    /**
     * Построить дерево Хаффмана
     *
     * @param message сообщение для постройки дерева
     * @return дерево Хаффмана
     */
    private static Tree makeTree(String message) {
        PriorityQueue<Tree> trees = new PriorityQueue<>(
            (Tree firstTree, Tree secondTree)->{
                if(firstTree.getRoot().value > secondTree.getRoot().value){
                    return 1;
                } else if(firstTree.getRoot().value < secondTree.getRoot().value){
                    return -1;
                } else {
                    return 0;
                }
            }
        );

        makeFrequencyTable(message)
                .entrySet()
                .forEach((Map.Entry<Character, Integer> entry) ->
                {
                    Tree tempTree = new Tree(new Node(entry.getKey(), entry.getValue()));
                    trees.add(tempTree);
                });

        if(trees.size() == 1){
            Node leftNode = trees.poll().getRoot();
            Node newNode = new Node(emptyNodeChar, leftNode.value);
            newNode.leftChild = leftNode;
            trees.add(new Tree(newNode));
        } else {
            while (trees.size() != 1) {
                Node leftNode = trees.poll().getRoot();
                Node rightNode = trees.poll().getRoot();

                Node newNode = new Node(emptyNodeChar, leftNode.value + rightNode.value);
                newNode.leftChild = leftNode;
                newNode.rightChild = rightNode;
                trees.add(new Tree(newNode));
            }
        }

        return trees.poll();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next().toLowerCase();

        HashMap<Character, Integer> frequencyTable = makeFrequencyTable(message);
        for (HashMap.Entry<Character, Integer> entry : frequencyTable.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getKey());
        }
        HashMap<Character, String> codeTable = makeCodeTable(message);
        for (HashMap.Entry<Character, String> entry : codeTable.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getKey());
        }
        String encodedMessage = HuffmanEncoding.encode(message);

        System.out.println(frequencyTable.size() + " " + encodedMessage.length());
        codeTable.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println(encodedMessage);
    }

    /**
     * Кодирование сообщения в двоичную форму
     *
     * @param message сообщение
     * @return закодированное сообщение
     */
    private static String encode(String message) {
        Tree huffmanTree = makeTree(message);
        StringBuilder encodedMessage = new StringBuilder();

        for(char ch : message.toCharArray()){
            encodedMessage.append(getBinaryCharacterCode(huffmanTree.getRoot(), ch, new StringBuilder()));
        }

        return encodedMessage.toString();
    }

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
}
