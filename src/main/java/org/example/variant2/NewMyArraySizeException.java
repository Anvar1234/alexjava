package org.example.variant2;

public class NewMyArraySizeException extends RuntimeException{
    public NewMyArraySizeException() {
        super("Размер массива не равен 3х3");
    }
}
