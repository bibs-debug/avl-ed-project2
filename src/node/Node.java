package node;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;
    private int height;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

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

    public boolean isLeaf() {
        return left == null && right == null;
    }

    // Método para calcular o grau de um nó (quantidade de filhos)
    public int getDegree() {
        int degree = 0;
        if (this.left != null) {
            degree++;
        }
        if (this.right != null) {
            degree++;
        }
        return degree;
    }
}
