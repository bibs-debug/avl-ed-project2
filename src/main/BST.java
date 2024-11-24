package main;

public class BST {
    protected TreeNode root;
    protected int comparacoes = 0;

    public void insert(Municipio municipio) {

        root = insertRec(root, createNode(municipio));
    }

    protected TreeNode createNode(Municipio municipio) {
        return new TreeNode(municipio);  
    }

    protected TreeNode insertRec(TreeNode node, TreeNode newNode) {
        if (node == null) {
            return newNode;
        } 

        comparacoes++;

        if (newNode.municipio.getCodMun() < node.municipio.getCodMun()) {
            node.left = insertRec(node.left, newNode);
        } else if (newNode.municipio.getCodMun() > node.municipio.getCodMun()) {
            node.right = insertRec(node.right, newNode);
        }
        return node;
    }

    public TreeNode search(long codMun) {
        return searchRec(root, codMun);
    }
    
    private TreeNode searchRec(TreeNode node, long codMun) {
        if (node == null || node.municipio.getCodMun() == codMun) {
            return node;
        }
    
        comparacoes++;
    
        if (codMun < node.municipio.getCodMun()) {
            return searchRec(node.left, codMun);
        } else {
            return searchRec(node.right, codMun);

        }
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.municipio);
            inOrderRec(node.right);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.left);
        int rightHeight = getHeightRec(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode remove(long codMun) {
        return root = removeRec(root, codMun);
    }

    private TreeNode removeRec(TreeNode node, long codMun) {
        if (node == null) {
            return node;
        }

        comparacoes++;

        if (codMun < node.municipio.getCodMun()) {
            node.left = removeRec(node.left, codMun);
        } else if (codMun > node.municipio.getCodMun()) {
            node.right = removeRec(node.right, codMun);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
    
            node.municipio = minValue(node.right);
    
            node.right = removeRec(node.right, node.municipio.getCodMun());
        }
        return node;
    }

    private Municipio minValue(TreeNode node) {
        Municipio minValue = node.municipio;
        while (node.left != null) {
            node = node.left;
            minValue = node.municipio;
        }
        return minValue;
    }

    public int getComparacoes() {
        return comparacoes;
    }

}
