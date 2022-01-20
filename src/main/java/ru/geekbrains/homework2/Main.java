package ru.geekbrains.homework2;

public class Main {
    String [][] arr= new String[4][4];
    public static void main(String[] args) {
        try{
            arrExample(new String[][] {{"1","2","3","4"},{"5","6","7","8"},{"4","1","6","7"},{"3","5","8","1"}});
        } catch (MyArraySizeException e){
            System.out.println("Wrong array size!");
        }catch (MyArrayDataException e){
            System.out.println("Data Exception");
        }

    }

    public static int arrExample(String[][] arr){
        if(arr.length != 4){
            throw new MyArraySizeException();
        }
        int sum=0;
        for(int i=0;i< arr.length;i++){
            for(int j=0; j<arr[i].length;j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch(NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Sum =" +sum);
        return sum;
    }

}
