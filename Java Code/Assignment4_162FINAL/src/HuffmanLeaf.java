//NAME: Daniel Trenholm
//STFX ID: 201202966
//STFX EMAIL: x2012cml@stfx.ca

/**
 * A HuffmanLeaf object is a HuffmanNode. These leaf nodes contain characters being encoded/decoded along with an
 * associated "weight". This weight is the frequency of the given character within the string being encoded/decoded;
 * it is the number of times the character exists within the string.
 */
public class HuffmanLeaf implements HuffmanNode {
    private final int weight;
    private char character;

    public int getWeight(){
        return weight;
    }

    public char getCharacter(){
        return character;
    }

    public HuffmanLeaf(int weight, char character)
    {
        this.weight = weight;
        this.character = Character.toLowerCase(character);
    }

    public String toString(){
        return String.format("Weight: %s. Character: %s", getWeight(), getCharacter());
    }
}
