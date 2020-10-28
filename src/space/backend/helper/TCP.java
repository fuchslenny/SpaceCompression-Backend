/**
 * @author fuchslenny
 */

package space.backend.helper;

import java.io.*;

public class TCP {

    private static java.net.Socket client;

    public static void TCPFileGetter(){
        TCP server = new TCP();
        try{
            server.Handler();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void Handler() throws IOException{
        int port = 25102;
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
        client = waitFor(serverSocket);
        byte[] fileContent = ReadMessage(client);
        Helper.ParseContent(fileContent);
    }

    private static java.net.Socket waitFor(java.net.ServerSocket serverSocket) throws IOException{
        return serverSocket.accept();
    }

    private static byte[] ReadMessage(java.net.Socket socket) throws IOException{
        byte[] buffer = new byte[200];
        InputStream stream = socket.getInputStream();
        int count = stream.read(buffer);

        return buffer;
    }

    private static void SendMessage(java.net.Socket socket, byte[] fileContent) throws IOException{
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.print(fileContent);
        printWriter.flush();
    }

    public static void Message(byte[] compressedFileContent) throws IOException {
        SendMessage(client, compressedFileContent);
    }
}
