package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 5;
        int b = 10;
        String result = (a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(result);
    }

    private static void printColor() {
        int value = 7;
        String result;
        if (value <= 0)
            result = "Красный";
        else if (value <= 100)
            result = "Желтый";
        else
            result = "Зеленый";
        System.out.println(result);
    }

    private static void compareNumbers() {
        int a = 5;
        int b = 7;
        String result = (a >= b) ? "a>=b" : "a<b";
        System.out.println(result);
    }
}
