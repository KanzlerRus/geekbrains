package lesson6;

public class Dog extends Animal {

    private static int counterDog;

    public Dog() {
        super();
        counterDog++;
    }

    public static int getCounterDog() {
        return counterDog;
    }

    @Override
    public void run(int length) {
        if (length > 500) {
            System.out.println("Собака не может пробежать больше 500м");
        } else {
            System.out.printf("Собака пробежала: %d\n", length);
        }
    }

    @Override
    public void swim(int length) {
        if (length > 10) {
            System.out.println("Собака не может проплыть больше 10м.");
        } else {
            System.out.printf("Собака проплыла: %d\n", length);
        }
    }
}
