package lesson7;

import java.util.Locale;

public class MyString {
    public static void main(String[] args) {
        String str = "I like Java!!!";
        System.out.println(str.charAt(str.length() - 1));
        System.out.println(str.endsWith("!!!"));
        System.out.println(str.startsWith("I like"));
        System.out.println(str.contains("Java"));
        System.out.println(str.indexOf("Java"));
        System.out.println(str.replace("a", "o"));
        System.out.println(str.toUpperCase(Locale.ROOT));
        System.out.println(str.toLowerCase(Locale.ROOT));

        int start = str.indexOf("Java");
        System.out.println(str.substring(start, start + 4));
    }
}
