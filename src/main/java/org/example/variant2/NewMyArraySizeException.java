package org.example.variant2;

public class NewMyArraySizeException extends RuntimeException implements MyExceptionable{
    public NewMyArraySizeException() {
    }

    @Override
    public void printMessage() {
        System.out.println("Размер массива не равен 3х3");
    }
}
