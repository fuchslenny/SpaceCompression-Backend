package space.backend.main;

import space.backend.helper.Helper;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner getInput = new Scanner(System.in);
        String filepath = getInput.nextLine();
        //just for the beginning getting into the test
        if(filepath != ""){
            Helper.CheckTypes(filepath);
        }
        else{
            Helper.TCPFileGetter();
        }
    }
}
