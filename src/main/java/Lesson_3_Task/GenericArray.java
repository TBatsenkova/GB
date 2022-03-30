package Lesson_3_Task;

public class GenericArray<T> {
    //метод, меняющий местами два элемента массива
    public <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T tmp;

        for (int i = 0; i < array.length; i++) {
            tmp = array[firstIndex];
            array[firstIndex] = array [secondIndex];
            array[secondIndex] = tmp;
        }
    }


}
