package space.backend.compression.file;

import java.util.List;

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
            else{
                continue; //TODO
            }

        }
    }
}
