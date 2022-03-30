package Lesson_3_Task;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        GenericArray<?> obj = new GenericArray<>();

        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(intArr));
        obj.swap(intArr, 0, 3);
        System.out.println(Arrays.toString(intArr));

        Double[] doubleArray = {1.2, 2.0, 3.3, 4.8, 5.0};
        System.out.println(Arrays.toString(doubleArray));
        obj.swap(doubleArray, 1, 2);
        System.out.println(Arrays.toString(doubleArray));

        String[] stringArray = {"h", "e", "l", "l", "o"};
        System.out.println(Arrays.toString(stringArray));
        obj.swap(stringArray, 0, 4);
        System.out.println(Arrays.toString(stringArray));
    }
}
