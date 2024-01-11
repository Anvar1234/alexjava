package org.example.variant2;

import java.util.List;

public class NewMyArrayDataException extends NumberFormatException implements MyExceptionable {
    private final List<Integer[]> invalidCells;
    public NewMyArrayDataException(List<Integer[]> invalidCells){
        this.invalidCells = invalidCells;

    }

    @Override
    public void printMessage() {
        for (Integer[] cell : invalidCells){
            System.err.println("Ошибочный формат данных в ячейке: [" + cell[0] + "," + cell[1] + "]");
        }
    }
}
