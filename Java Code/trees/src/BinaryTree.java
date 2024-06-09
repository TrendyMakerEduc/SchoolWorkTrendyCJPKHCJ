import java.io.Serializable;
public class BinaryTree<E> implements Serializable {


    public static class Node<E> implements Serializable {
        public E data;
        public Node left;
        public Node right;

        public Node(E data){
        this.data = data;
        this.left = null;
        this.right = null;
        }


        @Override
        public String toString(){
            return String.format("Parent = %s, LeftTreeNode = %s, RightTreeNode = %s", data, left, right);
        }
    }

    public Node getLeftSubtree(){
        return root.left;
    }

    public Node getRightSubTree(){
        return root.right;
    }

    public Node getData(){
        return root;
    }

    public BinaryTree(){
        root = null;

    }

    public BinaryTree(Node<E> root){
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
    root.data = data;
    root.left = leftTree.root;
    root.right = rightTree.root;
    }


   //Function needs to be updated
    public Node<E> findMinChild(Node<E> root){

        //Check whether tree is empty
        if(root == null) {
           return root;
        }
        else {
            Node<E> leftMin;

            //It will find smallest element in left subtree
            if(root.left != null){
                leftMin = findMinChild(root.left);
            }
            else{
                return root;
            }
            return leftMin;
        }


    }



    // Root of the tree.
    public Node<E> root;
}