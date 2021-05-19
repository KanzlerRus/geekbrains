package level2.lesson1.person;

import level2.lesson1.actionInterface.Sportsmen;

public class Human implements Sportsmen {

    private String name;
    private int jumpLength;
    private int runLength;

    public Human(String name, int runLength, int jumpLength) {
        this.jumpLength = jumpLength;
        this.runLength = runLength;
        this.name = name;
    }

    @Override
    public boolean jump(int height) {
        if (jumpLength >= height) {
            System.out.println(this + " перепрыгнул " + height);
            return true;
        } else {
            System.out.println(this + " не смог перепрыгнуть" + height);
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (runLength >= distance) {
            System.out.println(this + " пробежал " + distance);
            return true;
        } else {
            System.out.println(this + " не смог пробежать " + distance);
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
