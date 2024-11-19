public class BST {
    protected TreeNode root;

    public void insert(int codMun, String nome, String referencia, int pesPBF, int pesCad, double fPBFDomi, int fPBFEp, double fCADEp) {
        root = insertRec(root, createNode(codMun, nome, referencia, pesPBF, pesCad, fPBFDomi, fPBFEp, fCADEp));
    }

    protected TreeNode createNode(int codMun, String nome, String referencia, int pesPBF, int pesCad, double fPBFDomi, int fPBFEp, double fCADEp) {
        return new TreeNode(codMun, nome, referencia, pesPBF, pesCad, fPBFDomi, fPBFEp, fCADEp);
    }

    protected TreeNode insertRec(TreeNode node, TreeNode newNode) {
        if (node == null) {
            return newNode;
        }

        if (newNode.codMun < node.codMun) {
            node.left = insertRec(node.left, newNode);
        } else if (newNode.codMun > node.codMun) {
            node.right = insertRec(node.right, newNode);
        }

        return node;
    }

    public TreeNode search(int codMun) {
        return searchRec(root, codMun);
    }

    private TreeNode searchRec(TreeNode node, int codMun) {
        if (node == null || node.codMun == codMun) {
            return node;
        }

        if (codMun < node.codMun) {
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
            System.out.println("CodMun: " + node.codMun + ", Nome: " + node.nome);
            inOrderRec(node.right);
        }
    }

    public void printTree() {
        printTreeRec(root, "", true);
    }

    private void printTreeRec(TreeNode node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.codMun);
            printTreeRec(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTreeRec(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
