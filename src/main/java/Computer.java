import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {


    public int computerMove(HashMap<Integer, Box> fullBoxes) {

        Board board = new Board();
        Random random = new Random();
        int computerBox = random.nextInt(9);

        Set<Integer> impossibleMove = fullBoxes.entrySet().stream()
                .map(entry -> entry.getKey())
                .filter(key -> key.equals(computerBox))
                .collect(Collectors.toSet());

        if (impossibleMove.size() != 0) {
            computerMove(fullBoxes);
        } return computerBox;
    }
}

