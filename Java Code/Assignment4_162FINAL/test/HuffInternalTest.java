//NAME: Daniel Trenholm
//STFX ID: 201202966
//STFX EMAIL: x2012cml@stfx.ca

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HuffInternalTest {

    private static final HuffmanInternal LEFT_CHILD_INTERNAL = new HuffmanInternal(10, null, null);
    private static final HuffmanLeaf RIGHT_CHILD_LEAF = new HuffmanLeaf(10, 'a');

    private HuffmanInternal classUnderTest;

    @Test
    void getWeight_onlyUseCase_returnsWeight() {
        assertEquals(10, LEFT_CHILD_INTERNAL.getWeight());
    }

    @Test
    void getLeft_leftChildInternal_returnsLeftChildInternalNode() {
        HuffmanNode c = new HuffmanLeaf(10, 'c');
        LEFT_CHILD_INTERNAL.setLeftSubTree(c);
        assertEquals(c, LEFT_CHILD_INTERNAL.getLeftSubtree());
    }

    @Test
    void getRight_rightChildLeaf_returnsRightChildLeafNode() {
        HuffmanNode c = new HuffmanLeaf(10, 'c');
        LEFT_CHILD_INTERNAL.setRightSubTree(c);
        assertEquals(c, LEFT_CHILD_INTERNAL.getRightSubtree());
    }

    @Test
    void getLeft_noLeftChild_returnsNull() {
    assertEquals(null, LEFT_CHILD_INTERNAL.getLeftSubtree());
    }

    @Test
    void getRight_noRightChild_returnsNull() {
        HuffmanInternal huff = new HuffmanInternal(null, null);
        assertEquals(null, huff.getRightSubtree());
    }

    @Test
    void toString_onlyUseCase_returnsString() {
        assertEquals("Weight: 10. ", LEFT_CHILD_INTERNAL.toString());
    }
}
