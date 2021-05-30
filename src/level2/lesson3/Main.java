package level2.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        task1();
        task2();
    }

    private static void task2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nick","123_456_789");
        phoneBook.add("Jack","111_111_111");
        phoneBook.add("Mike","222_222_222");
        phoneBook.add("Nick","333_333_333");


        phoneBook.get("Nick");
    }

    private static void task1() {
        String[] array = {
                "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "One", "Two", "Three", "Four", "Three"
        };

        Map<String, Integer> map = new HashMap<>();
        for (String el : array) {
            if(map.containsKey(el)) {
                int counter = map.get(el);
                map.replace(el, ++counter);
            } else {
                map.put(el, 1);
            }
        }

        for(String el : map.keySet()) {
            System.out.printf("%s\t%d\n",el,map.get(el));
        }
    }
}
