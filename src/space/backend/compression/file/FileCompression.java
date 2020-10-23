package space.backend.compression.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCompression {

    public static void Compression(String fileValue) {
        ArrayList<String> wordList = Sort(fileValue);
        ArrayList<Double> frequencies = new ArrayList<Double>();

        for(int i = 0; i<wordList.size(); i++){
            frequencies = relativeFrequency(wordList, i);
        }

        for (double f : frequencies) {
            System.out.println(f + "\n--------------------------");
        }

    }

    private static ArrayList<String> Sort(String fileValue){
        String buffer = "";
        String characterBuffer = "";
        ArrayList<String> wordList = new ArrayList<String>();

        for (int i = 0; i < fileValue.length(); i++) {
            char currentChar = fileValue.charAt(i);

            if (!" ".equals(String.valueOf(currentChar)) || !",".equals(String.valueOf(currentChar)) || !".".equals(String.valueOf(currentChar))) {
                buffer = buffer + currentChar;
            }
            //TODO
            else if (".".equals(String.valueOf(currentChar)) || ",".equals(String.valueOf(currentChar))) {
                characterBuffer = characterBuffer + currentChar;
                wordList.add(buffer);
            }
        }
        return wordList;
    }

    private static ArrayList<Double> relativeFrequency(ArrayList<String> wordList, int i){
        String buffer = wordList.get(i);
        float letterFrequency = 0;
        HashMap<Character, Integer> charCountMap = characterCount(buffer);
        ArrayList<Double> frequencies = new ArrayList<Double>();

        for(Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String value = entry.getValue().toString();
            int intValue = Integer.parseInt(value);
            letterFrequency = intValue / buffer.length();
            frequencies.add((double) letterFrequency);
        }
        return frequencies;
    }

    private static HashMap characterCount(String buffer){
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
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
}
