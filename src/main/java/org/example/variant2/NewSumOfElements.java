package org.example.variant2;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 1. Далее метод должен пройтись по всем элементам массива, преобразовать в double и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 * с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * 2. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета
 * (сумму элементов, при условии, что подали на вход корректный массив).
 * <p>
 * 3. Как усложнение (связано с ООП): как сделать так, чтобы подсветились все ячейки, в которых пришло некорректное значение (буква вместо числа например)?
 * Ведь если выбрасывается throw, то программа завершает свою работу.
 * <p>
 * Вопросы:
 * 1. Правильно ли унаследовался в классах-исключениях?
 * 2. Строка 45-46. Правильно ли перехватывать NumberFormatException и бросать NewMyArrayDataException?
 * 3. В каком случае правильно классы-исключения делать непроверяемыми, а когда проверяемыми (когда наследовать от рантайм, а когда от эксепшн)?
 * 4. trow получается нужно для принудительного выбрасывания исключения? То есть например в нашем случае исключение NumberFormatException
 * может возникнуть само в ходе выполнения программы, но мы его не обрабатываем, а с помощью throw дополнительно выбрасываем свое исключение?
 */
public class NewSumOfElements {
    static String[][] arr = new String[][]{
            {"1", "s", "1.5"},
            {"s", "1.5", "1.5"},
            {"1", "1.5", "s"}
    };

    public static void main(String[] args) {
        try {
            System.out.println("Сумма элементов массива = " + sum2d(arr));
        } catch (NewMyArraySizeException e) {    //multi-catch
            System.err.println(e.getMessage());
        } catch (NewMyArrayDataException e){
            System.err.println(e.getMessage());

        }
    }

    public static double sum2d(String[][] arr) {
        //проверка размера массива.
        if (arr.length != 3 || arr[0].length != 3) throw new NewMyArraySizeException();
        //расчет суммы элементов массива.
        double sum = 0;
        List<Integer[]> invalidCells = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Double.parseDouble(arr[i][j]);
                } catch (NumberFormatException e) {
                    invalidCells.add(new Integer[]{i, j});
                }
            }
        }
        if(!invalidCells.isEmpty()) throw new NewMyArrayDataException(invalidCells);
        return sum;
    }
}
