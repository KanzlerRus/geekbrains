package level2.lesson1.obstacle;

import level2.lesson1.actionInterface.Sportsmen;

public class RunningTrack implements Obstacle {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean passObstacle(Sportsmen sportsmen) {
        return sportsmen.run(length);
    }
}
