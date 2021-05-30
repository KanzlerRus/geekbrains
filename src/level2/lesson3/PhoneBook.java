package level2.lesson3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<String,String> dbPhoneBook = new HashMap<>();

    public void add(String name, String phoneNumber) {
        dbPhoneBook.put(phoneNumber, name);
    }

    public void get(String name) {
        for (String s : dbPhoneBook.keySet()) {
            if (dbPhoneBook.get(s).equals(name)) {
                System.out.printf("Name is %s and phone is %s\n", dbPhoneBook.get(s), s);
            }
        }
    }

}
