import java.util.*;

public class Seminar3 {
    public static void main(String[] args) {
//        Object o = new Object();
//        List<Integer> list = new ArrayList<>(); // если убрать обобщение <Integer>, то можно хранить в списке любые типы.
//
//        list.add(1);
//        list.add(10);
//        int number = (int) list.get(0); // используем приведение, если не знаем, что там integer тип
//        number = list.get(1);
//        System.out.println(number);
//
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            list1.add(new Random().nextInt(100));
//            list2.add(new Random().nextInt(100));
//        }
//        System.out.println("list1 " + list1);
//        System.out.println("list2 " + list2);
//
////        list1.add(2,23); // ставим на индекс 2 число 23
////        list1.addAll(5, list2); // до 9 индекса будут значения из list1, затем до конца list2 будут значения list2;
////        list1.removeIf(n -> n%2!=0); // lambda выражение; Удаляем из списка все элементы, не кратные 2
////        System.out.println(list1);
////        list1.removeAll(list2); // удаляем из массива list1 массив list2
////        System.out.println(list2);
//
//        list1.retainAll(list2); // оставляет общие с list2
//        System.out.println("retained list1 " + list1);
////        System.out.println("retained list2 " + list2);
//        list2.sort(Comparator.naturalOrder()); // Comparator Natural Order - по увеличению
//        System.out.println("sorted list2 natural " + list2);
//        list2.sort(Comparator.reverseOrder()); // Comparator Reverse Order - по увеличению
//        System.out.println("sorted list2 reverse " + list2);
//        list2.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2; // если о1 больше о2, то будет положительное значение
//            }
//        });
//        System.out.println("sorted with new Comparator " + list2);
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.print(list2.get(i)+" ");
////            list2.set(i, 3);
//        }
//
//        Iterator<Integer> iterator = list2.iterator();
//        while(iterator.hasNext()){
//            int i = iterator.next();
////            System.out.println(i);
//        }
//
//        ListIterator<Integer> iterator1 = list2.listIterator(list2.size()/2);
//        while(iterator1.hasPrevious()){
//            int index = iterator1.previousIndex();
//            list2.set(index,12);
////            iterator1.set(12);
//            int i = iterator1.previous();
////            System.out.println(i);
//            if (i>12) iterator1.remove();
//        }
//
//        list2.forEach( n -> System.out.print(n));
//

////        Создать два целочисленных списка, заполнить случайными числами.
////        В первый список добавить все чётные числа из второго
//
//        ArrayList<Integer> numbers = new ArrayList<>();
//        ArrayList<Integer> numbersWithEvens = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            numbers.add(new Random().nextInt(10));
//            numbersWithEvens.add(new Random().nextInt(10));
//        }
//
//        System.out.println(numbers);
//        System.out.println("\n" + "-".repeat(100));
//        System.out.println(numbersWithEvens);
//        System.out.println("\n" + "-".repeat(100));
////        for (int item : numbers) {
////            if (item % 2 == 0) numbersWithEvens.add(item);
////        }
//
//        numbers.removeIf(n -> n % 2 != 0);
//        numbersWithEvens.addAll(numbers);
//
//        System.out.println(numbersWithEvens);
//        System.out.println("\n" + "-".repeat(100));

//        Создать два списка. Первый целочисленный, второй строковый. 
//        Заполнить первый список случайными числами. 
//        Перенести значения во второй список с приведением типа.
//
//        List<String> strings = new ArrayList<>();
//        List<Integer> numbers = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            numbers.add(new Random().nextInt(10));
////            strings.add(String.valueOf(numbers.get(i)));
//        }
//
////        for (Integer number : numbers) {
////            strings.add(String.valueOf(number));
////        }
//        numbers.forEach(n -> strings.add(String.valueOf(n)));
//        System.out.println(numbers);
//        System.out.println(strings);
//
//        /*Создать целочисленный список, заполнить случайными числами. Развернуть список.*/
//        List<Integer> numbers = new ArrayList<>();
//        List<Integer> revertNumbers = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            numbers.add(new Random().nextInt(10));
//        }
//        System.out.println(numbers);
////
////        ListIterator<Integer> iterator = numbers.listIterator(numbers.size());
////        while(iterator.hasPrevious()){
////            revertNumbers.add(iterator.previous());
////        }
//
//        numbers.forEach(n -> revertNumbers.add(0, n));
//
//        numbers = revertNumbers;
//        System.out.println(numbers);

        /* Создать целочисленный список,
        найти средний по значению элемент.
        Корректно выводил среднее число по значению, когда четное количество элементов*/

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(new Random().nextInt(10));
        }

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
        System.out.println(numbers.get(numbers.size()/2));

        int sum = 0;
        for (int number: numbers
             ) {
            sum += number;
        }
        float mean = sum / numbers.size();

        System.out.println(mean);
        System.out.println(numbers.get(numbers.indexOf((int)mean)));;
    }
}
