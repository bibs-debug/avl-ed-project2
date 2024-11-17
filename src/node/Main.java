package node;

public class Main {
    public static void main(String[] args) {
        // Testando a árvore BST
        System.out.println("arvore BST:");
        BST<Integer> bst = new BST<>();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.printTree(); // Imprime a árvore BST

        // Testando a árvore AVL
        System.out.println("\narvore AVL:");
        AVL<Integer> avl = new AVL<>();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        avl.printTree(); // Imprime a árvore AVL
    }
}
