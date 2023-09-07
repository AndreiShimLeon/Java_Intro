class HashMap{
    static final int INIT_SIZE = 16; // array size
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private void recalculate(){
        Basket[] old = baskets;
        baskets = (Basket[]) new Object[old.length*2];
        for (int i = 0; i < old.length; i++) {
            Basket basket = old[i];
            Basket.Node node = basket.head;
            while (node != null){
                push(node.entity.key, node.entity.value);
                node = node.next;
            }
            old[i] = null;
        }
    }
    class Entity { //  класс сущности
        int key;
        int value;
    }
    class Basket{ // класс списка
        Node head; // начальный элемент корзинки
        class Node{ // класс узла
            Entity entity;
            Node next;
        }

        int find(int key){
            Node node = head;
            while(node != null){
                if(node.entity.key == key)
                    return node.entity.value;
                node = node.next;
            }
            return -1; // если не нашли
        }

        boolean push(Entity entity){ // метод вставки в конец
            Node node = new Node();
            node.entity = entity;
            if(head == null){ // если голова пустая, то наша сущность становится головой
                head = node;
            } else { // иначе начинаем с головы и идем до конца
                Node current = head;
                while (current.next!= null){ // пока current не перейдет на следующий узел от последнего узла (null)
                    if(current.entity.key == entity.key){ // если нашли объект с ключом, который совпадает с ключом вставки, то сразу отказываем вставлять новую сущность
                        return false;
                    }
                    current = current.next; // сам переход на следующий узел
                }
                current.next = node;
            }
            return true;
        }
        boolean remove(int key){
            if(head != null){
                if(head.entity.key == key){
                    head = head.next;
                    return true;
                } else{
                    Node node = head;
                    while(node.next != null){
                        if(node.next.entity.key == key){
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
            return false;
        }
    }

    Basket[] baskets;
    public HashMap(){
        this(INIT_SIZE);
    }
    public HashMap(int size){
        baskets = new Basket[size];
    }

    int getIndex(int key){
//        key.hashCode();
        return key % baskets.length; // не init_size, потому что он может измениться
    }

    int find(int key){
        int index = getIndex(key);
        Basket basket = baskets[index]; // Обрабатываем случай, когда массив пустой или пуста ячейка под индексом
        if(basket != null){
            return basket.find(key);
        }
        return -1;
    }

    boolean push(int key, int value){
        if(baskets.length > size*LOAD_FACTOR){
            recalculate();
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        boolean add =  basket.push(entity);
        if(add){
            size++;
        }
        return add;
    }
    boolean remove(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket == null){
            return false;
        }
        boolean remove =  basket.remove(key);
        if (remove){
            size--;
        }
        return remove;
    }

}

public class HashTable {
    public static void main(String[] args) {
        HashMap map  = new HashMap();
        map.push(1,2);
        map.push(3,4);
        map.push(5,6);
        map.push(7,1);

        System.out.println(map.find(3)); // 4
        System.out.println(map.find(2)); // -1

        map.push(17, 8);
        System.out.println(map.find(17));
        map.remove(17);
        System.out.println(map.find(17));

    }
}
