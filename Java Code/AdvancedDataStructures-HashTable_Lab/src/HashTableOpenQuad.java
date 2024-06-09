public class HashTableOpenQuad<K, V> extends HashTableOpen<K, V> implements JDHashMaps<K,V> {

    public int find(K key) {
        int index = key.hashCode() % table.length;
        int offset = 0;
        int i = 0;
        while (table[index] != null) {
            if (table[index].getKey() == key) {
                return index;
            }
            i++;
            offset = offset - 1 + 2 * (i * i);
            index = (key.hashCode() + offset) % table.length;
        }
        return -1;
    }
}
