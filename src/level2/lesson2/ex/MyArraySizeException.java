package level2.lesson2.ex;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Не вверный размер массива. Массив должен быть 4x4");
    }

}
