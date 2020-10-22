package space.backend.helper;

import space.backend.compression.file.FileCompression;
import space.backend.helper.Helper;
import java.util.Scanner;
import java.util.Scanner;

public class Threads extends Thread {
    String name;

    public Threads(String threadName){
        this.name = threadName;
    }

    public void run(){

        try{
            Scanner getInput = new Scanner(System.in);
            String filepath = getInput.nextLine();
            //just for the beginning getting into the test
            if(filepath != "" || filepath != null){
                Helper.CheckTypes(filepath);
            }
            else{
                System.out.println("Now using the tcp client");
                Helper.TCPFileGetter();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
