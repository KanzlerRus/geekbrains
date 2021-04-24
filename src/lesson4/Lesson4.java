package lesson4;

import java.util.Arrays;

public class Lesson4 {
    private static final int SIZE = 3;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final char[][] map = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initMap();
        printMap();
    }

    private static void initMap() {
        for(char[] el : map){
            Arrays.fill(el,DOT_EMPTY);
        }
    }

    private static void printMap() {
        printHeader();
        printBody();
    }

    private static void printBody() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE + 1; j++) {
                if (j == 0) {
                    System.out.print(i + 1 + "\t");
                } else {
                    System.out.print(map[i][j - 1] + "\t");
                }
            }
            System.out.println();
        }
    }

    private static void printHeader() {
        for (int i = 0; i < SIZE + 1; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
