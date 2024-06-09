//NAME: Daniel Trenholm
//STFX ID: 201202966
//STFX EMAIL: x2012cml@stfx.ca

/**
 * A HuffmanInternal object is a HuffmanNode. These internal nodes contain reference to a left and right child
 * HuffmanNode along with an associated "weight". The weight is the sum of the weights of the child HuffmanNode objects.
 */
public class HuffmanInternal implements HuffmanNode {
    private final int weight;
    private HuffmanNode leftSubtree;
    private HuffmanNode rightSubTree;
    public int getWeight(){
        return weight;
    }

    public HuffmanNode getLeftSubtree(){
        return leftSubtree;
    }

    public HuffmanNode getRightSubtree(){
        return rightSubTree;
    }

    public HuffmanInternal(HuffmanNode leftSubtree, HuffmanNode rightSubTree)
    {
        if(leftSubtree != null || rightSubTree != null) {
            this.weight = leftSubtree.getWeight() + rightSubTree.getWeight();
        }
        else if(rightSubTree != null && leftSubtree == null){
            this.weight = rightSubTree.getWeight();
        }
        else if(rightSubTree == null && leftSubtree != null){
            this.weight = leftSubtree.getWeight();
        }
        else{
            this.weight = 0;
        }
        this.leftSubtree = leftSubtree;
        this.rightSubTree = rightSubTree;
    }
    public HuffmanInternal(int weight, HuffmanNode leftSubtree, HuffmanNode rightSubTree)
    {
        this.weight = weight;

        this.leftSubtree = leftSubtree;
        this.rightSubTree = rightSubTree;
    }


    public void setRightSubTree(HuffmanNode rightSubTree){
        this.rightSubTree = rightSubTree;
    }

    public void setLeftSubTree(HuffmanNode leftSubTree){
        this.leftSubtree = leftSubTree;
    }

    public String toString(){
        return String.format("Weight: %s. ", getWeight());
    }


}
