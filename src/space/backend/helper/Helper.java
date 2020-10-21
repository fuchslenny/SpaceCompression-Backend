package space.backend.helper;

import space.backend.file.compression.FileCompression;

import java.io.*;

public class Helper {
    //TODO erstmal nur provisorisch --> überarbeiteung des TCP Data Getters
    public static void TCPFileGetter(){
        Helper server = new Helper();
        try{
            server.test();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    void test() throws IOException{
        int port = 1111;
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
        java.net.Socket client = waitFor(serverSocket);
        String message = readMessage(client);
        sendMessage(client, message);
    }

    java.net.Socket waitFor(java.net.ServerSocket serverSocket) throws IOException{
        java.net.Socket socket = serverSocket.accept();
        return socket;
    }

    String readMessage(java.net.Socket socket) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] buffer = new char[200];
        int sizeMessage = bufferedReader.read(buffer, 0, 200);
        String message = new String(buffer, 0, sizeMessage);
        return message;
    }

    void sendMessage(java.net.Socket socket, String message) throws IOException{
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.print(message);
        printWriter.flush();
    }

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

