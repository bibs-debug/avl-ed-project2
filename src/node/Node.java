package node;

public class Node<T> {

    private T value;  // O valor armazenado no nó (no caso, um Municipio)
    private Node<T> left;  // Filho à esquerda
    private Node<T> right; // Filho à direita
    private int height;    // A altura do nó, usada para balanceamento da árvore AVL

    // Construtor
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 0; // A altura do nó é inicialmente 0
    }

    // Getters e Setters
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Verifica se o nó é uma folha (não tem filhos)
    public boolean isLeaf() {
        return left == null && right == null;
    }

    // Atualiza a altura do nó com base nos filhos
    public void updateHeight() {
        this.height = 1 + Math.max(
            (left == null ? -1 : left.getHeight()),
            (right == null ? -1 : right.getHeight())
        );
    }
}
