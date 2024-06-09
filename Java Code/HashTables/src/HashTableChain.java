import java.util.ArrayList;

public class HashTableChain<K, V> extends HashTable<K, V> implements KWHashMap<K, V> {

    // Data Fields
    //We want an array list of type Entry from HashTable, implementing K and V as a table array to
    //make a 2D list
    private ArrayList<Entry<K, V>> table[];
    //We want the size to keep track of the table size
    private int size;
    //Private int numkeys to have the number of keys in an array list
    private int numKeys;

    public HashTableChain(){
     table = new ArrayList[size];

    }

    public V get(Object key){
        int object = key.hashCode() % table.size();
        for(int i = 0; i < table[object].size(); i++){
            if(table[object].get(i).getKey().equals(key)){
                //return

            }
        }
    }


}
