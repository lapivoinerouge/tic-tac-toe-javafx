import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane border = new BorderPane();
        Board board = new Board();
        FlowPane grid = board.getBoard();
        border.setCenter(grid);



//        grid.getChildren().forEach(ImageView -> ImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                event.getTarget().
//        }}));
//

//                .setOnMouseClicked(
//                new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                grid.getChildren().remove(event.getTarget());
//            }
//        });


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
