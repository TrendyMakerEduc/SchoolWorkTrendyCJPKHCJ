/**
 * Self-balancing binary search tree using algorithm define by
 * Adelson-Velskii and Landis.
 * @param <E> Type contained in the tree.
 */
public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {
    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;



    //private String toString(AVLTree<E> tree){
//
  //  }
    public AVLNode<E> add1(E item) {
        return add1((AVLNode<E>)this.root, item);

    }

    private AVLNode<E> add1(AVLNode<E> root, E item){
        if(root == null){
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }
        if(item.compareTo(root.data) == 0){
            increase = false;
            addReturn = false;
            return root;
        } else if (item.compareTo(root.data) < 0){
            root.left = add1((AVLNode<E>) root.left, item);
         if (increase) {
        decrementBalance(root);

        if(root.balance < AVLNode.LEFT_HEAVY){
            increase = false;
            return reBalanceLeft(root);
        }

    }} else if(item.compareTo(root.data) > 0){
            root.right = add1((AVLNode<E>) root.right, item);
            if(increase){
                incrementBalance(root);
            }if(root.balance > AVLNode.RIGHT_HEAVY){
                increase = false;
                return reBalanceRight(root);
            }
        }return root;}

    private AVLNode<E> delete(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete((AVLNode<E>) localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete((AVLNode<E>) localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return (AVLNode<E>)localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return (AVLNode<E>) localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                localRoot = findMinChildAVL((AVLNode<E>) localRoot.right);
                return localRoot;
            }
        }
    }
    public AVLNode<E> findMinChildAVL(AVLNode<E> root){

        //Check whether tree is empty
        if(root == null) {
            return root;
        }
        else {
            AVLNode<E> leftMin;

            //It will find smallest element in left subtree
            if(root.left != null){
                leftMin = findMinChildAVL((AVLNode<E>)root.left);
            }
            else{
                return root;
            }
            return leftMin;
        }


    }
    public void decrementBalance(AVLNode<E> root){
        root.balance--;
        if (root.balance == AVLNode.BALANCED) {
            /* If now balanced, overall height has not increased. */
            increase = false;
        }

    }

    public void incrementBalance(AVLNode<E> root){
        root.balance--;
        if (root.balance == AVLNode.BALANCED) {
            /* If now balanced, overall height has not increased. */
            increase = false;
        }

    }

    private AVLNode<E> reBalanceLeft(AVLNode<E> root){
        //Start with a reference to the left child
        AVLNode<E> leftChild = (AVLNode<E>) root.left;
        //Checking if left right heavy
        if(leftChild.balance > AVLNode.BALANCED) {
            //Obtain a reference to the left-right child
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            if (leftRightChild.balance < AVLNode.BALANCED) {

                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                root.balance = AVLNode.RIGHT_HEAVY;
            } else if(leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                root.balance = AVLNode.BALANCED;


            } else {
                //Left Right Balanced Case
                leftChild.balance = AVLNode.BALANCED;
                root.balance = AVLNode.BALANCED;
            }
            root.left = rotateLeft(leftChild);
        } else{
            //Left left case
            leftChild.balance = AVLNode.BALANCED;
            root.balance = AVLNode.BALANCED;


        }
        // Now rotate on the right.
        return (AVLNode<E>) rotateRight(root);
    }

    private AVLNode<E> reBalanceRight(AVLNode<E> root){
        //Start with a reference to the right child
        AVLNode<E> rightChild = (AVLNode<E>) root.right;
        //Checking if right left heavy
        if(rightChild.balance > AVLNode.BALANCED) {
            //Obtain a reference to the right-left child
            AVLNode<E> RightLeftChild = (AVLNode<E>) rightChild.left;
            if (RightLeftChild.balance < AVLNode.BALANCED) {

                rightChild.balance = AVLNode.BALANCED;
                RightLeftChild.balance = AVLNode.BALANCED;
                root.balance = AVLNode.LEFT_HEAVY;
            } else if(RightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                RightLeftChild.balance = AVLNode.BALANCED;
                root.balance = AVLNode.BALANCED;


            } else {
                //Left Right Balanced Case
                rightChild.balance = AVLNode.BALANCED;
                root.balance = AVLNode.BALANCED;
            }
            root.left = rotateRight(rightChild);
        } else{
            //Right right case
            rightChild.balance = AVLNode.BALANCED;
            root.balance = AVLNode.BALANCED;


        }
        // Now rotate on the right.
        return (AVLNode<E>) rotateLeft(root);
    }


    /**
     * Class to represent an AVL Node.
     * It extends the BinaryTree.Node by adding the balance field.
     * @param <E> Type of the element in the tree.
     */
    private static class AVLNode<E> extends Node<E>{

        /** Constant to indicate left‐heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right‐heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height – left subtree height */
        private int balance;

        /**
         * Construct a node with the given item as the data field.
         * @param item The data field
         */
        public AVLNode(E item){
            super(item);
            balance = BALANCED;
        }

        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         * @return String representation of this object.
         */
        @Override
        public String toString(){
            return balance + ": " + super.toString();
        }

    }

//    public static void main(String[] args) {
//
//    }
}

