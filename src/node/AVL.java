package node;

public class AVL<T extends Comparable<T>> {
    private Node<T> root;

    public AVL() {
        this.root = null;
    }

    // Inserir valor na árvore
    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value));
        }

        // Atualiza a altura do nó
        updateHeight(node);

        // Balanceia a árvore
        return balance(node);
    }

    // Atualiza a altura do nó
    private void updateHeight(Node<T> node) {
        int leftHeight = (node.getLeft() != null) ? node.getLeft().getHeight() : 0;
        int rightHeight = (node.getRight() != null) ? node.getRight().getHeight() : 0;
        node.setHeight(1 + Math.max(leftHeight, rightHeight));
    }

    // Balanceamento da árvore
    private Node<T> balance(Node<T> node) {
        int balanceFactor = getBalance(node);

        // Se o nó estiver desbalanceado à esquerda
        if (balanceFactor > 1) {
            if (getBalance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }

        // Se o nó estiver desbalanceado à direita
        if (balanceFactor < -1) {
            if (getBalance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    // Calcula o fator de balanceamento do nó
    private int getBalance(Node<T> node) {
        if (node == null) return 0;
        return (node.getLeft() != null ? node.getLeft().getHeight() : 0) - (node.getRight() != null ? node.getRight().getHeight() : 0);
    }

    // Rotação à esquerda
    private Node<T> rotateLeft(Node<T> node) {
        Node<T> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    // Rotação à direita
    private Node<T> rotateRight(Node<T> node) {
        Node<T> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    // Função para imprimir a árvore em formato vertical
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node<T> node, int level) {
        if (node == null) return;

        // Primeiro imprime a subárvore direita
        printTree(node.getRight(), level + 1);

        // Imprime o nó atual com a indentação adequada
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.getValue());

        // Depois imprime a subárvore esquerda
        printTree(node.getLeft(), level + 1);
    }
}
