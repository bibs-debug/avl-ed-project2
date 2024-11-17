package node;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
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
        return node;
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
