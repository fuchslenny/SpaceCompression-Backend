/**
 * @author fuchslenny
 */

package space.backend.helper;

import space.backend.compression.file.FileCompression;
import space.backend.decompression.file.FileDecompression;

import java.io.*;
import java.nio.file.Files;
import java.util.Random;

public class Helper {

    static void FileDataGetter(File file, boolean isCompressed){

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
                byte[] fileContent = Files.readAllBytes(file.toPath());
                TCP.Message(fileContent);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    static void CheckTypes(File file, String filetype){
        boolean isCompressed = false;

        if(filetype.equals(".txt")){
            FileDataGetter(file, isCompressed);
        }
        else{
            System.exit(1);
        }
    }

    static void isSpaceFile(File file, String fileType){
        boolean isCompressed = true;

        if(fileType.equals(".spce")){
            FileDataGetter(file, isCompressed);
        }
        else{
            System.exit(1);
        }
    }

    static void ParseContent(byte[] fileContent){
        //TODO
        String fileType = ".txt";
        MakeFile(fileContent, fileType);
    }

    static File MakeFile(byte[] fileContent, String fileType){

        String name = GenName();

        try (FileOutputStream outputStream = new FileOutputStream(name)) {
            outputStream.write(fileContent);
        }catch(Exception e){
            System.out.println(e);
        }
        File file = new File(name);
        Helper.CheckTypes(file, fileType);

        return file;
    }

    static String GenName(){
        int len = 10;
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random random = new Random();
        StringBuilder name = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            name.append(chars.charAt(random.nextInt(chars.length())));

        return name.toString();
    }
}

