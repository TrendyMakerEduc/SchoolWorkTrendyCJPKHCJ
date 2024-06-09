public class AVLTrees {
    //The classic binary search tree can be unbalanced, reducing the efficiency of the
    //operations on it.

    //[1]
    //  \
    //  [2]
    //    \
    //    [3]
    //      \
    //      [4]
    //        \
    //        [5]
    //          \
    //          [6]
    //            \
    //            [7]

    //An AVL (Adelson-Velskii and Landis) tree is a binary search tree with a
    //balance condition

    //We want to maintain a depth of O(log N).
    //We can enforce some conditions

    //Requiring that the left subtree has the same depth as the right subtree.
    //Or requiring that every node must have the left and right subtree of the same height
    //With the first condtion it is not enough, because we get the same tree as above, by going left and right linearly

    //The second condition would work only for trees 2(**K) - 1, otherwise some nodes would be unbalanced.
    //So this condition is too restrictive.

    //So what are the conditions of the AVL trees?
    //AVL Tree
    //In AVL trees, for every node in the tree, the height of the left and right subtrees can differ by at most 1.
    //The height of an empty tree is defined to be -1.

    //The following figure illustrated the difference between an AVL tree and a binary search tree:
    //       [5]
    //      /    \
    //     [2]    [8]
    //    /  \    /
    //  [1]  [4]  [7]
    //       /
    //      [3]
    //   AVL TREE

    //       [5]
    //      /    \
    //     [2]    [8]
    //    /  \
    //  [1]  [4]
    //       /  \
    //      [3]  [5]
    // Binary search tree

    //How does it work?
    //The height information is kept for each node (in the node structure).
    //All the operations can be performed in O(log N), with the exception of insertion or deletion.
    // If we take the AVL tree in the previous figure and we try to insert 6, it would destroy the balance condition
    //       [5]
    //      /    \
    //     [2]    [8]
    //    /  \    /
    //  [1]  [4] [7]
    //      /    /
    //    [3]  [6]<----here

    //In this case, the property has to be restored before the insertion step is considered over.
    //To restore the property, we just need to do a rotation.
    //After an insertion, only nodes that are on the path from the insertion point to the root might have their balance altered
    //because only those nodes have their subtrees altered.

    //       [5] All from the right side, needs to be rebalanced
    //      /    \
    //     [2]    [8]
    //    /  \    /
    //  [1]  [4] [7]
    //      /    /
    //    [3]  [6]<----here

    //Let us call the node that must be rebalanced a.
    //Since any node has at most two children, and a height imbalance requires that a's two subtrees'
    //height differs by two, a violation might occur in four cases.

    //1) An insertion into the left subtree of the left child of a.
    //2) An insertion into the right subtree of the left child of a.
    //3) An insertion into the left subtree of the right child of a.
    //4) An insertion into the right subtree of the right child of a.

    // Cases 1 and 4 are identical in theory, as are cases 2 and 3.
    //For cases 1 and 4, the insertion occurs on the "outside" (left-left, right-right), and can be rixed by a single rotation.
    //For cases 2 and 3, the insertion occurs on the inside (left-right, right-left), and need to be fixed using a double rotation.

    //These are fundamental operations! They will be used regularly, so they need to be efficient.

    //Single Rotation
    // To illustrate the idea of a single rotation we will consider the following figure
    //            [k2]
    //           /    \
     //        [k1]     /  \
    //        /   \    /_z__\     BEFORE SINGLE ROTATION
//          /\   /  \
    //     /  \ /_y__\
//        /__x_\

    //            [k1]
    //            /   \
    //        /\       [k2]
    //       /  \      /   \      AFTER SINGLE ROTATION
    ////    /__x_\    / \  / \
    //               /__y\/__z\
    // (Imagine x y and z trees to line up at the same height.)

    //Before the rotation we have an unbalanced tree after an insertion, and
    //After the rotation we have it after a single rotation

    //In detail we have k(2), for which the left subtree is two levels deeper then the right subtree.
    //The node on the path of the unbalance is k(1)

    //The idea behind the rotation.
    //Imagine that the tree is flexible
    //Grab the node on the path (k(1) in the example).
    //Shake it, and let the gravity take hold.

    //The result will be that k(1) is the new root.

    //The binary search tree property tells us that in the original tree k(2) > k(1), so k(2) becomes the right child of k(1),
    //You can also see that X,Y,and Z are still on the same side respecitvely to k1 and k2.

    //Back to the example from before, inserting 6 into an AVL tree
    //       [5]
    //      /    \
    //     [2]    [8]
    //    /  \    /
    //  [1]  [4]  [7]
    //       /
    //      [3]
    //   AVL TREE
    //       [5]
    //      /    \
    //     [2]    [7]
    //    /  \    /  \
    //  [1]  [4]  [6] [8]
    //       /
    //      [3]
    //The node containing 8 is unbalanced.
    //The node on the path is 7.
    //We rotate 7 and 8.
    //We obtain the new subtree with 7 as the root.

    //Double Rotation
    //Using a simple rotation fix cases 1 and 4
    //However, it doesn't work for cases 2 and 3.
    //The problem is that Y is too deep and a single rotation does not make it any less deep.
    //This is why we use a double rotation.
    //Before using it, we need to consider one more node.
    //We just inserted a new node in Y, so it's not empty.
    //We can consider it has a root and two subtrees.
    //Consequently, the entire tree may be viewed as four subtrees connected by three nodes.
    //On which we can apply the double rotation, as illustrated below.

    //             [k3]
    //             /   \
    //                  / \
    //           [k1]  /__d\
    //           /  \                  BEFORE DOUBLE ROTATION
    //          /    [k2]
    //         / \     /  \
    //        /__a\   / \  / \
    //               /__b\/__c\

    //            [ k2]
    //           /     \
    //         [k1]      [k2]
    //        /    \    /    \        AFTER DOUBLE ROTATION
    //       / \  / \  / \   / \
    //      /__a\/__b\/__c\ /__d\

    //One of the subtree (B or C) is deeper then D, but we cannot be sure which one.
    //In the end, it doesn't matter, both subtrees are drawn at 1.5 levels below D.
    //OK, HOW DO WE BALANCE THE TREE?

    //Remember that a rotation between k1 and k3 doesn't work.
    //SO the only root possible is k2.
    //It means that k1 must be the left child of k2, and k3 the right child.
    //Then we adjust the subtrees:
    // B must be on the left side of k2, so a child of k1
    // C must be on the right of k2, so a child of k3.

    //It is called a double rotation, because it is the same effect of rotation between a's
    //child and grandchild, and then between a and its new child.

    //The theory should be clear by now, so we can move to the implementation details.

    //Implementation of the AVL ADT
    //The implementation details are straightforward except that there are several cases.

    //Classes
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

//As you can see, we inherit from Node, so we don't need to redefine everything.
//One more thing, we optimize the type of height and just maintain if one subtree is unbalanced
//with -1, +1, or 0 if it is balanced.
//However, it complicates the code

//AVL Tree
//For the tree the public interface is the same, in the end what changes is the balancing of the binary tree search.
//Something that the user will not need to use directly, so it will be in the private part of the class
/**
 * Self-balancing binary search tree using algorithm define by
 * Adelson-Velskii and Landis.
 * @param <E> Type contained in the tree.
 */
public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {
    // Data Fields
    /**
     * Flag to indicate that height of tree has increased.
     */
    private boolean increase;

//Insertion
//To insert a new node containing X into the tree T:
// if the root is null
//     Create a new tree with the item at the root and return true.
// else if the item is equal to root.data
//        The item is already in the tree; return false
// else if the item is less that root.data
//     Recursively insert the item in the left subtree
//     if the height of the left subtree has increased (increase is true)
//        Decrement balance
//         if balance is 0, reset increase to false
//         if balance is less then -1
//            Reset increase to false
//            Perform a rebalanceLeft.
// else if the item is greater then root.data
//       The processing is symmetric to steps 4 through 10. Note that balance is incremented if increase is true.

//We will optimize the code of the AVL tree, but we will try to make it readable.
//We will consider the following functions.
//The add function
//The rebalanceLeft function
//The rebalanceRight function.

//The add one is identical to the one in the binary tree search except for the private one in which we
// need to launce the rebalanceLeft or rebalanceRight after the insertion.

    /**
     * Recursive add method. Insert the given item into the tree.
     *
     * @param localRoot The local root of the subtree
     * @param item      The item to insert
     * @return The new local root of the subtree with the item inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }
        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);
            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
        } else if (item.compareTo(localRoot.data) > 0) {
            // item > data
            localRoot.right = add((AVLNode<E>) localRoot.right, item);
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    increase = false;
                    return rebalanceRight(localRoot);
                }
            }
        }
        return localRoot;
    }


//This way the balancing will be done at each level, if necessary.
//Note that we are using two functions.
//decrementBalance(localRoot); and incrementBalance(localRoot);
//Indeed we need to update the balance of each node on the path to the root or until a rebalance is done.

    /**
     * Decrement the balance of the given node
     *
     * @param node The node to decrement the balance of
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            /* If now balanced, overall height has not increased. */
            increase = false;
        }
    }

    /**
     * Increment the balance of the given node
     *
     * @param node The node to increment the balance of
     */
    private void incrementBalance(AVLNode<E> node) {
        node.balance++;
        if (node.balance == AVLNode.BALANCED) {
            //If now balanced, overall height has not increased
            increase = false;
        }
    }


