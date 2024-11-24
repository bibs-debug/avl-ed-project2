package main.java;

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

        if (newNode.municipio.getNome().compareTo(node.municipio.getNome()) < 0) {
            node.left = insertRec(node.left, newNode);
        } else if (newNode.municipio.getNome().compareTo(node.municipio.getNome()) > 0) {
            node.right = insertRec(node.right, newNode);
        }

        return node;
    }

    public TreeNode search(String nome) {
        return searchRec(root, nome);
    }

    private TreeNode searchRec(TreeNode node, String nome) {
        if (node == null || node.municipio.getNome().equals(nome)) {
            return node;
        }

        comparacoes++;

        if (nome.compareTo(node.municipio.getNome()) < 0) {
            return searchRec(node.left, nome);
        } else {
            return searchRec(node.right, nome);
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

    public TreeNode remove(String nome) {
        return root = removeRec(root, nome);
    }

    private TreeNode removeRec(TreeNode node, String nome) {
        if (node == null) {
            return node;
        }

        comparacoes++;

        if (nome.compareTo(node.municipio.getNome()) < 0) {
            node.left = removeRec(node.left, nome);
        } else if (nome.compareTo(node.municipio.getNome()) > 0) {
            node.right = removeRec(node.right, nome);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.municipio = minValue(node.right);

            node.right = removeRec(node.right, node.municipio.getNome());
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
