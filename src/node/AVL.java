package node;

public class AVL extends BST<Municipio> {

    public AVL(Node<Municipio> node) {
        super(node);
    }

    @Override
    public Node<Municipio> insert(Node<Municipio> node, Municipio municipio) {
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

    @Override
    public Node<Municipio> delete(Node<Municipio> node, Municipio municipio) {
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
                Node<Municipio> temp = getMinValueNode(node.getRight());
                node.setValue(temp.getValue());
                node.setRight(delete(node.getRight(), temp.getValue()));
            }
        }
        return balance(node);
    }

    private Node<Municipio> balance(Node<Municipio> node) {
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
            return rotateLeft(node);
        }

        return node;
    }

    private int getBalanceFactor(Node<Municipio> node) {
        return (node == null) ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    private void updateHeight(Node<Municipio> node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    private int height(Node<Municipio> node) {
        return (node == null) ? -1 : node.getHeight();
    }

    private Node<Municipio> rotateRight(Node<Municipio> y) {
        Node<Municipio> x = y.getLeft();
        Node<Municipio> T2 = x.getRight();
        
        x.setRight(y);
        y.setLeft(T2);

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node<Municipio> rotateLeft(Node<Municipio> x) {
        Node<Municipio> y = x.getRight();
        Node<Municipio> T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node<Municipio> getMinValueNode(Node<Municipio> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
