public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

//To reduce the memory used for creating a hash table of m, where m = n * n,
//We want to create hashtables that are quadratic in size ontop of the hashtable of size n.
//That is created in each cell, to store the element in the size.
//We need the second table that links off to be linear, so that it is smaller in size
//The quadratic is based on the number of elements that are being sent to the secondary bin in size.
//Due to collision, it can be either 2 * 2 or 3 * 3 based on previous placement and collision.

//When we have this probability of the primary of the hashtable would be size (n - 1) / 2 for collision.
//This is a method known as perfect hashing, instead of using n**2 which solves the size problem

//The number of collisions in the secondary hashtable is 1/ b(i)**2 where b(i) equals the number of collisions
//from the previous hashtable.

//To calculate collison in the secondary hashtable it is b(i)(b(i) - 1) / 2, we call this C(i) (collision in the second table), because it is basically
//the same collison as the first problem in perfect hashing if m = n **2, where if we went that route, only
//one hashtable would be (1/m) * (N(N-1)/2)..

// 1 /b(i)**2 is the probability of having collision in the secondary table.
//2 * c(i) + b(i) == b(i)**2

//The total space we have is 2(sigma)c(i) + (sigma)b(i)

//If we know n, we can use this hashtable to make O(1). But, we rarely know the number of elements in the hashtable