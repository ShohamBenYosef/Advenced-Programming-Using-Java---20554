import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController{

    private String local = "127.0.0.1";
    private  Client client;

    @FXML
    private TextField textF;

    @FXML
    private Button disconnectBtn;

    @FXML
    private Button connectBtn;

    @FXML
    private Button sendBtn;

    @FXML
    private ListView<String> historyChat;

    @FXML
    void connectPressed(ActionEvent event) {
       client =  new Client(this, local);
       try {
           client.start();
       } catch (Exception e) {
           //TODO: handle exception
       }
    }

    @FXML
    void disconnectPressed(ActionEvent event) {

    }

    @FXML
    void sendPressed(ActionEvent event) {

        String msg = textF.getText();

        try {
            client.handelReadAndWrite(this, local);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void textEnter(ActionEvent event) {

    }

    public void addToHistoryChat(String line){
        historyChat.getItems().add(line);
    }

    public String getTextF(){
        return textF.getText();
    }
    public void setTextF(){
        textF.clear();
    }

}
