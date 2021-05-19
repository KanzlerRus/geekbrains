package level1.lesson5;

public class TestEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Nick",
                "Engineer",
                "test@test.com",
                8_916_000_00_00L,
                2000,
                50);

        Employee employee2 = new Employee(
                "Mike",
                "Doctor",
                "doctor@test.com",
                8_916_000_00_00L,
                2000,
                60);

        Employee employee3 = new Employee(
                "Sam",
                "Teacher",
                "teacher@test.com",
                8_916_000_00_00L,
                1000,
                40);

        Employee employee4 = new Employee(
                "Tom",
                "UFC",
                "ufc@test.com",
                8_916_000_00_00L,
                10_000,
                25);

        Employee employee5 = new Employee(
                "Ann",
                "manager",
                "ann@test.com",
                8_916_000_00_00L,
                5_000,
                30);

        Employee[] employees = {
                employee1,
                employee2,
                employee3,
                employee4,
                employee5
        };

        for (Employee el : employees) {
            if (el.getAge() >= 40) {
                System.out.println(el);
            }
        }

    }
}
