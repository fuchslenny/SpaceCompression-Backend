package space.backend.compression.file;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCompression {

    public static void Compression(String fileValue){
        String buffer = "";
        String characterBuffer = "";
        List<String> doubles = null;

        for(int i = 0; i<fileValue.length(); i++){
            char currentChar = fileValue.charAt(i);


            if(!" ".equals(currentChar) || !",".equals(currentChar) || !".".equals(currentChar)){
                buffer = buffer + currentChar;

            }
            else if(".".equals(currentChar) || ",".equals(currentChar)){
                /*if(buffer.length() != 0 && doubles.size() != 0 && buffer != null || doubles != null){
                    boolean contain = doubles.contains(buffer);

                }*/
                characterBuffer = characterBuffer + currentChar;

                //doubles.add(buffer);
            }
            else {
                continue; //TODO
            }
        }
        List<Float> letterFrequencies = relativeFrequency(buffer);
        for(float f : letterFrequencies){
            System.out.println(f);
        }
    }

    private static List relativeFrequency(String buffer){
        float letterFrequency = 0;
        HashMap<Character, Integer> charCountMap = characterCount(buffer);
        ArrayList<Float> frequencies = new ArrayList<Float>();

        for(Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String value = entry.getValue().toString();
            int intValue = Integer.parseInt(value);
            letterFrequency = intValue / buffer.length();
            frequencies.add(letterFrequency);
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
