import java.util.Iterator;
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{
    protected E deleteReturn;
    protected boolean addReturn;

    /**
     * Starter method find.
     * pre: The target object must implement the Comparable interface.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    public E find(E target) {
       return find(this.root, target);
    }
    /**
     * Recursive find method.
     * @param localRoot The local subtree's root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
    if(localRoot == null){
        return localRoot.data;
     }
     if(localRoot.data == target){
         return target;
     }
     if(target.compareTo(localRoot.data) > 0){
         System.out.println("Looking right...");
     find(localRoot.right, target);
     }
    if(target.compareTo(localRoot.data) < 0){
        System.out.println("Looking left..");
        find(localRoot.left, target);
      }
    return target;
    }

    /**
     * Add a new {@code item} in the tree.
     *
     * @param item The new element.
     * @return true if item is inserted; false otherwise.
     */
      public E add(E item) {
        return add(this.root, item);

    }
    /**
     * Recursive add method.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    private E add(Node<E> localRoot, E item) {
      if(localRoot == null){
        localRoot.data = item;
        System.out.println("NULL");
        return localRoot.data;
    }
    if(item.compareTo(localRoot.data) < 0){
        //Creates a new node
        if(localRoot.left == null){System.out.println("Creating left..");
            localRoot.left = new Node<E>(item);}
        else{add(localRoot.left, item);}
    }
        if(item.compareTo(localRoot.data) > 0){
            if(localRoot.right == null){System.out.println("Creating right..");
                localRoot.right = new Node<E>(item);}
            else{add(localRoot.right, item);}
        }

        return localRoot.data;
    }

    /**
     * Recursive delete method.
     * The item is not in the tree; {@code deleteReturn} is equal to the deleted
     * item as it was stored in the tree or null if the item was not found.
     * @param //localRoot The root of the current subtree
     * @param //item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    public E delete(E item){
        System.out.println("Setting node to null.");
        return remove(delete(this.root, item));
    }

    public E remove(Node<E> item){
        item = null;
        return null;
    }
//    private E delete(Node<E> localRoot, E item) {
//       if (localRoot == null) {
//           item is not in the tree.
//         deleteReturn = null;
//        return deleteReturn;
//     }
//     Search for item to delete.
//     int compResult = item.compareTo(localRoot.data);
//    if (compResult < 0) {
//     item is smaller than localRoot.data.
//        System.out.println("Looking down left of root.");
//      delete(localRoot.left, item);
//    } else if (compResult > 0) {
//     item is larger than localRoot.data.
//        System.out.println("Looking down right of root.");
//       delete(localRoot.right, item);
//    } else {
//     item is at local root.
//       deleteReturn = localRoot.data;
//            if (localRoot.left == null) {
//                 If there is no left child, return right child
//                 which can also be null.
//                System.out.println("returning right child");
//                if(localRoot.right != null){
//                localRoot = localRoot.right;}
//                return localRoot.data;
//            } else if (localRoot.right == null) {
//                 If there is no right child, return left child.
//                if(localRoot.left != null){
//                localRoot = localRoot.left;}
//                System.out.println("returning left child");
//                return localRoot.data;
//            } else {
//                 Node being deleted has 2 children, replace the data
//                 with inorder predecessor.
//                localRoot = findMinChild(localRoot.right);
//                return localRoot.data;
//            }
//        }
//    return localRoot.data;
//    }

//private E remove(Node<E> item){
//
//}

    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                localRoot = findMinChild(localRoot.right);
                return localRoot;
            }
        }
    }
   public boolean contains(E item){
    return contains(this.root, item) != null;
    }

    private E contains(Node<E> localRoot, E item) {
        if(localRoot == null){
            System.out.println("Local root is not found");
            return item;
        }
        int comp = item.compareTo(localRoot.data);
        if(comp  == 0) return localRoot.data;
        if(comp < 0 && localRoot.left != null) System.out.println(String.format("Looking in %s", localRoot)); contains(localRoot.left, item);
        if(comp > 0 && localRoot.right != null) System.out.println(String.format("Looking in %s", localRoot)); contains(localRoot.right, item);
        return item;


}

        public static void main(String[] args) {
            AVLTree<String> testOne = new AVLTree<String>();
            testOne.add1("The");
            testOne.add1("quick");
            testOne.add1("brown");
            testOne.add1("fox");
            testOne.add1("apple");
            testOne.add1("cat");
            testOne.add1("hat");
            System.out.println(testOne.toString());

            AVLTree<Integer> testTwo = new AVLTree<Integer>();
            testTwo.add1(30);
            testTwo.add1(40);
            testTwo.add1(15);
            testTwo.add1(25);
            testTwo.add1(90);
            testTwo.add1(80);
            testTwo.add1(70);
            testTwo.add1(85);
            testTwo.add1(15);
            testTwo.add1(72);
            System.out.println(testTwo.toString());

            AVLTree<String> testThree = new AVLTree<String>();
            testThree.add1("Now");
            testThree.add1("is");
            testThree.add1("time");
            testThree.add1("for");
            testThree.add1("all");
            testThree.add1("good");
            testThree.add1("men");
            testThree.add1("to");
            testThree.add1("come");
            testThree.add1("to");
            testThree.add1("the");
            testThree.add1("aid");
            testThree.add1("of");
            testThree.add1("the");
            testThree.add1("party");
            System.out.println(testThree.toString());
//            BinarySearchTree tree = new BinarySearchTree();
//            tree.root = new Node(10);
//            tree.add(20);
//            tree.add(40);
//            tree.add(25);
//            tree.add(27);
//            tree.add(28);
//            tree.add(29);
//
//
//            tree.find(10);
//            tree.find(29);
//
//
//            tree.contains(29);
//
//            tree.delete(29);
//
//            tree.contains(29);


        }
}





