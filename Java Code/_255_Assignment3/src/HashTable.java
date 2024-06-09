// Student name:  Daniel Trenholm
// Student number:201202966


public class HashTable<K, V>{ // The class initates K and V

    protected static class Entry<K,V>{ // This is technically HashTable.Entry, a defining term for entry
        private final K key; // Our K generic is the key value
        private V value; // Our V generic is the value


        // This is an entry constructor, which takes both our key and value
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        //A get key method, which returns K key
        public K getKey(){
            return key;
        }

        //A get value method, which returns V value
        public V getValue(){
            return value;
        }

        //This method is different, instead of using this.val, we set the old value to value, and value becomes new val, while returning the old value to show what
        //is being replaced
        public V setValue(V val){
            V oldVal = value;
            value = val; // this is where the magic happens
            return oldVal; //returns what is being replaced
        }
        //To string representation
        @Override
        public String toString(){
            return "(" + key + ", " + value + ")";
        }
    }

}
