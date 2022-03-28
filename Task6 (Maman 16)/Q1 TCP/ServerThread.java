import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{

    private Socket clientSocket;
    private Server server;
    private ServerThread secondServer;
    private OutputStream outputStream;

    public ServerThread(Server server, Socket cliSocket, ArrayList<ServerThread> contactList){
        this.server = server;
        this.clientSocket = cliSocket;
    }

    @Override
    public void run(){
        super.run();

        try {
            while(true){
                handleClientSocket();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    private void handleClientSocket() throws IOException, InterruptedException{

        InputStream inputStream = clientSocket.getInputStream();
        this.outputStream = clientSocket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        System.out.println(line);
        while(line != "")
        {
            System.out.println(line  + " From Server Thread");
            secondServer.send(line);
            //outputStream.write(line.getBytes());
        }
        clientSocket.close();
    }

    private void send(String msg) {
            try {
                secondServer.outputStream.write(msg.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
