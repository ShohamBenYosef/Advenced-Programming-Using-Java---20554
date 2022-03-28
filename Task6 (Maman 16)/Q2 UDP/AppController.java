import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController extends Thread{

    @FXML
    private ListView<String> list;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField textF;

    @FXML
    void sendPressed(ActionEvent event) {
        DatagramSocket clientSocket = null;

        try {
            clientSocket = new DatagramSocket();
            InetAddress iPAddress = InetAddress.getByName("127.0.0.1"); // localhost

            sendToServer(clientSocket, iPAddress);
            getFromServer(clientSocket);

            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        setCitiesOnList();
    }




    // Send String of chosen city to server
    public void sendToServer(DatagramSocket socket, InetAddress ip){

        String sentence = list.getSelectionModel().getSelectedItem();

        byte[] data = new byte[1024];
        data = sentence.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, ip, 9876);

        try {
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // receive String of weathe from Server
    public void getFromServer(DatagramSocket socket) {
        byte[] receiveData = new byte[1024];
        DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);

        try {
            socket.receive(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        receiveData = packet.getData();
        int len = packet.getLength();
        String modifiedSentence = new String((receiveData)).substring(0,len);
        // set it on javaFx text object
        textF.setText(modifiedSentence);
    }

    // Set Cities in list to user to choose from.
    public void setCitiesOnList(){
        try {
            Scanner scanner = new Scanner(new File("Cities.txt"));
            while(scanner.hasNext()){
                String line = scanner.nextLine();

                list.getItems().add(line);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
