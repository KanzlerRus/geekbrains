package lesson4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    private static final File file = new File("src/lesson4/save.txt");      // файл с сохранением игры

    public static void main(String[] args) {
        initMap();
        greeting();
        printMap();
        while (true) {
            humanTurn();
            if (checkWinGame(DOT_X)) {
                System.out.println("===============");
                System.out.println("Человек выиграл");
                System.out.println("===============");
                printMap();
                break;
            }
            aiTurn();
            if (checkWinGame(DOT_O)) {
                System.out.println("=================");
                System.out.println("Компьютер выиграл");
                System.out.println("=================");
                printMap();
                break;
            }
            printMap();
        }
    }

    private static void saveGame(){
        try(PrintWriter printWriter = new PrintWriter(file)){
            for(char[] array : map) {
                for (char el : array) {
                    printWriter.print(el + " ");
                }
                printWriter.println();
            }
        }catch (FileNotFoundException ex) {
            System.err.println("Произошла ошибка!Не возможно сохранить в файл");
        }
        System.out.println("==============");
        System.out.println("Игра сохранена");
        System.out.println("==============");
    }

    private static void loadGame(){
        try(Scanner scFile = new Scanner(file)){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = scFile.next().charAt(0);
                }
            }
        }catch (FileNotFoundException ex) {
            System.err.println("Файл не возможно сохранить");
        }
        printMap();
    }

    private static void greeting() {
        System.out.println("=========================================================");
        System.out.println("Программа так же поддерживает сохранение партии в файл txt\n" +
                "и загрузку сохранения из файла. Для того,чтобы сохраниять \n" +
                "партию введите в консоль save для загрузки партии из файла txt\n" +
                " введитев консоль load");
        System.out.println("=========================================================");
    }

    private static boolean checkWinGame(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol && checkWin(i, j, symbol)) {
                    return true;
                }
            }
        }
        return false;
    }

    // проверка на победу по X и Y и диагонали
    private static boolean checkWin(int i, int j, char symbol) {
        return checkWinX(i, j, symbol, COUNTER_WIN_CHIPS) ||
                checkWinY(i, j, symbol, COUNTER_WIN_CHIPS) ||
                checkWinXYLeftRight(i, j, symbol, COUNTER_WIN_CHIPS) ||
                checkWinXYRightLeft(i, j, symbol, COUNTER_WIN_CHIPS);
    }

    // проверка на победу по диагонали c права на лево
    private static boolean checkWinXYRightLeft(int x, int y, char symbol, int number) {
        int counter = 0;
        for (int i = 0; i < number; i++) {
            if (x + i < SIZE && y - i >= 0 && map[x + i][y - i] == symbol) {
                counter++;
                if (counter == number) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    // проверка на победу по диагонали слева на право
    private static boolean checkWinXYLeftRight(int x, int y, char symbol, int number) {
        int counter = 0;
        for (int i = 0; i < number; i++) {
            if (x + i < SIZE && y + i < SIZE && map[x + i][y + i] == symbol) {
                counter++;
                if (counter == number) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    // проверка на победу по Y
    private static boolean checkWinY(int x, int y, char symbol, int number) {
        int counter = 0;
        for (int i = 0; i < number; i++) {
            if (x + i < SIZE && map[x + i][y] == symbol) {
                counter++;
                if (counter == number) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    // проверка на победу по X
    private static boolean checkWinX(int x, int y, char symbol, int number) {
        int counter = 0;
        for (int i = 0; i < number; i++) {
            if (y + i < SIZE && map[x][y + i] == symbol) {
                counter++;
                if (counter == number) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    private static void aiTurn() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // блокировка хода АИ , если уже стоят 3 DOT_X в ряд -- высший приоритет
                if (blockingTurnAi(i, j, 1)) {
                    return;
                }
                // блокировка хода АИ, если стоят только 2 DOT_X ряд -- средний приоритет
                if (blockingTurnAi(i, j, 2)) {
                    return;
                }
            }
        }

        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (map[x][y] != DOT_EMPTY);
        map[x][y] = DOT_O;
    }

    // TODO : дореализовать алгоритм,чтобы он срабатывал корректно при любом кол-ве COUNTER_WIN_CHIPS
    // блокировка хода компьютера , где number - кол-во в ряд DOT_X
    private static boolean blockingTurnAi(int i, int j, int number) {
        int zx = 0;         // дополнительный параметр корректировки для кол-ва DOT_X = 3

        if (number == 1) {
            zx = 2;
        }

        // Блокировка по X
        if (checkWinX(i, j, DOT_X, COUNTER_WIN_CHIPS - number)) {
            if (j + number + zx < SIZE && map[i][j + number + zx] == DOT_EMPTY) {
                map[i][j + number + zx] = DOT_O;
                return true;
            } else if (j - number >= 0 && map[i][j - number] == DOT_EMPTY) {
                map[i][j - number] = DOT_O;
                return true;
            }
            // блокировка по Y
        } else if (checkWinY(i, j, DOT_X, COUNTER_WIN_CHIPS - number)) {
            if (i + number + zx < SIZE && map[i + number + zx][j] == DOT_EMPTY) {
                map[i + number + zx][j] = DOT_O;
                return true;
            } else if (i - number >= 0 && map[i - number][j] == DOT_EMPTY) {
                map[i - number][j] = DOT_O;
                return true;
            }
            // блокировка по диагонали слева на право
        } else if (checkWinXYLeftRight(i, j, DOT_X, COUNTER_WIN_CHIPS - number)) {
            if (i + number + zx < SIZE && j + number + zx < SIZE && map[i + number + zx][j + number + zx] == DOT_EMPTY) {
                map[i + number + zx][j + number + zx] = DOT_O;
                return true;
            } else if (i - number >= 0 && j - number >= 0 && map[i - number][j - number] == DOT_EMPTY) {
                map[i - number][j - number] = DOT_O;
                return true;
            }
            // блокировка по диагонали справа на лево
            // TODO : исправить код
        } else if (checkWinXYRightLeft(i, j, DOT_X, COUNTER_WIN_CHIPS - number)) {
            if (i + number + zx < SIZE && j - number - zx >= 0 & map[i + number + zx][j - number - zx] == DOT_EMPTY) {
                map[i + number + zx][j - number - zx] = DOT_O;
                return true;
            } else if (i - number <= 0 && j + number < SIZE && map[i - number][j + number] == DOT_EMPTY) {
                map[i - number][j + number] = DOT_O;
                return true;
            }
        }
        return false;
    }

    private static void humanTurn() {
        int x = -1;
        int y = -1;
        do {
            System.out.println("=======================================");
            System.out.println("Введите координаты X и Y");
            System.out.println("Или введите save - для сохранения игры");
            System.out.println("Или введите load - для загрузки игры");
            System.out.println("=======================================");
            String str = scanner.nextLine();
            if (str.contains("save")) {
                saveGame();
            }else if (str.contains("load")) {
                loadGame();
            } else {
                String[] xy = str.split(" ",2);
                if(xy[0].matches("[^0-9]") || xy[1].matches("[^0-9]")) {
                    x = Integer.parseInt(xy[0]) - 1;
                    y = Integer.parseInt(xy[1]) - 1;
                } else {
                    System.out.println("=============================");
                    System.out.println("Введите корректные координаты");
                    System.out.println("=============================");
                }
            }
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
