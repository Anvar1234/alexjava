package org.example.variant2;

import java.util.List;

public class NewMyArrayDataException extends NumberFormatException {

    public NewMyArrayDataException(List<Integer[]> invalidCells){
        for (Integer[] cell : invalidCells){
            System.err.println("Ошибочный формат данных в ячейке: [" + cell[0] + "," + cell[1] + "]");
        }
    }
}
