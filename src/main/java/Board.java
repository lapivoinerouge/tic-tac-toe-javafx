import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.awt.event.MouseListener;
import java.util.*;


public class Board {

    private ImageView boxes[] = new ImageView[9];
    private HashMap<Integer, Box> fullBoxes = new HashMap<>();

    private User user = new User();
    private Computer computer = new Computer();

    public FlowPane getBoard() {

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(50, 0, 0, 30));
        flow.setVgap(0);
        flow.setHgap(0);
        flow.setPrefWrapLength(255);
        flow.setStyle("-fx-background-color: DAE6F3");

        for (int i = 0; i < 9; i++) {
            boxes[i] = new ImageView(new Image(Board.class.getResourceAsStream("blank.png")));
            flow.getChildren().add(boxes[i]);
        }

        flow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                user.userMove(fullBoxes, flow, event);
                if (!isFull()) {
                    computer.computerMove(fullBoxes, flow);
                }
            }
        });

        return flow;
    }

    public boolean isFull() {
        if(fullBoxes.size() == 9) {
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }

}