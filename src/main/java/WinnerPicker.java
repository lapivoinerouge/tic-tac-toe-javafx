import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
        Set<Integer> columnsX = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'X')
                .map(box -> box.getColumn())
                .collect(Collectors.toSet());

        Set<Integer> columnsO = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'O')
                .map(box -> box.getColumn())
                .collect(Collectors.toSet());


        //check lines for rows
        Set<Integer> rowsX = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'X')
                .map(box -> box.getRow())
                .collect(Collectors.toSet());

        Set<Integer> rowsO = fullBoxes.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(box -> box.getToken() == 'O')
                .map(box -> box.getRow())
                .collect(Collectors.toSet());


//        //check lines for diagonals
//        Set<Integer> diagonalX = fullBoxes.entrySet().stream()
//                .filter(entry -> entry.getValue().getToken() == 'X')
//                .map(entry -> entry.getKey())
//                .collect(Collectors.toSet());
//
//
//
//        Set<Integer> diagonalO = fullBoxes.entrySet().stream()
//                .filter(entry -> entry.getValue().getToken() == 'O')
//                .map(entry -> entry.getKey())
//                .collect(Collectors.toSet());


        System.out.println(columnsX);
        System.out.println(columnsO);

        if (columnsX.size() == 3 || rowsX.size() == 3) {
            System.out.println("Player X wins!");
        } else if (columnsO.size() == 3 || rowsO.size() == 3) {
            System.out.println("Player O wins!");

        }
    }

}
