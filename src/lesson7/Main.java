package lesson7;

class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik",20),
                new Cat("Tom",30),
                new Cat("Alica", 40)
        };

        Plate plate = new Plate(70);

        plate.info();

        for (Cat el : cats) {
            System.out.println("=============");
            el.info();
            el.eat(plate);
            el.info();
            System.out.println("=============");
        }

        plate.info();
        plate.addFood(100);
        plate.info();
    }
}
