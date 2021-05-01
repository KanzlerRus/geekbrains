package lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private long phone;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, long phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s\n" +
                "должность: %s\n" +
                "электорнная почта: %s\n" +
                "номер телефона: %d\n" +
                "зарплата: %.2f$\n" +
                "возраст: %d\n", name, position, email, phone, salary, age);
    }
}
