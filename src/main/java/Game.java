import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane border = new BorderPane();
        Board board = new Board();
        FlowPane grid = board.getBoard();
        border.setCenter(grid);

        Scene scene = new Scene(border, 650, 800);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
