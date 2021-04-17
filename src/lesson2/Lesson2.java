package lesson2;

public class Lesson2 {

    public static void main(String[] args) {

        // Код для проверки методов
        System.out.println(isSumFrom10To20(5, 6));
        checkToPositive(5);
        System.out.println(isNegative(5));
        multiplyPrint("hello", 4);
        System.out.println(isLeapYear(2024));

    }

    private static boolean isSumFrom10To20(int a, int b) {
        return ((a + b >= 10) && (a + b <= 20));
    }

    private static void checkToPositive(int a) {
        String isPositive = (a >= 0) ? "Число положительное" : "Число отрицательное";
        System.out.println(isPositive);
    }

    private static boolean isNegative(int a) {
        return (a < 0) ? true : false;
    }

    private static void multiplyPrint(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else return year % 4 == 0;
    }

}
