public class AVL extends BST {

    @Override
    protected TreeNode createNode(int codMun, String nome, String referencia, int pesPBF, int pesCad, double fPBFDomi, int fPBFEp, double fCADEp) {
        return new AVLNode(codMun, nome, referencia, pesPBF, pesCad, fPBFDomi, fPBFEp, fCADEp);
    }

    @Override
    protected TreeNode insertRec(TreeNode node, TreeNode newNode) {
        // Realiza a inserção normal da BST
        node = super.insertRec(node, newNode);

        // Adiciona lógica de balanceamento
        return balance((AVLNode) node);
    }

    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = getHeight(node.left) - getHeight(node.right);

        // Caso de rotação à direita
        if (balanceFactor > 1 && getHeight(node.left.left) >= getHeight(node.left.right)) {
            return rotateRight(node);
        }

        // Caso de rotação à esquerda
        if (balanceFactor < -1 && getHeight(node.right.right) >= getHeight(node.right.left)) {
            return rotateLeft(node);
        }

        // Caso de rotação esquerda-direita
        if (balanceFactor > 1 && getHeight(node.left.left) < getHeight(node.left.right)) {
            node.left = rotateLeft((AVLNode) node.left);
            return rotateRight(node);
        }

        // Caso de rotação direita-esquerda
        if (balanceFactor < -1 && getHeight(node.right.right) < getHeight(node.right.left)) {
            node.right = rotateRight((AVLNode) node.right);
            return rotateLeft(node);
        }

        updateHeight(node);
        return node;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return ((AVLNode) node).height;
    }

    private void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = (AVLNode) y.left;
        AVLNode T = (AVLNode) x.right;

        x.right = y;
        y.left = T;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private AVLNode rotateLeft(AVLNode y) {
        AVLNode x = (AVLNode) y.right;
        AVLNode T = (AVLNode) x.left;

        x.left = y;
        y.right = T;

        updateHeight(y);
        updateHeight(x);

        return x;
    }
}
