//NAME: Daniel Trenholm
//STFX ID: 201202966
//STFX EMAIL: x2012cml@stfx.ca

public class Asn4 {
    private static final String RELATIVE_RESOURCES = "./resources/";

    public static void main(String[] args) {
        HuffmanCode huff = new HuffmanCode(new HuffmanInternal(null, null));
        String orrig = "hey how are you doing? Why not generate a seed base seed with all characters and numbers and everything else included";
        System.out.println(orrig); //Original String
        System.out.println("String bitsize: " + orrig.length() * 8 + " bits"); //The amount of memory in bits taken from the string

        System.out.println("...");
        huff.fromString("abcdddeeeeffffgggghiiiiiiiiijjjkkkkkklllmmmnnnaaaooopppqqqrrrssstttttttttttttuuuuvvvvvvwwwwwwxxxxxxxyyyyyyzzzzzzzz            !!!!!!?????????jjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhoooooooooooooooooooo");
        String a = huff.encode(orrig); //Encoded String


        huff.getHuffCodes(); //Generating codes from the HuffmanInternalTree.
        System.out.println(a); //Print Encoded String
        System.out.println("...");
        System.out.println("Encoded String bitsize: " + a.length() + " bits"); //Bits used for the Huffman

        System.out.println(huff.decode(a)); //Print decoded string

    }
}
