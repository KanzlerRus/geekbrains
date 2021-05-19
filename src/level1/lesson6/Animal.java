package level1.lesson6;

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

    protected abstract void run(int length);

    protected abstract void swim(int length);
}
