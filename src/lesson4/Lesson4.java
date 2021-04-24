package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    private static final int COUNTER_WIN_CHIPS = 4;                 // кол-во фишек для победы
    private static final int SIZE = 10;                             // размер поля
    private static final char DOT_X = 'X';                          // фишки человека
    private static final char DOT_O = 'O';                          // фишки копьютера
    private static final char DOT_EMPTY = '•';                      // пустое поле
    private static final char[][] map = new char[SIZE][SIZE];       // размер поля
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWinGame(DOT_X)) {
                System.out.println("Человек выиграл");
                printMap();
                break;
            }
            aiTurn();
            if (checkWinGame(DOT_O)) {
                System.out.println("Компьютер выиграл");
                printMap();
                break;
            }
            printMap();
        }
    }

    private static boolean checkWinGame(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol && checkWin(i,j,symbol)) {
                    return true;
                }
            }
        }

        return false;
    }

    // проверка на победу по X и Y и диагонали
    private static boolean checkWin(int i, int j, char symbol) {
        return checkWinX(i, j, symbol) ||
                checkWinY(i, j, symbol) ||
                checkWinXYLeftRight(i, j, symbol) ||
                checkWinXYRightLeft(i, j, symbol);
    }

    // проверка на победу по диагонали c права на лево
    private static boolean checkWinXYRightLeft(int x, int y, char symbol) {
        int counter = 0;
        for (int i = 0; i < COUNTER_WIN_CHIPS; i++) {
            if (x + i < SIZE && y - i >= 0 && map[x + i][y - i] == symbol) {
                counter++;
                if (counter == COUNTER_WIN_CHIPS) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    // проверка на победу по диагонали слева на право
    private static boolean checkWinXYLeftRight(int x, int y, char symbol) {
        int counter = 0;
        for (int i = 0; i < COUNTER_WIN_CHIPS; i++) {
            if (x + i < SIZE && y + i < SIZE && map[x + i][y + i] == symbol) {
                counter++;
                if (counter == COUNTER_WIN_CHIPS) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    // проверка на победу по Y
    private static boolean checkWinY(int x, int y, char symbol) {
        int counter = 0;
        for (int i = 0; i < COUNTER_WIN_CHIPS; i++) {
            if (x + i < SIZE && map[x + i][y] == symbol) {
                counter++;
                if (counter == COUNTER_WIN_CHIPS) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    // проверка на победу по X
    private static boolean checkWinX(int x, int y, char symbol) {
        int counter = 0;
        for (int i = 0; i < COUNTER_WIN_CHIPS; i++) {
            if (y + i < SIZE && map[x][y + i] == symbol) {
                counter++;
                if (counter == COUNTER_WIN_CHIPS) {
                    return true;
                }
            } else {
                counter = 0;
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
