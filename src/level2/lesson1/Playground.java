package level2.lesson1;

import level2.lesson1.actionInterface.Sportsmen;
import level2.lesson1.obstacle.Obstacle;

public class Playground {

    private Obstacle[] obstacles;
    private Sportsmen[] sportsmen;

    public Playground(Obstacle[] obstacles, Sportsmen[] sportsmen) {
        this.obstacles = obstacles;
        this.sportsmen = sportsmen;
    }

    public void startMarathon() {
        for (Sportsmen sportsman : sportsmen) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.passObstacle(sportsman)) {
                    System.out.println(sportsman + " не смог пройти препятсвие");
                    break;
                }
            }
        }
    }

}
