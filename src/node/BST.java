package node;

public class BST<T extends Comparable<T>> {
    
    protected Node<T> root;

    public BST() {
        this.root = null;
    }

    public BST(Node<T> node) {
        this.root = node;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    // Verifica se a árvore está vazia
    public boolean isEmpty() {
        return root == null;
    }

    // Retorna a altura de um nó
    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    // Atualiza a altura do nó após a inserção ou deleção
    private void updateHeight(Node<T> node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    // Inserção do valor na árvore
    public Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value));
        }

        // Atualiza a altura após a inserção
        updateHeight(node);
        return node;
    }

    // Deleção do nó
    public Node<T> delete(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        // Buscando o nó a ser deletado
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            // Caso o nó tenha 0 ou 1 filho
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            } else {
                // Caso o nó tenha 2 filhos, pega o sucessor
                Node<T> temp = getMinValueNode(node.getRight());
                node.setValue(temp.getValue());
                node.setRight(delete(node.getRight(), temp.getValue()));
            }
        }

        // Atualiza a altura após a deleção
        if (node != null) {
            updateHeight(node);
        }

        return node;
    }

    // Encontra o nó com o menor valor (sucessor)
    private Node<T> getMinValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    // Função para inserir diretamente na árvore
    public void insert(T value) {
        root = insert(root, value);
    }

    // Função para deletar diretamente na árvore
    public void delete(T value) {
        root = delete(root, value);
    }

    // Função para obter a altura da árvore
    public int getHeight() {
        return height(root);
    }

    public void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.println(node.getValue());
            inOrderTraversal(node.getRight());
        }
    }

    public void printTree() {
        System.out.println("Estrutura da Arvore:");
        printTree(this.root, "", false);
    }
    
    private void printTree(Node<T> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getValue());
            printTree(node.getLeft(), prefix + (isLeft ? "|   " : "    "), true);
            printTree(node.getRight(), prefix + (isLeft ? "|   " : "    "), false);
        }
    }
    
    public void printInfo() {
        System.out.println("Informacoes detalhadas dos nos:");
        printInfo(this.root);
    }
    
    private void printInfo(Node<T> node) {
        if (node != null) {
            printInfo(node.getLeft());
            System.out.println(node.getValue().toString());
            printInfo(node.getRight());
        }
    }
    
    
}

