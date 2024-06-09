public interface KWHashMap<K, V> {

    /**
     * Return the value associated to the key.
     * @param key the key
     * @return the value or null if the key is not present.
     */
    V get(Object key);

    /**
     * Returns true if this table contains no key-value mappings.
     * @return true or false
     */
    boolean isEmpty();

    /**
     * Associated the value with the speficied key.
     * @param key the key
     * @param value the value
     * @return Returns the previous value associated with the specified key, or null if there was no mapping for the key
     */
    V put(K key, V value);

    /**
     * Remove the mapping for this key from the table if it is present.
     * @param key the key
     * @return Returns the previous value associated with the specified key, or null if there was no mapping.
     */
    V remove(Object key);

    /**
     * Return the size of the table
     * @return the size
     */
    int size();

}
