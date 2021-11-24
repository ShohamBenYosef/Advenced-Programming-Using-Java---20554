import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MyProjectController
{

    @FXML
    private Button btn;

    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = canv.getGraphicsContext2D();
    }

    @FXML
    void btnPressed(ActionEvent event) {

            final int max = 100, min = 1, N = 10;
            Random r = new Random();
            gc.clearRect(0, 0, canv.getWidth(), canv.getHeight()); // clear canvas.
            // oval.
            for(int i =0; i<N; i++){
                gc.setFill(new Color(r.nextFloat(),r.nextFloat(),r.nextFloat(),r.nextFloat()));
                gc.fillOval(r.nextInt(300), r.nextInt(300), r.nextInt(max - min) + min, r.nextInt(max - min) + min);
            }
            // rect and lines.
            for(int i =0; i<N; i++){
                gc.setFill(new Color(r.nextFloat(),r.nextFloat(),r.nextFloat(),r.nextFloat()));
                gc.fillRect(r.nextInt(300), r.nextInt(300), r.nextInt(max - min) + min, r.nextInt(max - min) + min);
            }
    }


}
