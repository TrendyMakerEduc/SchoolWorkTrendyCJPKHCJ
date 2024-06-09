//Name  : Daniel Trenholm
//ID    : 201202966
//Email : x2012cml@stfx.ca

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedPriorityQueueTest {

    private PriorityQueue<String> classUnderTest;
    private PriorityQueue<String> preState;

    @BeforeEach
    void newPriorityQueue() {
        classUnderTest = new LinkedPriorityQueue<>();
        preState = new LinkedPriorityQueue<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void enqueue_noPriority_returnsTrue() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            queue.enqueue("A");
        }

        @Test
        void enqueue_priority_returnsTrue() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            queue.enqueue("A");
        }

        @Test
        void enqueue_noPriority_updatesFront() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            queue.enqueue("A");
            assertEquals("A", queue.first());
        }

        @Test
        void dequeue_empty_throwException() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            Throwable exception = assertThrows(NoSuchElementException.class, () -> queue.dequeue());
            assertEquals("Empty queue!", exception.getMessage());
        }

        @Test
        void first_empty_throwException() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            Throwable exception = assertThrows(NoSuchElementException.class, () -> queue.first());
            assertEquals("Empty queue!", exception.getMessage());
        }

        @Test
        void isEmpty_empty_returnsTrue() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            assertEquals(true, queue.isEmpty());
        }

        @Test
        void size_empty_returnsZero() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            assertEquals(0 , queue.size());
        }

        @Test
        void toString_empty_stringFront() {
            PriorityQueue queue = new LinkedPriorityQueue<>();
            assertEquals("", queue.toString());
        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void enqueueSingleElement() {
                classUnderTest.enqueue("C", 10);
                preState.enqueue("C", 10);
            }

            @Test
            void enqueue_noPriority_returnsTrue() {
                classUnderTest.enqueue("A");
                preState.enqueue("A");
            }

            @Test
            void enqueue_priority_returnsTrue() {
                assertEquals(true, classUnderTest.enqueue("A", 0));
            }

            @Test
            void enqueue_noPriority_unchangedFront() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A");
                queue.enqueue("B");
                assertEquals("A", queue.first());
            }

            @Test
            void enqueue_lowerPriority_updatesFront() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                queue.enqueue("B", 0);
                assertEquals("B", queue.first());

            }

            @Test
            void enqueue_higherPriority_unchangedFront() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 0);
                queue.enqueue("B", 1);
                assertEquals("A", queue.first());
            }

            @Test
            void dequeue_singleton_returnsFront() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 0);
                assertEquals("A", queue.dequeue());
            }

            @Test
            void dequeue_singleton_emptyPriorityQueue() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                queue.enqueue("B", 0);
                queue.dequeue();
                queue.dequeue();
                assertEquals(true , queue.isEmpty());

            }

            @Test
            void first_singleton_returnsFront() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                queue.enqueue("B", 0);
                assertEquals("B", queue.first());
            }

            @Test
            void first_singleton_unchanged() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                queue.enqueue("B", 0);

            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                queue.enqueue("B", 0);
                assertEquals(false, queue.isEmpty());
            }

            @Test
            void size_singleton_returnsOne() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                assertEquals(1, queue.size());
            }

            @Test
            void toString_singleton_correctString() {
                PriorityQueue queue = new LinkedPriorityQueue<>();
                queue.enqueue("A", 1);
                assertEquals("(A, (p:1, d:A))  ", queue.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void enqueueMoreElements() {
                    // Order should be A, B, C, D, E
                    classUnderTest.enqueue("A", 0);
                    classUnderTest.enqueue("E", 20);
                    classUnderTest.enqueue("B", 5);
                    classUnderTest.enqueue("D", 15);
                    preState.enqueue("A", 0);
                    preState.enqueue("E", 20);
                    preState.enqueue("B", 5);
                    preState.enqueue("D", 15);
                }

                @Test
                void enqueue_noPriority_returnsTrue() {
                    assertEquals(true, classUnderTest.enqueue("A", 0));

                }

                @Test
                void enqueue_priority_returnsTrue() {
                    classUnderTest.enqueue("A", 1);
                }

                @Test
                void enqueue_noPriority_unchangedFront() {
                    LinkedPriorityQueue<String> queue = new LinkedPriorityQueue<>();
                    queue.enqueue("A");
                    assertEquals(queue.first(), "A" );
                }

                @Test
                void enqueue_lowerPriority_updatesFront() {
                    LinkedPriorityQueue<String> queue = new LinkedPriorityQueue<>();
                    queue.enqueue("A", 1);
                    queue.enqueue("B", 0);
                    assertEquals(queue.first(), "B" );
                }

                @Test
                void enqueue_higherPriority_unchangedFront() {
                    LinkedPriorityQueue<String> queue = new LinkedPriorityQueue<>();
                    queue.enqueue("A", 1);
                    queue.enqueue("B", 2);
                    assertEquals(queue.first(), "A" );
                }

                @Test
                void dequeue_many_returnsElementsInCorrectSequence() {
                    assertEquals("A", classUnderTest.dequeue());
                    assertEquals("D", classUnderTest.dequeue());
                }

                @Test
                void dequeue_many_changedPriorityQueue() {
                    assertEquals("A", classUnderTest.dequeue());
                    assertEquals("D", classUnderTest.dequeue());
                }


                @Test
                void first_many_returnsLowestPriorityData() {
                    classUnderTest.enqueue("A", 0);
                    classUnderTest.enqueue("E", 20);
                    classUnderTest.enqueue("B", -5);
                    classUnderTest.enqueue("D", 15);
                    assertEquals("B", classUnderTest.first());
                }

                @Test
                void first_many_unchanged() {
                    assertEquals("A", classUnderTest.first());
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertEquals(false, classUnderTest.isEmpty());
                }

                @Test
                void size_many_returnsFive() {
                    assertEquals(5, classUnderTest.size());
                }


                @Test
                void toString_many_correctString() {
                    assertEquals("(A, (p:0, d:A))  (D, (p:15, d:D))  ", classUnderTest.toString());
                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicatePriorities {

                @BeforeEach
                void enqueueMoreElements() {
                    // Order should be one of:
                    //      A, B, C, D, E, F
                    //      A, B, C, E, D, F
                    //      A, B, D, C, E, F
                    //      A, B, D, E, C, F
                    //      A, B, E, C, D, F
                    //      A, B, E, D, C, F
                    classUnderTest.enqueue("A", 0);
                    classUnderTest.enqueue("D", 10);
                    classUnderTest.enqueue("B", 5);
                    classUnderTest.enqueue("E", 10);
                    classUnderTest.enqueue("F", 15);
                    preState.enqueue("A", 0);
                    preState.enqueue("D", 10);
                    preState.enqueue("B", 5);
                    preState.enqueue("E", 10);
                    preState.enqueue("F", 15);
                }

                @Test
                void dequeue_duplicates_returnsElementsInCorrectSequence() {

                }
            }
        }
    }
}

