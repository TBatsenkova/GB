package Lesson_3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> boxWithFruits;

    public Box(ArrayList<T> boxWithFruits) {
        this.boxWithFruits = boxWithFruits;
    }

    public ArrayList<T> getBoxWithFruits() {
        return boxWithFruits;
    }

    public void setBoxWithFruits(ArrayList<T> boxWithFruits) {
        this.boxWithFruits = boxWithFruits;
    }


    public void addFruit(T fruit) {
        getBoxWithFruits().add(fruit);
    }

    public float getBoxWeight() {
        return getBoxWithFruits().size() * getBoxWithFruits().get(0).getWeight();
    }

    public boolean isHeavyThen(Box<?> boxToCompare) {
        return Math.abs(getBoxWeight() - boxToCompare.getBoxWeight()) < 0.0001;
    }

    public void poreBoxInto (Box<Fruit> box) {
        box.getBoxWithFruits().addAll(boxWithFruits);
        boxWithFruits.clear();
    }
}
