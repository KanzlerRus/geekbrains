package lesson6;

abstract class Animal {

    private static int counterAnimal;
    protected String name;

    public Animal(String name) {
        this.name = name;
        counterAnimal++;
    }

    public static int getCounterAnimal() {
        return counterAnimal;
    }

    abstract void run(int length);

    abstract void swim(int length);
}
