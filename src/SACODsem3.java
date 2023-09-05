class sList{
    Node head;
    class Node {
        int value; // значение узла
        Node next; // ссылка на следующий узел d
    }

    void push_front(int value){ //вставка в начало (самое простое)
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    void push_back(int value){ //вставка в начало (самое простое)
        Node node = new Node();
        node.value = value;
        if(head == null){
            head = node;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
    }}

    void pop_front(){ //методу удаления параметры не нужны
        if (head != null) // делаем проверку того, что голова есть, а значит есть и ссылка на след узел у головы
            head = head.next;
    }

    void pop_back(){ //методу удаления параметры не нужны
        Node current = head;
        if (head != null) { // делаем проверку того, что голова есть, а значит есть и ссылка на след узел у головы
            if(head.next == null) head = null; // если в списке только 1 узел
            else {
                while (current.next.next != null) current = current.next; // если в списке 2 узла и более
                current.next = null;
            }
        }
    }

    boolean contains(int value){
        Node current = head;
        while (current != null){
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }


}

class dList{
    Node head;
    Node tail;
    class Node {
        int value; // значение узла
        Node next; // ссылка на следующий узел
        Node previous;  //  ссылка на предыдущий
    }

    void push_front(int value){ //вставка в начало (самое простое)
        Node node = new Node();
        node.value = value;
        if(head == null){
            tail = node;
        } else{
            node.next = head;
            head.previous = node;
        }
        head = node;
    }

    void push_back(int value) { //вставка в конец как вставка в начало, только все ссылки на обратные
        Node node = new Node();
        node.value = value;
        if (tail == null) {
            head = node;
        } else {
            node.previous = tail;
            tail.next = node;
        }
        tail = node;
    }
    void pop_front(){ //методу удаления параметры не нужны
        if (head != null) // делаем проверку того, что голова есть, а значит есть и ссылка на след узел у головы
            if(head.next == null) {
                tail = null;
                head = null;
            } else {
                head = head.next;
                head.previous = null;
            }
    }

    void pop_back(){ // меняем ссылки у pop front на обратные
        if (tail != null)
            if(tail.previous == null) { // у хвоста нет предыдущего элемента = если один элемент в списке
                tail = null;
                head = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
    }

    boolean contains(int value){
        Node current = head;
        while (current != null){
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    void BubbleSort(){
        boolean ok;
        do{
            ok = false;
            Node node = head;
            while (node != null){
                if(node.next!= null){
                    if(node.value > node.next.value){
                        ok = true;

                        Node before = node.previous;
                        Node current = node;
                        Node next = node.next;
                        Node after = next.next;

                        current.previous = next;
                        current.next = after;

                        next.previous = before;
                        next.next = current;

                        if(before != null){
                            before.next = next;
                        } else {
                            head = next;
                        }
                        if (after != null){
                            after.previous = current;
                        } else{
                            tail = current;
                        }

                    }
                }
                node = node.next;
            }
        } while(ok);
    }
    void print(){
        Node current = head;
        while(current != null){
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println("");
    }
}
public class SACODsem3 {
    public static void main(String[] args) {
        dList list = new dList();
        for (int i = 10; i <=15 ; i++) {
            list.push_front(i);
        }
        for (int i = 10; i > 5 ; i--) {
            list.push_front(i);
        }

        list.print();
        System.out.println("===============================");
        list.BubbleSort();
        list.print();

    }
}
