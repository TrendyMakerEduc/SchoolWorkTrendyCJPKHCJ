import java.io.Serializable;
public interface SearchTree<E>{
    public E add(E target); //Adding function
   // public E contains(E target); //Containing function
    public E find(E target); //Finding the target node
    public E delete(E target); // Deletion method
   // public E remove(E target); // Removing the node
}




