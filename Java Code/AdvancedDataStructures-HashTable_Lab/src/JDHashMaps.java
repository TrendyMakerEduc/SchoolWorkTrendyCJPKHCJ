public interface JDHashMaps<K,V> {
    V get(K key); // gets the element
    boolean isEmpty(); // checks if the hashtable is empty
    V put(K key, V value); // Puts a key and a value into the array list
    V remove(K key); // Removes a key
    int size(); // Returns the size of the hashtable

}
