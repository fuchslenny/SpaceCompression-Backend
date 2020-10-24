package space.backend.helper;

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

            if(filepath.isEmpty()){
                filepath = "harry_potter.txt";
                Helper.CheckTypes(filepath);
            }
            else{
                System.out.println("Now using the tcp client");
                TCP.TCPFileGetter();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
