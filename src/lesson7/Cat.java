package lesson7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (appetite > p.getFood() && !satiety) {
            System.out.println("В миске не достаточно еды");
        } else {
            System.out.println("Кот(" + name + ") + начал есть!");
            p.decreasedFood(appetite);
            satiety = true;
        }
    }

    public void info() {
        String str = !satiety ? "голоден" : "сыт";
        System.out.println("Сытость кота(" + name + ") : " + str);
    }
}
