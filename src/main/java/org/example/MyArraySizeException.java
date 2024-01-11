package org.example;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Размер массива не равен 3х3");
    }
}
