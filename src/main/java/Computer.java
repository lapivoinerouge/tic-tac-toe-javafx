import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {

    public void computerMove(HashMap<Integer,Box> fullBoxes, FlowPane flow) {

        Board board = new Board();
        WinnerPicker picker = new WinnerPicker();

        Random random = new Random();
        int computerChose = random.nextInt(9);

        Set<Integer> impossibleMove = fullBoxes.entrySet().stream()
                .map(entry -> entry.getKey())
                .filter(key -> key.equals(computerChose))
                .collect(Collectors.toSet());

        if (impossibleMove.size() == 0) {
            flow.getChildren().remove(computerChose);
            flow.getChildren().add(computerChose, new ImageView(new Image(Board.class.getResourceAsStream("o.png"))));
            Box box = new Box('O', computerChose);
            fullBoxes.put(computerChose, box);
        } else if (!board.isFull()){
            computerMove(fullBoxes, flow);
        }
        new WinnerPicker().pickWinner(fullBoxes);
    }
}

