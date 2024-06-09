import java.util.NoSuchElementException;

public class HashTableOpenDouble<K,V> extends HashTableOpenQuad<K,V> implements JDHashMaps<K,V> {
    public int hash2(K key) {
        int index = nextPrime(table.length) - key.hashCode() % table.length;
        return index;
    }

    public boolean isPrime(int n) {
        int i, m = 0, flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.println(n + " is not prime number");
            return false;
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not prime number");
                    flag = 1;
                    return false;
                }
            }
            if (flag == 0) {
                System.out.println(n + " is prime number");
                return true;
            }
        }//end of else
        return false;
    }


    public int nextPrime(int n){
        if (isPrime(n) == true) {
            n--;
        }
        while(isPrime(n) != true){
            n--;
        }
        return n;
    }

    public int find(K key) {
        int index = key.hashCode() % table.length;
        int offset = 0;
        int i = 0;
        if(index < 0){
            index = index + table.length;
        }
        while (table[index] != null) {
            if (table[index].getKey() == key) {
                return index;
            }

            i++;
            offset = i * hash2(key);
            index = (key.hashCode() + offset) % table.length;
            if(index < 0){
                index = index + table.length;
            }
        }
        return -1;
    }

}






