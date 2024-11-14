public class AVL extends BST {

    //inicializa a AVL com um node raiz
    public AVL(Node root) {
        super(root);
    }

    //insere um novo municipio na AVL
    @Override
    public Node insert(Node node, Municipio municipio) {
        //base: se node nulo, cria um novo com o municipio
        if (node == null) {
            return new Node(municipio);
        }

        //insere
        if (municipio.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), municipio));
        } else if (municipio.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), municipio));
        } else {
            return node; //valor duplicado, nao insere
        }

        //balanceia a arvore apos a insercao e retorna node ajustado
        return balance(node);
    }

    //remover um municipio da arvore AVL
    @Override
    public Node delete(Node node, Municipio municipio) {
        //base: node nulo, nao remove
        if (node == null) {
            return null;
        }

        //busca o node a ser removido
        if (municipio.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), municipio));
        } else if (municipio.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), municipio));
        } else {
            //node encontrado
            if (node.getLeft() == null || node.getRight() == null) {
                //para node com um ou nenhum filho
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            } else {
                //para node com dois filhos - encontra o sucessor
                Node temp = getMinValueNode(node.getRight());
                node.setData(temp.getData());
                node.setRight(delete(node.getRight(), temp.getData()));
            }
        }

        //balanceia a AVL pos-remocao; retorna o node ajustado
        return balance(node);
    }

    //balanceia AVL pos-insercao ou remocao
    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        //atualiza a altura do node
        updateHeight(node);

        //fator de balanceamento
        int balanceFactor = getBalanceFactor(node);

        //rotacao simples direita
        if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) >= 0) {
            return rotateRight(node);
        }

        //rotacao dupla direita-esquerda
        if (balanceFactor > 1 && getBalanceFactor(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }

        //rotacao simples esquerda
        if (balanceFactor < -1 && getBalanceFactor(node.getRight()) <= 0) {
            return rotateLeft(node);
        }

        //rotacao dupla esquerda-direita
        if (balanceFactor < -1 && getBalanceFactor(node.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }

    //fator de balanceamento de um node
    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    //atualiza a altura
    private void updateHeight(Node node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    //altura, retornando -1 se o for nulo
    private int height(Node node) {
        return (node == null) ? -1 : node.getHeight();
    }

    //rotação direita para corrigir desbalanceamento
    private Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();
        
        x.setRight(y);
        y.setLeft(T2);

        updateHeight(y);
        updateHeight(x);

        return x; //nova raiz da subavore
    }

    //rotacao esquerda para corrigir desbalanceamento
    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    //node com menor valor em uma subarvore
    private Node getMinValueNode(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}