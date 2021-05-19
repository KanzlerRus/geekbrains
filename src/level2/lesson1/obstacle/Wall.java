package level2.lesson1.obstacle;

import level2.lesson1.actionInterface.Sportsmen;

public class Wall implements Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean passObstacle(Sportsmen sportsmen) {
        return sportsmen.jump(height);
    }
}
