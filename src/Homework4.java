import java.util.*;


class Calculator {
    ArrayDeque<Integer> results;
    public int calculate(char op, int a, int b) {
        // Напишите свое решение ниже
        int result = 0;
        if(results == null) results = new ArrayDeque<>();
        switch (op){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                if (b != 0) {
                    result = a/b;
                } else {
                    System.out.println("На ноль делить нельзя");
                }
                break;
            case '<':
                results.pollLast();
                return results.pollLast();
        }
        results.add(result); // 10 6 7
        return result;
    }
}
class MyQueue<T>{
    //    В классе MyQueue реализуйте очередь с помощью LinkedList со следующими методами:
    LinkedList <T> queue;
    public void enqueue(T element){     //enqueue() - помещает элемент в конец очереди
        if(queue == null){
            queue = new LinkedList<>();
            queue.addLast(element);
        } else queue.addLast(element);
}
    public T dequeue(){     //dequeue() - возвращает первый элемент из очереди и удаляет его
        if(queue == null){
            return null;
        } else{
            return queue.removeFirst();
        }
    }
    public T first(){   // first() - возвращает первый элемент из очереди, не удаляя
        if(queue == null){
            return null;
        } else{
            return queue.get(0);
        }
    }
    public LinkedList<T> getElements() { //    getElements() - возвращает все элементы в очереди
        return queue;
    }
}
class LLTasks {
    //Пусть дан LinkedList с несколькими элементами.
    //Напишите класс LLTasks с методом revert, который принимал бы на вход LinkedList и возвращает “перевернутый” список.
//
//    // Дан
//      [1, One, 2, Two]
//
//// Вывод
//      [1, One, 2, Two]
//      [Two, 2, One, 1]
    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        // Напишите свое решение ниже
        LinkedList<Object> tempList = new LinkedList<>();
        ll.forEach(tempList::addFirst);
//        for (int i = ll.size()-1; i >= 0; i--) {
//            tempList.addLast(ll.get(i));
//        }
        return tempList;
    }


}
public class Homework4 {
    public static void main(String[] args) {
        LinkedList<Object> list1 = new LinkedList<>();
        list1.add(1);
        list1.add("One");
        list1.add(2);
        list1.add("Two");
        LinkedList<Object> list2 = new LinkedList<>();
        System.out.println(list1);
        LLTasks answer = new LLTasks();
        list2 = answer.revert(list1);
        System.out.println(list2);

        System.out.println("*~".repeat(100));

        MyQueue<Integer> queue;
        queue = new MyQueue<>();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
        System.out.println("*~".repeat(100));


        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, 5, 3);
        System.out.println(result);
        int result2 = calculator.calculate(op2, 3, 3);
        System.out.println(result2);
        int result3 = calculator.calculate(op2, 4, 3);
        System.out.println(result3);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);

    }
}
