import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpThread extends Thread{

    private Socket socket = null;
    PrintWriter out;
    BufferedReader in;

    public TcpThread(Socket socket){
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e){
            System.out.println("Couldn't open io on connection");
        }
    }

    @Override
    public void run() {
        super.run();



        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null){
                out.println(inputLine);
            }
            out.close();
            in.close();
            socket.close();
        } catch (IOException e){
            System.out.println("Couldn't open io on connection");
        }

    }
}
