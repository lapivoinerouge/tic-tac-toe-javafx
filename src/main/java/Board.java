import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Board {

    private ImageView boxes[] = new ImageView[9];
    private HashMap<Integer, Box> fullBoxes = new HashMap<>();

    public FlowPane getBoard() {

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(50, 0, 0, 30));
        flow.setVgap(0);
        flow.setHgap(0);
        flow.setPrefWrapLength(255);
        flow.setStyle("-fx-background-color: DAE6F3");

        for(int i = 0; i<9;i++) {
            boxes[i] = new ImageView(new Image(Board.class.getResourceAsStream("blank.png")));
            flow.getChildren().add(boxes[i]);
        }

        flow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(fullBoxes.get(flow.getChildren().indexOf(event.getTarget())) == null) {
                        int i = flow.getChildren().indexOf(event.getTarget());
                        flow.getChildren().add(i, new ImageView(new Image(Board.class.getResourceAsStream("x.png"))));
                        flow.getChildren().remove(event.getTarget());
                        Box box = new Box('X', i);
                        fullBoxes.put(i, box);
                        System.out.println(fullBoxes.size());
                    }
                }
            });

        return flow;
    }

}