public class BinomialQueue {
//Introduction
    // Consider a problem in which you use a priority queue,
    // EXAMPLE:
    // Now you recieve another priorty queue
    // i.e: lowest number in a Priorty Queue overriding an array
    //..... Short answer: you need to merge both of them.
    //It seems difficult to design a data structure that efficently supports merging
    //(In other words O(N) is our running time.
    //Merging require copying one array into another.
    //So, O(N)
    //How can we solve this for priorty queues?

    //What is a binomial Queue?
    //The Binomial Queues ADT needs to have the following operations.
    //-Insertion
    //-Deletion
    //-Merging

    //Every operation are O(log N) in the worst-case.
    //However, insertion takes constant time in average.

    //Structure

    //The most interesting thing about a binomial queue is its structure
    //It is not a heap-ordered tree, like binary heaps, (PriortyQueues.java),
    //but a collection of heap-ordered trees.

    //A collection of trees is called a forest.

    //The idea:
    //Each heap-ordered tree in the binomial queues is a binomial tree.
    //There is at most one binomial tree of every height.
    //B(k) is a binomial tree of height k
    //B(k) is formed by attaching B(k-1) to the root of another B(k-1).

    //A binomial tree of height 0 is a one node tree.
    //Etc.

    //The following is an illustration while inserting lists.
    //B(0)  B(1)     B(2)            B(3)                      B(4)
    // []    []        []              []                      [         ]
    //         \        \             \ \  \                   \  \  \   \
    //           []     []   []       [] [] []                 [] [] []  []
    //                         \          \   \ \                  \  \\  \\\
    //                          []         []  [] []               [] [][] [][][]
    //                                              \                     \  \ \ \
    //                                               []                   []   [][][]
    //                                                                              \
    //                                                                               []
    //You can see the pattern of how this tree builds off a new point starting at the second row where they increase by k, which is the height,
    // And how the remaining nodes created below are k-1 where they branch off from the node point at the height
    //(second row, and the nodes created below follow the same patern of the previous k heights.

    //Binomial trees of height k have exactly 2(**k) nodes.
    //The number of nodes at depth d is the binomial coefficient (k/d).

    //Binomial Queue Operations
    //We need to discuss the three main operations of the binomial queues.

    //Merging
    //Merging is an easy operation
    //We will use an example.

    //We consider the following binomial queues
    // H(1)[16]     [12]           H(2)      [13][14]       [23]
    //       \        \  \                          \         \ \
    //       [18]   [21][24]                        [26]     [51][24]
    //                    \                                        \
    //                    [65]                                     [65]

    // We define H_3) the new binomial queue.
    //We need to take care of the B(0)
    //H(1) does not have a binomial tree of height 0
    //H(2) does, so we can just add it to H(3)
    //H(3)  [13]
    //Now we consider the binomial tree of height 1
    //H(1) and H(2) have binomial trees of height 1
    //We merge them by making the larger root a subtree of the smaller tree.
    //We obtain a binomial tree of height 2.
    // [14]
    // \   \
    // [26] [16]
    //        \
    //       [18]

    //There are now three binomial trees of height 2.
    //We keep one binomial tree of height 2 and merge the other two.

    //H(3):  [13]         [23]                 [   12    ]
    //                     \  \                \  \   \
    //                     [51][24]            [21][24][14]
    //                            \                  \   \\
    //                           [65]               [65][26][16]
    //                                                        \
    //                                                        [18]

    //Since H(1) and H(2) have no trees of height 3 we stop there.

    //Insert

    //Insertion is a special case of merging.
    //We create a one-node tree (tree of height 0) and perform a merge.
    //The worst-case time of this operation is O(log N)

    //In this example, we will insert the integers from 1 to 7 to an empty binomial queue.
    //we start by inserting 1
    //  [1]
    //Now we insert 2
    // [1]
    //  \
    //  [2]
    //Now we insert 3
    //[3]  [1]
    //       \
    //       [2]
    //We now insert 4
    // [1]
    //   \ \
    //   [2][3]
    //         \
    //          [4]
    //Now we insert 5
    // [5]        [1]
    //             \ \
    //            [2][3]
    //                 \
    //                 [4]
    //Now we insert 6
    // [5]        [1]
    //   \         \ \
    //   [6]      [2][3]
    //                 \
    //                 [4]
    //Now we insert 7
    // [7]   [5]        [1]
    //         \         \ \
    //          [6]      [2][3]
    //                        \
    //                        [4]

    //DeleteMin
    //Consider a binomial queue denoted H.
    //Delete the minimum element by finding the smallest root
    //Let this tree be B(k)
    //Remove it from H, creating a new queue H'.
    //Remove the root of B(k)
    //It creates binomial trees B(0), B(1),...., B(k-1), in a queue H".
    //Merge H' and H".


    //Consider the following binomial queue H.
    //We want to remove the smallest element(12)
    //H(3):  [13]         [23]                 [   12    ]
    //                     \  \                \  \   \
    //                     [51][24]            [21][24][14]
    //                            \                  \   \\
    //                           [65]               [65][26][16]
    //                                                        \
    //                                                        [18]
    //We remove B(3) from H creating H'
    // //H':  [13]         [23]
    //    //                   \  \
    //    //                  [51][24]
    //    //                         \
    //    //                         [65]
    //We obtain H" the binominal queue creating after deleting 12 from B(3)
    // [21]  [24]       [14]
    //         \        \  \
    //         [65]     [26][16]
    //                        \
    //                        [18]
    //We are merging H' and H".
    // [23]       [   13  ]
    //  \  \       \  \   \
    //  [51][24]   [21][24][14]
    //        \          \    \ \
    //        [65]       [65] [26][16]
    //                               \
    //                               [18]


//
//
   //Exercise 2:
    // Prove that a binomial tree, b(k), by induction, that b(0), b(1), b(k-1) are children of the root
    // k = 1 is true
    //For 1 to k.... k.
    //Assume that it is true
    //B(k) contains every binomial tree b(0)... b(k-1)
    //For k+1 (induction) trying to attach the binary tree of size k to the other binary tree size k
    //We attach a new tree B(k) to the actual tree creating B(k+1)
    //We had every tree to b(0) to b(k-1), then we attach the new b(k)
    //Thus every tree from b(0) to b(k)

    //Exercise 3:
    // Depth goes down, and height goes up
    //Base case is 1
    //Depth is 1, whereas height is 1, meaning 1 is true
    //For k + 1(induction) We form a tree b(k+1) by attaching a tree b(k) to
    //the root of the previous tree of size k
    //At depth d we had (k/d) nodes with b(k), them we added (k/d-1),
    //We put it one depth lower when we put a new tree.
    // Imagine we add b(1) to a tree of b(1), we add that to the root, whereas
    //the increased depth is only one node (depth-1)
    // We now need to add (k/d) + (k/d-1) = (k+1/d)<--- the number of nodes at depth d

    //For proof, we assume base case is true then for 1-k assume it is all true.






}
