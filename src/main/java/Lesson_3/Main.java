package Lesson_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Box<Fruit> appleBox = new Box<>(new ArrayList<>());
        appleBox.addFruit(new Apple(10));
        appleBox.addFruit(new Apple(2));
        appleBox.addFruit(new Apple(3));
        System.out.println("Вес коробки с яблоками: " +
                appleBox.getBoxWeight() + " кг");

        Box<Orange> orangeBox = new Box<>(new ArrayList<>());
        orangeBox.addFruit(new Orange(6));
        orangeBox.addFruit(new Orange(2));
        orangeBox.addFruit(new Orange(5));
        System.out.println("Вес коробки с апельсинами: " +
                orangeBox.getBoxWeight() + " кг");

        System.out.println("Коробка с яблоками тяжелее коробки" +
                " с апельсинами?: " + appleBox.isHeavyThen(orangeBox));

        Box<Fruit> appleBox2 = new Box<>(new ArrayList<>());
        appleBox2.addFruit(new Apple(10));
        System.out.println("Вес второй коробки с яблоками: " +
                appleBox2.getBoxWeight() + " кг");

        appleBox.poreBoxInto(appleBox2);
        System.out.println("Вес второй коробки с яблоками: " +
                appleBox2.getBoxWeight() + " кг");
    }

}
