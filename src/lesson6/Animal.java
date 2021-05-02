package lesson6;

abstract class Animal {

    private static int counterAnimal;

    public Animal() {
        counterAnimal++;
    }

    public static int getCounterAnimal() {
        return counterAnimal;
    }

    protected abstract void run(int length);

    protected abstract void swim(int length);
}
