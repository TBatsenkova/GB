package Lesson_4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        String[] words = {
                "Java", "Cat", "Cats", "Dog", "dog", "Moscow", "Movies",
                "Window", "House", "Night", "Magic", "Cat", "J ava", "Window",
                " Window", "Window ", "1Window"
        };

        HashMap<String, Integer> uniqueWords = new HashMap<>();

        for (String word : words) {
            if (uniqueWords.get(word) == null) {
                uniqueWords.put(word, 1);
            }
            else {
                uniqueWords.put(word, uniqueWords.get(word) + 1);
            }
        }

        System.out.println(uniqueWords);
        System.out.println(" ");
    }

    private static void task2() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Kozlov", new String[]{"8751123459","8561215458"});
        phoneBook.add("Smirnov", new String[]{"8741568912"});
        phoneBook.add("Morozov", new String[]{"87894152","82584512"});

        phoneBook.get("Kozlov");
        phoneBook.get("Morozov");


    }

}

