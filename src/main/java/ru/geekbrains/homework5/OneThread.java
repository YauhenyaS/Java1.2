package ru.geekbrains.homework5;

import java.util.Arrays;

public class OneThread {
    static final int size=10000000;
    
    public static void main(String [] args) throws InterruptedException{
        float [] arr=new float[size];
        Arrays.fill(arr,1);
        long a=System.currentTimeMillis();
        Thread thread=new Thread(() ->{
                for(int i=0;i<arr.length;i++){
                    arr[i]=(float)(arr[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
                }
        });
        thread.start();
        thread.join();
        System.out.println("Время обработки:" +(System.currentTimeMillis()-a));

    }
}
