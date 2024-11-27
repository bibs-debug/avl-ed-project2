package main;

public class AVLNode extends TreeNode {
    protected int height;

    public AVLNode(Municipio municipio) {
        super(municipio);
        this.height = 1;  
    }
}
  