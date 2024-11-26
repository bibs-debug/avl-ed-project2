package main;

public class BST {
    protected TreeNode root;

    public void insert(Municipio municipio) {
        root = insertRec(root, municipio);
    }

    protected TreeNode insertRec(TreeNode root, Municipio municipio) {
        if (root == null) {
            root = new TreeNode(municipio);
            return root;
        }
        if (municipio.getCodMun() < root.municipio.getCodMun()) {
            root.left = insertRec(root.left, municipio);
        } else if (municipio.getCodMun() > root.municipio.getCodMun()) {
            root.right = insertRec(root.right, municipio);
        }
        return root;
    }

    public TreeNode search(long codMun) {
        return searchRec(root, codMun);
    }

    private TreeNode searchRec(TreeNode root, long codMun) {
        if (root == null || root.municipio.getCodMun() == codMun) {
            return root;
        }
        if (root.municipio.getCodMun() > codMun) {
            return searchRec(root.left, codMun);
        }
        return searchRec(root.right, codMun);
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

}
