import java.io.Serializable;

public class BinaryTreeSearch<E> implements Serializable {

    protected static class Node<E> implements Serializable {
        protected Node<E> root;

    }

    /**
     * Starter method find.
     * pre: The target object must implement the Comparable interface.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    //public E find(E target) {
     //   return find(this.root, target);
    //}
    /**
     * Recursive find method.
     * @param localRoot The local subtree's root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    //private E find(Node<E> localRoot, E target) {
        //if(localRoot == null){
        //    return null;
       // }
       // if(localRoot(item) == target){
       //     return target;
       // }
       // if(localRoot.item) < target){
       // find(localRoot.right, target);
       // }
        //if(localRoot.item) > target){
        //    find(localRoot.left, target);
      //  }
    //}

    /**
     * Add a new {@code item} in the tree.
     *
     * @param item The new element.
     * @return true if item is inserted; false otherwise.
     */
  //  public boolean add(E item) {
//        Node<E> = add(localroot, item);

    //}
    /**
     * Recursive add method.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    //private Node<E> add(Node<E> localRoot, E item) {
      //  if(localRoot == null){
        //    localRoot = item;
          //  return localRoot;
        //}
        //else if(localRoot != null){
         //   return item;
        //}
    //}

    /**
     * Recursive delete method.
     * The item is not in the tree; {@code deleteReturn} is equal to the deleted
     * item as it was stored in the tree or null if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    //private Node<E> delete(Node<E> localRoot, E item) {
     //   if (localRoot == null) {
      //      // item is not in the tree.
       //     deleteReturn = null;
        //    return localRoot;
       // }
        // Search for item to delete.
       // int compResult = item.compareTo(localRoot.data);
        //if (compResult < 0) {
           // item is smaller than localRoot.data.
          //  localRoot.left = delete(localRoot.left, item);
           // return localRoot;
        //} else if (compResult > 0) {
            // item is larger than localRoot.data.
         //   localRoot.right = delete(localRoot.right, item);
          //  return localRoot;
        //} else {
            // item is at local root.
         //   deleteReturn = localRoot.data;
//            if (localRoot.left == null) {
//                 If there is no left child, return right child
//                 which can also be null.
//                return localRoot.right;
//            } else if (localRoot.right == null) {
//                 If there is no right child, return left child.
//                return localRoot.left;
//            } else {
//                 Node being deleted has 2 children, replace the data
//                 with inorder predecessor.
//                localRoot.data = findMinChild(localRoot.right);
//                return localRoot;
//            }
//        }
//    }
//}
class TreeNode
{
    public Object element;
    public TreeNode firstChild;
    public TreeNode nextSibling;
}