//Balance
//We need to consider different cases:
//The difference between the left subtree and the right subtree is greater than 1.
//  -Chech if the depth is greater on the exterior (left-left)
//     - Simple rotation on the left
//  -Otherwise, double rotation on the left.
//Otherwise, check the difference between the right subtree and the left subtree is greater than 1.
//  -Check if the depth is greater on the exterior (right-right).
//       -Simple rotation on the right.
//  -Otherwise double rotation on the right

//We will use 2 private methods for the rotations.

    /**
     * Method to rebalance left.
     *
     * @param localRoot Root of the AVL subtree that needs balancing.
     * @return A new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // Check if left-right heavy
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else {
                //Left-Right balanced case
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            localRoot.left = rotateLeft(leftChild);
        } else {
            // Left-left case
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate on the right.
        return (AVLNode<E>) rotateRight(localRoot);
    }

    /**
     * Method to rebalance right.
     *
     * @param localRoot Root of the AVL subtree that needs balancing.
     * @return A new localRoot
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
    }

    //DO THE RIGHT FUNCTIONS, WHICH IS IDENTICAL EXCEPT REFERENCING  the right
//Rotations
//As you can see we need to define the two rotation functions
//rotateLeft
//rotateRight
//Starting with rotateLeft

    /**
     * Method to perform a left rotation.
     *
     * @param root is the root of a binary search tree
     * @return The new root of the rotated tree
     * @post root.left is the root of a binary search tree,
     * root.left.left is raised one level,
     * root.left.right does not change levels,
     * root.right is lowered one level,
     * the new root is returned.
     */
    protected Node<E> rotateLeft(Node<E> root) {
        Node<E> temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }
}

//REMEMBER NODES CAN BE LISTS, ANY FORM OF DATA, ETC.
//Implement rotateRight

//Deletion
//We didn't talk about removing a node.
//Again it is the same as for the binary tree search, but we need to balance the tree after each deletion.

//Other operations.
//Everything else is exactly the same as in the binary tree search ADT.
//And it should not srprise you.
//The AVL Tree is just a self-balancing BST, nothing more, nothing less.

//With rotation in the AVL tree, we need to create a binary search tree with rotation
//When we insert a node, we increase the balance by 1, and you need a callback to a private flag
//to check to see if we need to recalculate

//Algorithm for Insertion into an AVL Tree
//if the root is null
//    Create a new tree with the item at the root and return true
//else if the item is equal to root.data
//    The item is already in the tree, return false
//else if the item is less than root.data
//    Recursively insert the item in the left subtree
//    if the height of the left subtree has increased (increase is true)
//        Decrement balance
//        if balance is zero, reset increase to false
//        if balance is less than -1
//        reset increase to false
//        perform a rebalanceLeft
//    else if the item is greater than root.data
//        The processing is symmetric to steps 4 through 10. Note that balance is incremented if increase is true

