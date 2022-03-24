package Lesson_2;

public class Main {
    public static void main(String[] args) {

        String[][] strArray1 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] strArray2 = {
                {"1", "5", "3"},
                {"6", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] strArray3 = {
                {"2", "2", "3", "4"},
                {"2", "2", "3", "4"},
                {"1", "2", "1", "1"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] strArray4 = {
                {"1", "2", "a", "4"},
                {"a", "2", "3", "4"},
                {"1", "8", "3", "4"},
                {"1", "2", "3", "4"}
        };


        try {
            arrSum(strArray1);
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            arrSum(strArray2);
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            arrSum(strArray3);
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            arrSum(strArray4);
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
    }

    public static void arrSum(String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (strArray.length != 4) {
            throw new MyArraySizeException("Количество строк не равно 4");
        }
        for (String[] array : strArray) {
            if (array.length != 4) {
                throw new MyArraySizeException("Количество столбцов не равно 4");
            }
        }
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                if (!strArray[i][j].matches("[0-9]+")) {
                    throw new MyArrayDataException(String.format("Неверное значение '%s' в ячейке [%d, %d]", strArray[i][j], i, j));
                }
                sum += Integer.parseInt(strArray[i][j]);

            }
        }
        System.out.println("Сумма всех элементов: " + sum);
    }
}
