package space.backend.helper;

import space.backend.filecompression.FileCompression;

import java.io.*;

public class Helper {
    public static void FileDataGetter(String filename){
        File file = new File(filename);

        try{
            BufferedReader readIn = new BufferedReader(new FileReader(file));
            String valueFile;
            try{
                String endValue = null;
                while((valueFile = readIn.readLine()) != null)
                    endValue = endValue + valueFile;

                FileCompression.Compression(endValue);
            }
            catch(IOException io){
                System.out.println(io);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    public static void CheckTypes(String filename){
        filename = filename.strip();

        if(filename.endsWith(".txt")){
            FileDataGetter(filename);
        }
    }
}

