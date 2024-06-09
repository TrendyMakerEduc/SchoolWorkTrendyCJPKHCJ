//NAME: Daniel Trenholm
//STFX ID: 201202966
//STFX EMAIL: x2012cml@stfx.ca

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.*;

public class HuffmanCode  {

    /**
     * Generate the Huffman tree that can be used for encoding a String. The Huffman Tree is generated based on some
     * seed string. Ideally this string is large enough and real-ish enough to represent a good encoding for a given
     * message.
     *
     * @param seed Some seed string to use for generating the Huffman Tree
     * @return A HuffmanNode that is the root of the Huffman Tree
     */
    private static HuffmanNode root;

    private static Map<Character, Integer> characterFrequencies = new HashMap<>();
    private final Map<Character, String> huffmanCodes;
    private static String text;
    public static HuffmanCode fromString(String seed) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(5, new HuffmanNodeComparator());
        fillInMap(seed);
        for (Map.Entry<Character, Integer> entry : characterFrequencies.entrySet()) {
            HuffmanLeaf leaf = new HuffmanLeaf(entry.getValue(), entry.getKey());
            queue.add(leaf);
        }
        while (queue.size() > 1) {
            HuffmanNode n = queue.poll();
            HuffmanNode m = queue.poll();
            queue.add(new HuffmanInternal(n, m));
        }
        root = queue.poll();
        return new HuffmanCode(root);
    }

    public HuffmanCode(HuffmanNode root){
        huffmanCodes = new HashMap<>();
        this.root = root;
    }

    /**
     * Create a HuffmanCompression from a string within a text file.
     *
     * @param seedFile Filename of seed to load
     * @return A new HuffmanCompression object based on the seed file
     * @throws UncheckedIOException Any general UncheckedIOException
     */
    public static HuffmanCode fromFile(String seedFile) {
        try {
            return HuffmanCode.fromString(Files.readString(Paths.get(seedFile)));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Encode a given string based on the Huffman tree.
     *
     * @param string String to be encoded
     * @return Bitstring representing the encoded string
     */
    public String encode(String string) {
        text = string;
        generateHuffmanCodes(root, "");
        return getEncodedText();
    }



    public String getEncodedText(){
        StringBuilder sb = new StringBuilder();
        for(char character : text.toCharArray()){
            sb.append(huffmanCodes.get(character));
        }
        return sb.toString();
    }

    public void getHuffCodes(){
        Set<Map.Entry<Character, String>> actualValues = huffmanCodes.entrySet();
        System.out.println(actualValues);
    }

    private void generateHuffmanCodes(HuffmanNode node, String code){
        if(node instanceof HuffmanLeaf){
            huffmanCodes.put(((HuffmanLeaf) node).getCharacter(), code);
            return;
        }
        generateHuffmanCodes(((HuffmanInternal) node).getLeftSubtree(), code.concat("0"));
        generateHuffmanCodes(((HuffmanInternal) node).getRightSubtree(), code.concat("1"));

    }

    public String decode(String bits) {
        StringBuilder sb = new StringBuilder();
        HuffmanNode current = root;
        for(char character : bits.toCharArray()){
            current = character == '0' ? ((HuffmanInternal) current).getLeftSubtree() : ((HuffmanInternal) current).getRightSubtree();
            if(current instanceof HuffmanLeaf){
                sb.append(((HuffmanLeaf) current).getCharacter());
                current = root;
            }
        }
        return sb.toString();
    }

    private static void fillInMap(String string){
        characterFrequencies = new HashMap<>();
        for(char character : string.toCharArray()){
            Integer integer = characterFrequencies.get(character);
            characterFrequencies.put(character, integer != null ? integer : 1);
        }
    }
    }
