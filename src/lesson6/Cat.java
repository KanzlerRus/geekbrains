package lesson6;

public class Cat extends Animal {

    private static int counterCat;

    public Cat() {
        super();
        counterCat++;
    }

    public static int getCounterCat() {
        return counterCat;
    }

    @Override
    public void run(int length) {
        if (length > 200) {
            System.out.println("Кот не может пробежать больше 200м.");
        } else {
            System.out.printf("Кот пробежал: %d\n", length);
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }


}
