package lesson6;

import java.util.Random;

class Lesson6 {
    private static final Random random = new Random();

    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Барсик"),
                new Cat("Алиса"),
                new Cat("Том"),
                new Dog("Муму"),
        };

        for (Animal animal : animals) {
            animal.run(random.nextInt(500));
            animal.swim(random.nextInt(20));
            System.out.println("================");
        }

        System.out.printf("Кол-во котов: %d\n", Cat.getCounterCat());
        System.out.printf("Кол-во собак: %d\n", Dog.getCounterDog());
        System.out.printf("Кол-во животных: %d\n", Animal.getCounterAnimal());
    }
}
