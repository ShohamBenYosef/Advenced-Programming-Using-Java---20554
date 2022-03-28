
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread {

    private AppController appController;
    private String ip;
    private final int port = 8818;
    private Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    BufferedReader reader;




    public Client(AppController appController, String ip){
        this.appController = appController;
        this.ip = ip;

    }


    @Override
    public void run() {
        super.run();

        try {
            socket = new Socket(ip, port);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handelReadAndWrite(AppController appController, String ip) throws Exception{

                String msg1 = appController.getTextF();
                outputStream.write(msg1.getBytes());
                appController.addToHistoryChat("You: " + msg1);
                appController.setTextF();


        //}
        reader.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        }
}
