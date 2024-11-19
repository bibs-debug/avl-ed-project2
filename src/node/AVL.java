package node;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.Queue;

public class AVL extends BST<T extends Comparable<T>> {
    private Node<T> root;

=======
public class AVL<T extends Comparable<T>> extends BST<T> {
>>>>>>> 5abf69238c58bb2e95eeab513cc4bfb5cb9afea9
    public AVL() {
        super();
    }
    @Override
    public Node<T> insert(Node<T> node, T municipio) {
        if (node == null) {
            return new Node<>(municipio);
        } 
        if (municipio.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), municipio));
        } else if (municipio.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), municipio));
        } else {
            return node; 
        }
        return balance(node);
    }
<<<<<<< HEAD

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
=======
    @Override
    public Node<T> delete(Node<T> node, T municipio) {
        if (node == null) {
            return null;
        } 
        if (municipio.compareTo(node.getValue()) < 0) {
            node.setLeft(delete(node.getLeft(), municipio));
        } else if (municipio.compareTo(node.getValue()) > 0) {
            node.setRight(delete(node.getRight(), municipio));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            } else {
                Node<T> temp = getMinValueNode(node.getRight());
                node.setValue(temp.getValue());
                node.setRight(delete(node.getRight(), temp.getValue()));
            }
        }
        return balance(node);
    }
    private Node<T> balance(Node<T> node) {
        if (node == null) return null;
        
        updateHeight(node);
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) >= 0) {
            return rotateRight(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.getRight()) <= 0) {
            return rotateLeft(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
>>>>>>> 5abf69238c58bb2e95eeab513cc4bfb5cb9afea9
            return rotateLeft(node);
        }
        return node;
    }
    private int getBalanceFactor(Node<T> node) {
        return (node == null) ? 0 : height(node.getLeft()) - height(node.getRight());
    }
<<<<<<< HEAD

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
=======
    private void updateHeight(Node<T> node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }
    private int height(Node<T> node) {
        return (node == null) ? -1 : node.getHeight();
    }
    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.getLeft();
        Node<T> T2 = x.getRight();
        
        x.setRight(y);
        y.setLeft(T2);
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.getRight();
        Node<T> T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        updateHeight(x);
        updateHeight(y);
        return y;
    }
    private Node<T> getMinValueNode(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
>>>>>>> 5abf69238c58bb2e95eeab513cc4bfb5cb9afea9
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

