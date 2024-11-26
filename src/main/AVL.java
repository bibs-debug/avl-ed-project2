package main;

public class AVL extends BST {

    protected TreeNode createNode(Municipio municipio) {
        return new AVLNode(municipio);  
    }

    protected TreeNode insertRec(TreeNode node, Municipio municipio) {
        node = super.insertRec(node, municipio);
        return balance((AVLNode) node);  
    } 

    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = getHeight(node.left) - getHeight(node.right);

        if (balanceFactor > 1 && getHeight(node.left.left) >= getHeight(node.left.right)) {
            return rotateRight(node);
        }

        if (balanceFactor < -1 && getHeight(node.right.right) >= getHeight(node.right.left)) {
            return rotateLeft(node);
        }

        if (balanceFactor > 1 && getHeight(node.left.left) < getHeight(node.left.right)) {
            node.left = rotateLeft((AVLNode) node.left);
            return rotateRight(node);
        }

        if (balanceFactor < -1 && getHeight(node.right.right) < getHeight(node.right.left)) {
            node.right = rotateRight((AVLNode) node.right);
            return rotateLeft(node);
        }

        updateHeight(node);
        return node;
    }

    public TreeNode remove(long codMun) {
        root = removeRec(root, codMun);
        return root;
    }

    private TreeNode removeRec(TreeNode node, long codMun) {
        if (node == null) {
            return node;
        }

        // Busca o nó a ser removido
        if (codMun < node.municipio.getCodMun()) {
            node.left = removeRec(node.left, codMun);
        } else if (codMun > node.municipio.getCodMun()) {
            node.right = removeRec(node.right, codMun);
        } else {  // Se encontrou o nó
            if (node.left == null || node.right == null) {  // Caso com um ou nenhum filho
                node = (node.left == null) ? node.right : node.left;
            } else {  // Caso com dois filhos
                // Encontra o sucessor in-order (menor na subárvore direita)
                node.municipio = minValue(node.right).municipio;
                node.right = removeRec(node.right, node.municipio.getCodMun());
            }
        }
        if (node == null) {
            return node;
        }

        // Atualiza a altura do nó atual
        updateHeight((AVLNode) node);

        // Balanceia a árvore
        return balance((AVLNode) node);
    }

    private TreeNode minValue(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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
}
