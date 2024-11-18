package node;

import java.util.LinkedList;
import java.util.Queue;

public class AVL extends BST<T extends Comparable<T>> {
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

        // Debug statement
        System.out.println("Balancing node: " + node.getValue() + " with balance factor: " + balanceFactor);

        // Se o nó estiver desbalanceado à esquerda
        if (balanceFactor > 1) {
            if (getBalance(node.getLeft()) < 0) {
                System.out.println("Left-Right case");
                node.setLeft(rotateLeft(node.getLeft()));
            }
            System.out.println("Left-Left case");
            return rotateRight(node);
        }

        // Se o nó estiver desbalanceado à direita
        if (balanceFactor < -1) {
            if (getBalance(node.getRight()) > 0) {
                System.out.println("Right-Left case");
                node.setRight(rotateRight(node.getRight()));
            }
            System.out.println("Right-Right case");
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
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        printTree(root, 0);
    }

    private void printTree(Node<T> node, int level) {
        if (node == null) return;

        printTree(node.getRight(), level + 1);
        System.out.println(" ".repeat(level * 4) + node.getValue());
        printTree(node.getLeft(), level + 1);
    }

    // Verifica se a árvore está balanceada
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<T> node) {
        if (node == null) return true;
        int balanceFactor = getBalance(node);
        return Math.abs(balanceFactor) <= 1 && isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }

    public static void main(String[] args) {
        AVL<Integer> avlTree = new AVL<>();
        
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        System.out.println("root:" + avlTree.root.getValue()); 
        System.out.println("AVL Tree:");
        avlTree.printTree();

        System.out.println("Is the tree balanced? " + avlTree.isBalanced());
    }
}
