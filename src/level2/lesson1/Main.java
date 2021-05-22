package level2.lesson1;

import level2.lesson1.actionInterface.Sportsmen;
import level2.lesson1.obstacle.Obstacle;
import level2.lesson1.obstacle.RunningTrack;
import level2.lesson1.obstacle.Wall;
import level2.lesson1.person.Cat;
import level2.lesson1.person.Human;
import level2.lesson1.person.Robot;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = {
                new Wall(10),
                new RunningTrack(50),
                new RunningTrack(100),
                new Wall(30)
        };

        Sportsmen[] sportsmen = {
                new Cat("Barsik", 50, 50),
                new Human("Human", 30, 100),
                new Robot("T9", 100, 1000)
        };

        Playground playground = new Playground(obstacles, sportsmen);
        playground.startMarathon();
    }
}
