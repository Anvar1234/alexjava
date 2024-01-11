package org.example;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int row, int column) {
        super("Ошибочный формат данных в ячейке: [" + row + "," + column + "]");
    }
}
