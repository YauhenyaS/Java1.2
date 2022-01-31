package ru.geekbrains.homework5;

import java.util.Arrays;

public class TwoThread {
    static final int size=10000000;

    public static void main(String[] args) throws InterruptedException {
        float [] arr=new float[size];
        Arrays.fill(arr,1);
        float [] arr1 =new float[size/2];
        float [] arr2 =new float[size/2];

        long a=System.currentTimeMillis();
        System.arraycopy(arr,0, arr1,0,size/2);
        System.arraycopy(arr,size/2, arr2,0,size/2);
        Thread thread1=new Thread(() ->{
            for(int i=0;i<arr1.length;i++){
                arr1[i]=(float)(arr1[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));

            }
        });
        Thread thread2=new Thread(() ->{
            for(int i=0;i<arr2.length;i++){
                arr2[i]=(float)(arr2[i]*Math.sin(0.2f+(i+size/2)/5)*Math.cos(0.2f+(i+size/2)/5)*Math.cos(0.4f+(i+size/2)/2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(arr1,0, arr,0,size/2);
        System.arraycopy(arr2,0, arr,size/2,size/2);

        System.out.println("Время обработки:" + (System.currentTimeMillis()-a));

    }

}
