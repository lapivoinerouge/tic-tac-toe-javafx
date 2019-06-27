import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinnerPicker {

    public void pickWinner(HashMap<Integer,Box> fullBoxes) {

        //give values for column and row
        for (Map.Entry<Integer, Box> entry : fullBoxes.entrySet()) {
            Integer boxIndex = entry.getKey();

            int column = 0;
            int row = 0;

            switch (boxIndex) {
                case 0:
                    column = 1;
                    row = 1;
                    break;
                case 1:
                    column = 2;
                    row = 1;
                    break;
                case 2:
                    column = 3;
                    row = 1;
                    break;
                case 3:
                    column = 1;
                    row = 2;
                    break;
                case 4:
                    column = 2;
                    row = 2;
                    break;
                case 5:
                    column = 3;
                    row = 2;
                    break;
                case 6:
                    column = 1;
                    row = 3;
                    break;
                case 7:
                    column = 2;
                    row = 3;
                    break;
                case 8:
                    column = 3;
                    row = 3;
                    break;
            }

            entry.getValue().setColumn(column);
            entry.getValue().setRow(row);
        }

        //check lines for column
        long columnsX = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'X')
                .map(box -> box.getColumn())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .map(e -> e.getKey())
                .count();

        long columnsO = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'O')
                .map(box -> box.getColumn())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .map(e -> e.getKey())
                .count();

        //check lines for rows
        long rowsX = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'X')
                .map(box -> box.getRow())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .map(e -> e.getKey())
                .count();

        long rowsO = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'O')
                .map(box -> box.getRow())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .map(e -> e.getKey())
                .count();

        if (columnsX > 0|| rowsX > 0) {
            System.out.println("Player X wins!");
        } else if (columnsO > 0 || rowsO > 0) {
            System.out.println("Player O wins!");
        }

        //check lines for diagonals
        Set<Integer> diagonalX = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box ->box.getToken() == 'X')
                .map(box -> box.getPosition())
                .collect(Collectors.toSet());

        if(diagonalX.contains(4)) {
            if(diagonalX.contains(0)) {
                if(diagonalX.contains(8)) {
                    System.out.println("Player X wins diago");
                }
            } else if(diagonalX.contains(2)) {
                if(diagonalX.contains(6)) {
                    System.out.println("Player X wins diago");
                }
            }
        }

        Set<Integer> diagonalO = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box ->box.getToken() == 'X')
                .map(box -> box.getPosition())
                .collect(Collectors.toSet());

        if(diagonalO.contains(4)) {
            if(diagonalO.contains(0)) {
                if(diagonalO.contains(8)) {
                    System.out.println("Player O wins diago");
                }
            } else if(diagonalO.contains(2)) {
                if(diagonalO.contains(6)) {
                    System.out.println("Player O wins diago");
                }
            }
        }
    }
}
