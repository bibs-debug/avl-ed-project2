package main.java;

public class TreeNode {
    protected Municipio municipio;  
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(Municipio municipio) {
        this.municipio = municipio;
        this.left = null;
        this.right = null;
    }
}

