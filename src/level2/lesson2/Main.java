package level2.lesson2;

import level2.lesson2.ex.MyArrayDataException;
import level2.lesson2.ex.MyArraySizeException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "11"},
                {"13", "14", "15", "16"}
        };

        try {
            int[][] intArray = toIntArray(array);
            for (int[] el : intArray) {
                System.out.println(Arrays.toString(el));
            }
        } catch (MyArrayDataException | MyArraySizeException ex) {
            for (String[] el : array) {
                System.out.println(Arrays.toString(el));
            }
            System.out.println();
            System.out.println(ex.getMessage());
        }
    }


    private static int[][] toIntArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (!checkValidSize(array)) {
            throw new MyArraySizeException();
        }

        int[][] intArray = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                intArray[i][j] = toIntValue(array[i][j], i , j);
            }
        }

        return intArray;
    }

    private static int toIntValue(String value, int i, int j) {
        if (!value.matches("\\d+")) {
            throw new MyArrayDataException(++i, ++j);
        }
        return Integer.parseInt(value);
    }

    private static boolean checkValidSize(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            return false;
        }

        for (String[] el : array) {
            if (el.length != 4) {
                return false;
            }
        }
        return true;
    }
}
