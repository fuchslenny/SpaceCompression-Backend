package space.backend.helper;

import space.backend.compression.file.FileCompression;

import java.io.*;

public class Helper {

    public static void FileDataGetter(String filename){
        File file = new File(filename);

        try{
            BufferedReader readIn = new BufferedReader(new FileReader(file));
            String valueFile;
            try{
                String endValue = "";
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

    public static void FileDataWriter(String filename, boolean isNew, String endData){
        if(isNew){
            File file = new File("/" + filename + ".spce");
            try{
                FileWriter writer = new FileWriter(file);
                writer.write(endData);
                writer.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
        else {
            File file = new File("/" + filename + "-compressed.spce");
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(endData);
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void CheckTypes(String filename){
        if(filename.endsWith(".txt")){
            FileDataGetter(filename);
        }
    }
}

