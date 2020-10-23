package space.backend.helper;

import java.io.*;

public class TCP {

    public static void TCPFileGetter(){
        TCP server = new TCP();
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
        return serverSocket.accept();
    }

    String readMessage(java.net.Socket socket) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] buffer = new char[200];
        int sizeMessage = bufferedReader.read(buffer, 0, 200);
        return new String(buffer, 0, sizeMessage);
    }

    void sendMessage(java.net.Socket socket, String message) throws IOException{
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.print(message);
        printWriter.flush();
    }
}
