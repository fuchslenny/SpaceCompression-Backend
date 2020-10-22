package space.backend.compression.file;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCompression {

    private String fileValue = "Es verlangt sehr viel Tapferkeit, sich seinen Feinden " +
            "in den Weg zu stellen, aber wesentlich mehr noch, sich seinen Freunden in den Weg zu stellen. " +
            "Wenn du wissen willst, wie ein Mensch ist, dann sieh dir genau an wie er seine Untergebenen " +
            "behandelt, nicht die Gleichrangigen." +
            "Glück und Zuversicht vermag man selbst in Zeiten der Dunkelheit zu finden. Man darf bloß nicht" +
            "vergessen ein Licht leuchten zu lassen. Die Stimme eines Kindes, egal wie ehrlich oder aufrichtig, " +
            "ist bedeutungslos für jene, die verlernt haben zuzuhören." +
            "Du bist der, der schwach ist. Du wirst nie wissen, was Liebe ist. Oder Freundschaft. Und deswegen " +
            "kannst du mir nur Leid tun!";

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
                if(buffer.length() != 0 && doubles.size() != 0 && buffer != null || doubles != null){
                    boolean contain = doubles.contains(buffer);

                }
                characterBuffer = characterBuffer + currentChar;

                doubles.add(buffer);
            }
            else {
                continue; //TODO
            }
        }
        float letterFrequency = relativeFrequency(buffer);
    }

    private static float relativeFrequency(String buffer){
        float letterFrequency = 0;

        HashMap<Character, Integer> charCountMap = characterCount(buffer);

        for(Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return letterFrequency;
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
