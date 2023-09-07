import java.util.ArrayList;
import java.util.List;

public class Trees {
    Node root;

    public class Node {
        int value;
        List<Node> children;

    }

//    private Node find(Node node, int value) { // обход в глубину
//        if (node.value == value) { // если переданный узел содержит значение, то возвращаем этот узел
//            return node;
//        } else { // иначе запускаем рекурсию по поиску значения у детей текущего узла
//            for (Node child : node.children) {
//                Node result = find(child, value);
//                if (result != null) { // если мы нашли узел-ребенка у текущего узла, то возвращаем этот узел
//                    return result;
//                }
//            }
//        }
//        return null; // возвращаем, если не нашли узел с нужным значением
//    }

    private Node find(int value){ //обход в ширину. Не использует рекурсию, использует только циклы. Более сложный и ресурсозатратный, чем обход в ширину
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0 ){ // до тех пор, пока размер списка больше нуля (есть дети в объекте)
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) { //для каждого узла
                if(node.value == value){ // если нашли узел с нашим значением, то возвращаем этот узел
                    return node;
                }
                nextLine.addAll(node.children); // в других случаях добавляем в список всех детей текущего узла.
            }
            line = nextLine; // как только вышли из цикла for - закончился список с узлами line, добавили в него список детей всех узлов из nextLine
        }
        return null;
    }

    public boolean exist(int value) {
        if (root != null) {
//            Node node = find(root, value); // обход в глубину
            Node node = find(value); // обход в ширину
            if (node != null) {
                return true;
            }
        }
        return false;
    }
}
