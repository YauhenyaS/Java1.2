package ru.geekbrains.homework1;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height){
        this.height=height;
    }

    @Override
    public boolean passed(Rivals rivals) {
        if(rivals.jump(this.height)){
            System.out.printf("Wall is passed by%s\n",rivals.getName());
            return true;
        }
        System.out.printf("Wall is not passed by%s\n",rivals.getName());
        return false;
    }
}
