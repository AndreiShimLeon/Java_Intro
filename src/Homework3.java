import java.util.*;

public class Homework3 {
    public static void analyzeNumbers(Integer[] arr) {
        // Введите свое решение ниже
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Minimum is 1
        // Maximum is 9
        // Average is = 5
        ArrayList<Integer> arrayList = new ArrayList<>(arr.length);
        for (int item : arr) {
            arrayList.add(item);
        }
        arrayList.sort(Comparator.naturalOrder());
        int average = 0;
        for (int item : arrayList) {
            average += item;
        }
        average /=arrayList.size();
        System.out.println(arrayList);
        System.out.printf("Minimum is %d\n", arrayList.get(0));
        System.out.printf("Maximum is %d\n", arrayList.get(arrayList.size() - 1));
        System.out.printf("Average is %d\n", average);
    }

    static void removeEvenNumbers(Integer[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : array) {
            result.add(item);
        }
        result.removeIf(n -> n % 2 == 0);
        System.out.println(result);
    }

    class MergeSort {

        public static int[] buffer = new int[100000];

        public static int[] mergeSort(int[] array) {
            if (array.length > 1) {
                MSort(array, 0, array.length - 1);
            }
            return array;
        }

        public static void MSort(int[] array, int left, int right) {
            if (left == right) {
                return;
            }
            int mid = (left + right) / 2;
            MSort(array, left, mid);
            MSort(array, mid + 1, right);
            int left_index = left, right_index = mid + 1, counter = left;
            while (left_index <= mid && right_index <= right) {
                if (array[left_index] < array[right_index]) {
                    buffer[counter++] = array[left_index++];
                } else {
                    buffer[counter++] = array[right_index++];
                }
            }
            while (left_index <= mid) {
                buffer[counter++] = array[left_index++];
            }
            while (right_index <= right) {
                buffer[counter++] = array[right_index++];
            }
            for (int i = left; i <= right; i++) {
                array[i] = buffer[i];
            }

        }
    }

    public static void main(String[] args) {
//        int[] a = {5, 1, 6, 2, 3, 4};
//        int[] result = MergeSort.mergeSort(a);
//        for (int item : result) {
//            System.out.print(item + " ");
//        }
    /*Напишите функцию removeEvenNumbers, которая принимала бы произвольный список целых чисел,
    удаляла бы из него четные числа и выводила список без четных чисел.
    Напишите свой код в методе removeEvenNumbers класса Answer. Метод removeEvenNumbers принимает на вход один параметр:
    Integer[] arr - список целых чисел

       Пример

*/

//        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        removeEvenNumbers(arr); // [1, 3, 5, 7, 9]
//        arr = new Integer[]{2, 4, 6, 8};
//        removeEvenNumbers(arr);  // []

        /*Напишите функцию analyzeNumbers, которая принимает на вход целочисленный список arr и:

        Сортирует его по возрастанию и выводит на экран
        Находит минимальное значение в списке и выводит на экран - Minimum is {число}
        Находит максимальное значение в списке и выводит на экран - Maximum is {число}
        Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
        Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

        Integer[] arr - список целых чисел

        Пример */


        Integer[] arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        analyzeNumbers(arr);

        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Minimum is 1
        // Maximum is 9
        // Average is = 5
    }
}
