package lesson6;

public class Cat extends Animal {

    private static int counterCat;

    public Cat(String name) {
        super(name);
        counterCat++;
    }

    public static int getCounterCat() {
        return counterCat;
    }

    @Override
    public void run(int length) {
        if (length > 200) {
            System.out.printf("Кот: %s не может пробежать больше 200м.\n", this.name);
        } else {
            System.out.printf("Кот: %s пробежал: %d\n", this.name, length);
        }
    }

    @Override
    public void swim(int length) {
        System.out.printf("Кот: %s не умеет плавать\n", this.name);
    }


}
