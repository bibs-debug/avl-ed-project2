
package node;

public class BST<T extends Comparable<T>> {
    
    protected Node<T> node;
    public BST() {
        this.node = null;
    }
    public BST(Node<T> node) {
        this.node = node;  
    }
    public Node<T> getNode() {
        return node;  
    }
    public void setNode(Node<T> node) {
        this.node = node;
    }
    // Verifica se a árvore está vazia
    public boolean isEmpty() {
        return node == null;
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
        node = insert(node, value);
    }
    // Função para deletar diretamente na árvore
    public void delete(T value) {
        node = delete(node, value);
    }
    // Função para obter a altura da árvore
    public int getHeight() {
        return height(node);
    }
        // Pré-ordem
    public void preOrderTraversal(Node<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + " "); // Imprime o valor na mesma linha
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    // Em-ordem
    public void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getValue() + " "); // Imprime o valor na mesma linha
            inOrderTraversal(node.getRight());
        }
    }

    // Pós-ordem
    public void postOrderTraversal(Node<T> node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getValue() + " "); // Imprime o valor na mesma linha
        }
    }
    
    public void printInfo() {
        System.out.println("Arvore:");
        printInfo(this.node);  // Chama a função para a árvore BST
    }
    
    private void printInfo(Node<T> node) {
        if (node != null) {
            // Primeiramente, visita o nó esquerdo
            printInfo(node.getLeft());
            
            // Depois, imprime o valor do nó atual na nova linha
            System.out.println(node.getValue()); // Aqui imprime o valor do nó em uma linha nova
            
            // Por fim, visita o nó direito
            printInfo(node.getRight());
        }
    }
  
}
