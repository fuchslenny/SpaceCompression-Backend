package space.backend.main;

import space.backend.compression.file.FileCompression;
import space.backend.helper.Helper;
import java.util.Scanner;

public class Main {
    private static String fileValue = "Es verlangt sehr viel Tapferkeit, sich seinen Feinden " +
            "in den Weg zu stellen, aber wesentlich mehr noch, sich seinen Freunden in den Weg zu stellen. " +
            "Wenn du wissen willst, wie ein Mensch ist, dann sieh dir genau an wie er seine Untergebenen " +
            "behandelt, nicht die Gleichrangigen." +
            "Glück und Zuversicht vermag man selbst in Zeiten der Dunkelheit zu finden. Man darf bloß nicht" +
            "vergessen ein Licht leuchten zu lassen. Die Stimme eines Kindes, egal wie ehrlich oder aufrichtig, " +
            "ist bedeutungslos für jene, die verlernt haben zuzuhören." +
            "Du bist der, der schwach ist. Du wirst nie wissen, was Liebe ist. Oder Freundschaft. Und deswegen " +
            "kannst du mir nur Leid tun!";

    public static void main(String args[]){
        Scanner getInput = new Scanner(System.in);
        String filepath = getInput.nextLine();
        //just for the beginning getting into the test
        if(filepath != ""){
            //Helper.CheckTypes(filepath);
            FileCompression.Compression(fileValue);
        }
        else{
            System.out.println("Now using the tcp client");
            Helper.TCPFileGetter();
        }
    }
}
