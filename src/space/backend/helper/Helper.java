package space.backend.helper;

import space.backend.compression.file.FileCompression;
import space.backend.decompression.file.FileDecompression;

import java.io.*;

public class Helper {

    static void FileDataGetter(String filename, boolean isCompressed){
        File file = new File(filename);

        try{
            BufferedReader readIn = new BufferedReader(new FileReader(file));
            String valueFile;
            try{
                String endValue = "";
                while((valueFile = readIn.readLine()) != null)
                    endValue += valueFile;

                if(isCompressed){
                    FileDecompression.Decompression(endValue);
                }
                else{
                    FileCompression.Compression(endValue);
                }
            }
            catch(IOException io){
                System.out.println(io);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    static void FileDataWriter(String filename, boolean isNew, String endData) {
        File file;

        if (isNew) {
            file = new File("/" + filename + ".spce");
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(endData);
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else if(filename.endsWith(".txt")) {
            file = new File("/" + filename + "-compressed.spce");
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(endData);
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static void CheckTypes(String filename){
        boolean isCompressed = false;

        if(filename.endsWith(".txt")){
            FileDataGetter(filename, isCompressed);
        }
        else{
            System.exit(1);
        }
    }

    static void isSpaceFile(String filename){
        boolean isCompressed = true;

        if(filename.endsWith(".spce")){
            FileDataGetter(filename, isCompressed);
        }
        else{
            System.exit(1);
        }
    }
}

