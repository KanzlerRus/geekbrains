package level2.lesson2.ex;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(int row, int column) {
        super(String.format("Не верный формат данных в row = %d и col = %d", row, column));
    }
}
