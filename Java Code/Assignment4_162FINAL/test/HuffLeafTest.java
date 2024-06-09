//NAME: Daniel Trenholm
//STFX ID: 201202966
//STFX EMAIL: x2012cml@stfx.ca

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HuffLeafTest {

    private HuffmanLeaf classUnderTest = new HuffmanLeaf(10, 'c');

    @Test
    void getWeight_onlyUseCase_returnsWeight() {
        assertEquals(10, classUnderTest.getWeight());
    }

    @Test
    void getCharacter_lowerCaseCharacter_returnsLowerCaseCharacter() {
        assertEquals('c', classUnderTest.getCharacter());
    }

    @Test
    void getCharacter_upperCaseCharacter_returnsLowerCaseCharacter() {
        HuffmanLeaf c = new HuffmanLeaf(10, 'C');
        assertEquals('c', c.getCharacter());
    }

    @Test
    void toString_onlyUseCase_returnsString() {
        assertEquals("Weight: 10. Character: c", classUnderTest.toString());
    }

}
