import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AppController extends Thread {

    @FXML
    private TextField textF;

    @FXML
    private Button disconnectBtn;

    @FXML
    private Button connectBtn;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField historyChat;

    @FXML
    void connectPressed(ActionEvent event) {

    }

    @FXML
    void disconnectPressed(ActionEvent event) {

    }

    @FXML
    void sendPressed(ActionEvent event) {

    }

    @FXML
    void textEnter(ActionEvent event) {

    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }
}
