// Student name:  Daniel Trenholm
// Student number:201202966


import java.util.ArrayList;

public class HashTableChain<K, V> extends HashTable<K, V> implements JDHashMaps<K, V> {

    // Data Fields

    //We want an array list of type Entry from HashTable, implementing K and V as a table array to
    //make a 2D list
    private ArrayList<Entry<K, V>> table[];
    //We want the size to keep track of the table size
    private int size = 100;
    //Private int numkeys to have the number of keys in an array list
    private int numKeys;
    public HashTableChain(){
        table = new ArrayList[size];
        for(int i = 0; i < size; i++){
        table[i] = new ArrayList();
    }}

    public V get(K key){
        int object = Math.abs(key.hashCode() % table.length);
        for(int i = 0; i < table[object].size(); i++){
            if(table[object].get(i).getKey().equals(key)){
                return table[object].get(i).getValue();
            }

        }
    return null;
    }

    public V remove(K key){
        int object = key.hashCode() % table.length;
        for(int i = 0; i < table[object].size(); i++){
            if(table[object].get(i).getKey().equals(key)){
                V value = table[object].get(i).getValue();
                table[object].remove(i);
                return value;
            }

        }
        return null;

    }

    public V put(K key, V value){
        Entry<K,V> entry = new Entry<>(key, value);
        int object = Math.abs(key.hashCode() % table.length);
        for(int i = 0; i < table[object].size(); i++){
            if(table[object].get(i).getKey().equals(key)){
                return null;
            }

        }
        table[object].add(entry);
        return value;


    }

    //Returns and checks if size == 0 true if 0, false if not.
    public boolean isEmpty(){
        return size == 0;
        }

        // Returns the size integer
    public int size(){
        return size;
    }
}
