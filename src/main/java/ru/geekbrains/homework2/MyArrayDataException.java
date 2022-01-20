package ru.geekbrains.homework2;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int i, int j) {
        super(String.format("at %d row, %d column",i+1,j+1));
    }
}
