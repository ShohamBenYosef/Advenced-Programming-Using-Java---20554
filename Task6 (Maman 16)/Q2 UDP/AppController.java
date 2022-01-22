import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {

    private static final String HOST = "localhost";
    private static final String PATH = "C:/Java/test1/Test/src/Wh.txt";

    @FXML
    private ListView<String> list;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField textF;

    @FXML
    void sendPressed(ActionEvent event) {
        textF.clear();
        DatagramSocket clientSocket = null;
        try{
            clientSocket = new DatagramSocket();
            InetAddress iPAddress = InetAddress.getByName(HOST);
            sendToserver(clientSocket, iPAddress);
            //getFromServer(clientSocket);

        }catch(Exception e){
            e.printStackTrace();
        }


        String selectedContact = list.getSelectionModel().getSelectedItem();
        System.out.println(selectedContact);
        searchCapitalWeatherByName(selectedContact);
    }

    @FXML
    public void initialize(){
        openFileAndReadToList("Wh.txt");
    }

    public void sendToserver(DatagramSocket socket, InetAddress ip) {
        String sentence = textF.getText();
        textF.clear();

        byte[] data = new byte[1024];
        data = sentence.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, ip, 9872);


        try{
            socket.send(packet);
        }catch(IOException exception){
            exception.printStackTrace();
        }

    }




    // Logic methods.

    public void searchCapitalWeatherByName(String city) {
        try {
            Scanner scanner = new Scanner(new File("C:/Java/test1/Test/src/Wh.txt"));
            while(scanner.hasNextLine()){
                String[] temp = new String[5];
                String line = scanner.nextLine();
                System.out.println(line);
                temp = line.split(",");
                if(temp[0].equals(city)){
                    textF.setText("today "+temp[0]+"is "+temp[4]+" and "+temp[1]+" degrees\n ,tomorrow will be "+temp[2] +" And the day after tomorrow will be "+temp[3]);
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("error with files. ");
        }

    }

    public void openFileAndReadToList(String fileString) {
        try {
            Scanner scanner = new Scanner(new File(PATH));
            while(scanner.hasNext()){
                String[] temp = new String[5];
                String line = scanner.nextLine();
                temp = line.split(",");
                list.getItems().add(temp[0]);

            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("error with files.");
        }

    }

}
