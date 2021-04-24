package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    private static final int COUNTER_WIN_CHIPS = 4;         // кол-во фишек для победы
    private static final int SIZE = 10;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final char[][] map = new char[SIZE][SIZE];
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("Человек выиграл");
                printMap();
                break;
            }
            aiTurn();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер выиграл");
                printMap();
                break;
            }
            printMap();
        }
    }

    private static boolean checkWin(char win) {

        for (int i = 0; i < SIZE; i++) {
            int counterX = 0;       // счетичк по X
            int counterY = 0;       // счетчик по Y
            int counterLeftRight = 0;      // счетик по диагонали слева направо
            int counterRightLeft = 0;      // счетик по диагонали справа налево
            for (int j = 0; j < SIZE; j++) {
                // Подсчитываем кол-во по X
                if (map[i][j] == win) {
                    counterX++;
                    if (counterX == COUNTER_WIN_CHIPS) {
                        return true;
                    }
                }
                // Подсчитываем кол-во по Y
                if (map[j][i] == win) {
                    counterY++;
                    if (counterY == COUNTER_WIN_CHIPS) {
                        return true;
                    }
                }
                // Подсчитываем кол-во по диагонали
                if (map[i][j] == win) {
                    for (int k = 0; k < COUNTER_WIN_CHIPS; k++) {
                        // Слева на право
                        if (i + k < SIZE && j + k < SIZE && map[i + k][j + k] == win) {
                            counterLeftRight++;
                            if (counterLeftRight == COUNTER_WIN_CHIPS) {
                                return true;
                            }
                        }
                        // Справо на лево
                        if (i + k < SIZE && j - k >= 0 && map[i + k][j - k] == win) {
                            counterRightLeft++;
                            if (counterRightLeft == COUNTER_WIN_CHIPS) {
                                return true;
                            }
                        }
                    }
                }

            }
        }


        return false;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (map[x][y] != DOT_EMPTY);
        map[x][y] = DOT_O;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X и Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;

    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        else return map[x][y] == DOT_EMPTY;
    }

    private static void initMap() {
        for (char[] el : map) {
            Arrays.fill(el, DOT_EMPTY);
        }
    }

    private static void printMap() {
        printHeader();
        printBody();
        System.out.println();
    }

    private static void printBody() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE + 1; j++) {
                if (j == 0) {
                    System.out.print(i + 1 + "\t");             // табуляция для того,чтобы сетка не съежала при SIZE >= 10
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
