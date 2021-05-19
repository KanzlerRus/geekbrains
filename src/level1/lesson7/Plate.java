package level1.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreasedFood(int amount) {
        this.food -= amount;
    }

    public void info() {
        System.out.println("Food in plate is :" + food);
    }

    public void addFood(int amount) {
        System.out.println("Еды добавлено в миску : " + amount);
        this.food += amount;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
