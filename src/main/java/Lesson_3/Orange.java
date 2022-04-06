package Lesson_3;

public class Orange extends Fruit{

    public Orange(int quantity) {
        super(quantity);
    }

    @Override
    public float getWeight() {
        return 1.5f * getQuantity();
    }
}
