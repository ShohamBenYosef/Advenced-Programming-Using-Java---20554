import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{

    private ArrayList<ServerThread> contactList = new ArrayList<>();
    private final int serverPort;

    public Server(int serverPort){
        this.serverPort = serverPort;
        System.out.println("Server is up");
    }

    public List<ServerThread> getThreadList(){
        return contactList;
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while(true){
                Socket clientSocket = serverSocket.accept();

                ServerThread user = new ServerThread(this, clientSocket, contactList);
                contactList.add(user);
                user.start();
                // maybe change location and declare it before.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
