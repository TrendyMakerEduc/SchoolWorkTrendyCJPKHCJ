public class PriortyQueue {

    //Exercise 1- Can both insert and findMin be implemented in constant time?
    //findMin has a algorithm of O(logN), while insert has an algorithm of O(1), worst case logN

    //Exercise 2- Show the results of inserting 10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13 and 2 into an initially empty binary
    //heap
    //10              10                 1          1              1           1              1             1
    //                   12           10   12     10  12         6  12       5    12        5   12        5   12
    //                                                  14      10    14   10  6    14    10 6    14    10  6   14
    //                                                                                        8              8    15

//    1
//   3   12
// 10  5   14
//      6   15
//       8

//    1
//   3   12
// 10  5   14
//   9  6   15
//       8

//    1
//   3   12
// 10  5   14
//7  9  6   15
//       8

//    1
//   3   12
// 10  4   14
//7  9  5    15
//       6
//        8


//    1
//   2   11
// 10  3   12
//7  9  4    13
//  8    5     14
//        6      15
//

    //Exercise 3- Show the result of performing three deleteMin operations in the heap of the previous exercise.

//     4
//   5   11
// 10  6   12
//7      9   13
//  8          14
//               15
//

//Exercise 4
//A complete binary tree of N elements uses array positions 1 to N. Suppose we try to use an array representation of a binary tree that is not complete. Determine how large the array must be for the following:
//1. a binary tree that has two extra levels. 4 * n
//2. a binary tree that has a deepest node at depth 2 log N. logn is the opposite of exponent, so 2 logN would be N**2
//3. a binary tree that has a deepest node at depth 4.1 log N. N**4.1
//4. the worst-case binary tree.

//Exercise 5
//Assume that we have a min heap, show the following regarding the maximum item in the heap:
//1. It must be at one of the leaves.
//2. Every leaf must be examined to find it.

//Exercise 6
//A min-max heap is a data structure that supports both deleteMin and deleteMax in O(log N) per operation.
//The structure is identical to a binary heap, but the heap-order property is that for any node, X, at even
//depth, the element stored at X is smaller than the parent but larger than the grand parent (where this make
//sense), and for any node, X, at odd depth, the element stored at X is larger than the parent but smaller
//than the grandparent.
//1. How do you find the minimum and maximum element?
//CSCI - 255: Advanced Data Structures
//Lecture 3, Winter 2023 Page 2
//2. Give an algorithm to insert a new node into the min-max heap.

}
