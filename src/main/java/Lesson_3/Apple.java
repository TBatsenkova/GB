package Lesson_3;

public class Apple extends Fruit{

    public Apple(int quantity) {
        super(quantity);
    }

    @Override
    public float getWeight() {
        return 0.5f * getQuantity();
    }
}
