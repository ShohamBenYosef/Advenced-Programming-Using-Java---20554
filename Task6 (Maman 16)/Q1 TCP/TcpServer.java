import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        boolean listen = true;

        try{
            serverSocket = new ServerSocket(7777);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server ready");
        Socket socket = null;
        while (listen){
            try {
                socket = serverSocket.accept();
                new TcpThread(socket).start();
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Accept failed");
                System.exit(1);
            }
        }

        serverSocket.close();
    }

}