package lesson3;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        task1(1, 0, 1, 1, 1, 0);
        task2(new int[100]);
        task3(1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1);
        task4(5);

        int[] array = task5(10, 50);
        System.out.println(Arrays.toString(array));

        task6();
        System.out.println(task7(2, 2, 2, 1, 2, 2, 10, 1));
        task8(2, 1, 2, 3, 4, 5);
    }

    // Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1,0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void task1(int... array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }

        System.out.println(Arrays.toString(array));
    }

    //Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
    //значениями 1 2 3 4 5 6 7 8 ... 100;
    private static void task2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void task3(int... array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
        }
        System.out.println(Arrays.toString(array));
    }

    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    //(можно только одну из диагоналей, если обе сложно). Определить элементы одной из
    //диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
    //[1][1], [2][2], ..., [n][n];
    private static void task4(int n) {
        int[][] array = new int[n][n];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i == j ? 1 : (i + j == array[i].length - 1 ? 1 : 0);
            }
        }

        System.out.println(Arrays.deepToString(array));
    }

    //Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
    private static int[] task5(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    // * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    private static void task6() {
        int[] array = {100, 2, 4234, 5, -6, 7, 34, 324};
        Arrays.sort(array);
        int min = array[0];
        int max = array[array.length - 1];
        System.out.printf("Min value = %d and Max value = %d\n", min, max);
    }

    // Задача №7 (Нахождение баланса сумм правой и левой стороны массива)
    private static boolean task7(int... array) {
        boolean isBalance = false;

        for (int index = 0; index < array.length; index++) {
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < index; i++) {
                sum1 += array[i];
            }
            for (int i = index; i < array.length; i++) {
                sum2 += array[i];
            }
            if (sum1 == sum2) {
                isBalance = true;
                break;
            }
        }

        return isBalance;
    }

    // Задача №8 - со смещением элементов массива на n;
    private static void task8(int n, int... array) {

        if (n >= 0) {
            for (int j = 0; j < array.length - n; j++) {
                for (int i = 0; i < array.length - 1; i++) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        } else {
            n = -n;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < array.length - 1; i++) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

}
