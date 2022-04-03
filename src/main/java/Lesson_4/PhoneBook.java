package Lesson_4;

import java.util.*;

public class PhoneBook {
    private HashMap<String, String[]> phoneBook_hm = new HashMap<String, String[]>();

        public void add(String name, String[] phone_number) {
                    phoneBook_hm.put(name, phone_number);
                }

        public void get(String toFindKey) {
            for (Map.Entry<String, String[]> elem : phoneBook_hm.entrySet()) {
                if (elem.getKey().equals(toFindKey)) {
                    System.out.println(elem.getKey() + ": " + Arrays.asList(elem.getValue()));
                }
            }
        }
}

