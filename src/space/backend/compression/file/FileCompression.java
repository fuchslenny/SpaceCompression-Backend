/**
 * @author fuchslenny
 */

package space.backend.compression.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileCompression {

    public static void Compression(String fileValue) {
        ArrayList<String> wordList = Sort(fileValue);
        ArrayList<Double> frequencies = new ArrayList<>();

        for(int i = 0; i<wordList.size(); i++){
            frequencies = relativeFrequency(wordList, i);
        }
        MakeTree(frequencies);
    }

    private static ArrayList<String> Sort(String fileValue){
        String buffer = "";
        StringBuilder characterBuffer = new StringBuilder();
        ArrayList<String> wordList = new ArrayList<>();

        for (int i = 0; i < fileValue.length(); i++) {
            char currentChar = fileValue.charAt(i);

            if (!" ".equals(String.valueOf(currentChar)) || !",".equals(String.valueOf(currentChar)) || !".".equals(String.valueOf(currentChar))) {
                buffer = buffer + currentChar;
            }
            //TODO
            else if (".".equals(String.valueOf(currentChar)) || ",".equals(String.valueOf(currentChar))) {
                characterBuffer.append(currentChar);
                wordList.add(buffer);
            }
        }
        return wordList;
    }

    private static ArrayList<Double> relativeFrequency(ArrayList<String> wordList, int i){
        String buffer = wordList.get(i);
        float letterFrequency;
        HashMap<Character, Integer> charCountMap = characterCount(buffer);
        ArrayList<Double> frequencies = new ArrayList<>();

        for(Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String value = entry.getValue().toString();
            float intValue = Float.parseFloat(value);
            letterFrequency = intValue / buffer.length();
            frequencies.add((double) letterFrequency);
        }
        return frequencies;
    }

    private static HashMap<Character, Integer> characterCount(String buffer){
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] bufferArray = buffer.toCharArray();

        for(char c : bufferArray){
            if(charCountMap.containsKey(c)){
                charCountMap.put(c, charCountMap.get(c)+ 1);
            }
            else{
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }

    private static class Node<T> {
        private T data;
        private Node<T> parent;
        private ArrayList<Node<T>> children;

        private Node<T> addChild(T child) {
            Node<T> childNode = new Node<>();
            childNode.parent = this;
            childNode.data = child;
            this.children.add(childNode);
            return childNode;
        }
    }

    private static void MakeTree(ArrayList<Double> frequencies){
        ArrayList<Double> smallest = new ArrayList<>();
        int size = frequencies.size();
        Node<Double> newNode = new Node<>();

        while(size != 1){
            frequencies = CombineTrees(frequencies, newNode);
        }
    }

    private static ArrayList<Double> CombineTrees(ArrayList<Double> frequencies, Node<Double> newNode){
        double first, second, size = frequencies.size();
        ArrayList<Double> getSmallest = new ArrayList<>();
        first = second = Double.MAX_VALUE;

        for(int i = 0; i<size; i++){
            newNode.addChild(frequencies.get(i));
            if(frequencies.get(i) < first){
                second = first;
                first = frequencies.get(i);
            }
            else if(frequencies.get(i) < second && frequencies.get(i) != first){
                second = frequencies.get(i);
            }
        }
        frequencies.remove(first);
        frequencies.remove(second);
        double newValue = first + second;
        getSmallest.add(newValue);

        return getSmallest;
    }
}
