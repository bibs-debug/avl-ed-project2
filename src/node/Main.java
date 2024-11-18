package node;

public class Main {

    // Metodo principal
    public static void main(String[] args) {
        // Criando alguns municipios para testar
        Municipio municipio1 = new Municipio(123, "Sao Paulo", "2020", 100, 50, 1.5, 30, 2.5);
        Municipio municipio2 = new Municipio(456, "Rio de Janeiro", "2020", 80, 40, 1.2, 25, 2.1);
        Municipio municipio3 = new Municipio(789, "Belo Horizonte", "2020", 90, 45, 1.3, 28, 2.3);

        // Criando a arvore BST
        BST<Municipio> bst = new BST<>();
        bst.insert(municipio1);
        bst.insert(municipio2);
        bst.insert(municipio3);

        // Exibir os valores na arvore BST (em ordem)
        System.out.println("Arvore BST (em ordem):");
        bst.inOrderTraversal(bst.getNode());  // Percurso em ordem para BST

        // Criando a arvore AVL
        AVL<Municipio> avl = new AVL<>();
        avl.insert(municipio1);
        avl.insert(municipio2);
        avl.insert(municipio3);

        // Exibir os valores na arvore AVL (em ordem)
        System.out.println("\nArvore AVL (em ordem):");
        avl.inOrderTraversal(avl.getNode());  // Percurso em ordem para AVL
    }
}
