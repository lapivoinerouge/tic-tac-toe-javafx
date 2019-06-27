import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.util.HashMap;

public class User {

    public void userMove(HashMap<Integer, Box> fullBoxes, FlowPane flow, MouseEvent event) {

        if (fullBoxes.get(flow.getChildren().indexOf(event.getTarget())) == null) {
            int i = flow.getChildren().indexOf(event.getTarget());
            flow.getChildren().add(i, new ImageView(new Image(Board.class.getResourceAsStream("x.png"))));
            flow.getChildren().remove(event.getTarget());
            Box box = new Box('X', i);
            fullBoxes.put(i, box);
            new WinnerPicker().pickWinner(fullBoxes);
        }
    }
}
