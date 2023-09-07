import java.util.Random;

class BiTree {
    private enum Color {
        RED, BLACK
    }

    Node root;

    class Node {
        int value;
        Color color;
        Node left;
        Node right;
    }

    boolean push(int value) {
        if (root != null) { // если корень пустой, то мы добавляем вставку в него
            boolean result = push(value, root);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        }
    }

    private boolean push(int value, Node node) {
        if (node.value == value) { // если значение выбранного узла совпадает со значением вставки, то выходим (в дереве только неповторяющиеся значения)
            return false;
        }
        if (node.value < value) { // если значение выбранного узла меньше значения вставки, то уходим направо
            if (node.right != null) {
                boolean result = push(value, node.right);
                node.right = rebalance(node.right);
                return result;
            } else {
                node.right = new Node();
                node.right.color = Color.RED;
                node.right.value = value;
                return true;
            }
        } else {
            if (node.left != null) {
                boolean result = push(value, node.left);
                node.left = rebalance(node.left);
                return result;
            } else {
                node.left = new Node();
                node.left.color = Color.RED;
                node.left.value = value;
                return true;
            }
        }
    }
//    boolean push (int value){
//        if (root == null){ // если корень пустой, то мы добавляем вставку в него
//             root = new Node();
//            root.value = value;
//            root.color = Color.BLACK;
//            return true;
//        }
//        root = rebalance(root);
//        Node node = root; // начинаем с корня дерева
//
//
//        while (node != null){ // пока выбранный узел не пустой
//            if(node.value == value){ // если значение выбранного узла совпадает со значением вставки, то выходим (в дереве только неповторяющиеся значения)
//                return false;
//            }
//            if(node.value < value){ // если значение выбранного узла меньше значения вставки, то уходим направо
//                if(node.right == null){ // если справа пустой узел, то делаем вставку в него
//                node.right = new Node();
//                node.right.value = value;
//                node.right.color = Color.RED;
//                node = rebalance(node);
//                return true; // возвращаем true для boolean метода вставки
//                } else{ // если узел справа не пустой, то выбираем его и итерация повторяется
//                    node = node.right;
//                }
//            }else{ // иначе - значение выбранного узла больше (случай == мы обработали в первом условии), то идем налево
//                if(node.left == null){ // если слева пустой узел, делаем вставку в него
//                    node.left = new Node();
//                    node.left.value = value;
//                    node.left.color = Color.RED;
//                    node = rebalance(node);
//                    return true;
//                } else { // иначе - узел слева не пустой, поэтому теперь выбираем его и переходим к следующей итерации цикла
//                    node = node.left;
//                }
//            }
//        }
//        return false;
//    }

    boolean find(int value) {
        Node node = root; // начинаем с корня дерева
        while (node != null) { // пока выбранный узел не пустой
            if (node.value == value) { // если значение выбранного узла совпадает со значением вставки, то выходим (в дереве только неповторяющиеся значения)
                return true;
            }
            if (node.value < value) { // если значение выбранного узла меньше значения вставки, то уходим направо
                node = node.right;
            } else { // иначе - значение выбранного узла больше (случай == мы обработали в первом условии), то идем налево
                node = node.left;
            }
        }
        return false;
    }

    Node leftTurn(Node parent) {
        Node rightChild = parent.right;
        Node transChild = rightChild.left;
        rightChild.left = parent;
        rightChild.color = parent.color;
        parent.right = transChild;
        parent.color = Color.RED;
        return rightChild;
    }

    Node rightTurn(Node parent) {
        Node leftChild = parent.left;
        Node transChild = leftChild.right;
        leftChild.right = parent;
        leftChild.color = parent.color;
        parent.left = transChild;
        parent.color = Color.RED;
        return leftChild;
    }

    void colorSwap(Node parent) {
        parent.color = Color.RED;
        parent.left.color = Color.BLACK;
        parent.right.color = Color.BLACK;
    }

    Node rebalance(Node node) {
        Node result = node;
        boolean flag = true;
        while (flag) {
            flag = false;
            if (result.right != null && result.right.color == Color.RED && (result.left == null || result.left.color == Color.BLACK)) {
                flag = true;
                result = leftTurn(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.left.left != null && result.left.left.color == Color.RED) {
                flag = true;
                result = rightTurn(result);
            }
            if (result.left != null && result.right != null && result.left.color == Color.RED && result.right.color == Color.RED) {
                flag = true;
                colorSwap(result);
            }
        }
        return result;

    }


}

public class BinaryTree {
    public static void main(String[] args) {
        BiTree tree = new BiTree();
//        tree.push(5);
//        tree.push(3);
//        tree.push(7);
//        System.out.println(tree.find(7));
//        tree.push(9);
//        System.out.println(tree.find(9));
//        tree.push(4);
//        System.out.println(tree.find(4));
//        tree.push(6);
//        tree.push(8);
        Random random = new Random();
        for (int d = 0; d < 10; d++) {
            int b = random.nextInt(20);
            tree.push(b);
            System.out.print(b + " ");
        }

        System.out.println(tree.find(8));
//        System.out.println(tree.find(9));


    }
}
