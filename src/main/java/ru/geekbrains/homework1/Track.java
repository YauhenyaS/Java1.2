package ru.geekbrains.homework1;

public class Track implements Obstacle{
    private int length;

    public Track(int length){
        this.length=length;
    }

    @Override
    public boolean passed(Rivals rivals) {
        if(rivals.run(this.length)){
            System.out.printf("Track is passed by%s \n",rivals.getName());
            return true;
        }
        System.out.printf("Track is not passed by%s \n",rivals.getName());
        return false;
    }
}


