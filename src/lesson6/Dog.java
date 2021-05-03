package lesson6;

class Dog extends Animal {

    private static int counterDog;

    public Dog(String name) {
        super(name);
        counterDog++;
    }

    public static int getCounterDog() {
        return counterDog;
    }

    @Override
    public void run(int length) {
        if (length > 500) {
            System.out.printf("Собака: %s не может пробежать больше 500м\n", this.name);
        } else {
            System.out.printf("Собака: %s пробежала: %d\n", this.name, length);
        }
    }

    @Override
    public void swim(int length) {
        if (length > 10) {
            System.out.printf("Собака: %s не может проплыть больше 10м.", this.name);
        } else {
            System.out.printf("Собака: %s проплыла: %d\n",this.name, length);
        }
    }
}
