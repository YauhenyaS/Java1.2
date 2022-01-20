package ru.geekbrains.homework1;

public class Action {
    public static void main(String[] args) {
        Rivals [] rivals= {
                new People("People",250,150),
                new Robot("Robot",150,50),
                new Animal("Animal",300,100)
        };
        Obstacle [] obstacles ={
                new Wall(100),
                new Track(100)
        };
        for(Rivals r:rivals){
            for(Obstacle o:obstacles){
                if(!o.passed(r)) break;
            }
        }

    }
}
/*Были сложности с выполнением, подсмотрела лекции и тоже сделала по вашему примеру, но
не понимаю ,почему  у меня робот игнорирует бег? я же не прописывала, что он не умеет бегать
 */