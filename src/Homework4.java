import java.util.ArrayList;
import java.util.LinkedList;
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

    }
}
