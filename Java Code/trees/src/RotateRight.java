//public class RotateRight {
//
//    private Node<E> rotateRight(Node<E> root){
//        Node<E> temp = root.left;
//        root.left = temp.right;
//        temp.right = root;
//        return temp;
//    }
//}

//Exercise 1: Give a precise expression (N(h)) for the minimum number of nodes in an AVL Tree of height h
//N(0) = 1
//N(1) = 2
//N(2) = 4
//N(3) = 7
//N(4) =
//N(h) = N(h-1) + N(h-2) + 1
//N(4) = N(4- 1) + N(4-2) + 1   (in other words N(3) + N(2) + 1) or 7 + 4 + 1 = 12