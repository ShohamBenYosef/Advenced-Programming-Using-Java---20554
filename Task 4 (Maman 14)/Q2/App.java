import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));

        Scene scene = new Scene(root, 580, 400);
        primaryStage.setTitle("Random Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 public static void main(String[] args) {
        launch(args);
    }
}