import java.util.ArrayList;

/** Hash table implementation using open addressing. */
public abstract class HashTableOpen<K, V> extends HashTable<K, V> implements JDHashMaps<K, V> {


    // Data Fields
    protected Entry<K, V>[] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry<K, V> DELETED = new Entry<>(null, null);

    // Constructor
    public HashTableOpen() {
        table = new Entry[START_CAPACITY];
    }

    /**
     * Return the value associated to the key.
     *
     * @param key the key
     * @return the value or null if the key is not present.
     */
    @Override
    public V get(K key) {
        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);
        // If the search is successful, return the value.
        if (table[index] != null)
            return table[index].getValue();
        else
            return null; // key not found.
    }

    /**
     * Returns true if this table contains no key-value mappings.
     *
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     * Associated the value with the speficied key.
     *
     * @param key   the key
     * @param value the value
     * @return Returns the previous value associated with the specified key, or null if there was no mapping for the key
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        int offset = 0;
        int i = 0;
        while (table[index] != null && table[index] != DELETED) {
            i += 1;
            offset = offset - 1 + 2 * i;
            index = (key.hashCode() + offset) % table.length;
        }
        table[index] = new Entry<K, V>(key, value);
        numKeys += 1;
        if ((numKeys + numDeletes) / table.length > LOAD_THRESHOLD) {
            rehash();
        }
        return value;
    }



    /**
     * Remove the mapping for this key from the table if it is present.
     *
     * @param key the key
     * @return Returns the previous value associated with the specified key, or null if there was no mapping.
     */
    @Override
    public V remove(K key) {
        int index = key.hashCode() % table.length;
        int offset = 0;
        int i = 0;
        while (table[index] != null && table[index] != DELETED) {
            i += 1;
            offset = offset - 1 + 2 * i;
            index = (key.hashCode() + offset) % table.length;
        }
        table[index] = DELETED;
        numKeys += 1;
        return table[index].getValue();
    }

    //Double hashing is almost the same, but the offset function needs to be double hashed.

    /**
     * Return the size of the table
     *
     * @return the size
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * Finds either the target key or the first empty slot in the
     * search chain using linear probing.
     * pre: The table is not full.
     *
     * @param key The key of the target object
     * @return The position of the target or the first empty slot if
     * the target is not in the table.
     */
    protected int find(K key) {
        int index = key.hashCode() % table.length;
        int offset = 0;
        int i = 0;
        while (table[index] != null) {
            if (table[index].getKey() == key) {
                return index;
            }
            i++;
            offset = offset - 1 + 2 * i;
            index = (key.hashCode() + offset) % table.length;
        }
        return -1;
    }


    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * post: The size of the table is doubled and is an odd integer.
     * Each nondeleted entry from the original table is reinserted into the expanded table.
     * The value of numKeys is reset to the number of items actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        //Rehashing is the same as the put function, but we are inserting into a new table, we create a table that is bigger.
        //so in int index, we change table.length so that is can be bigger. if we deleted alot, and we are below elements in the
        //table, we rehash(). it is the same as put except table.length changes in the int index


        Entry<K,V> oldtable[] = table;
        table = new Entry[oldtable.length * 2];
        this.numDeletes = 0;
        this.numKeys = 0;
        for (int i = 0; i < oldtable.length; i++) {
            if (oldtable[i] != null && oldtable[i] != DELETED) {

                put(oldtable[i].getKey(), oldtable[i].getValue());
            }

        }


    }
}