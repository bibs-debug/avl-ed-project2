package node;


public class Main {

    public static void main(String[] args) {
        // Criando a árvore AVL
        AVL<String> avl = new AVL<>();

        // Inserindo valores na árvore AVL
        String[] valores = {"D", "B", "A", "C", "F", "E", "H", "G"};
        
        System.out.println("### Testando a AVL ###");
        System.out.println("Inserindo valores: D, B, A, C, F, E, H, G");

        // Inserindo valores na AVL
        for (String valor : valores) {
            avl.insert(valor);
        }

        System.out.println("\nPré-ordem (AVL): ");
        avl.preOrderTraversal(avl.getNode());
        System.out.println();

        System.out.println("Em-ordem (AVL): ");
        avl.inOrderTraversal(avl.getNode());
        System.out.println();

        System.out.println("Pós-ordem (AVL): ");
        avl.postOrderTraversal(avl.getNode());
        System.out.println();

        // Removendo um nó da AVL
        System.out.println("\nRemovendo o nó 'C' da AVL...");
        avl.delete("C");

        System.out.println("\nApós remoção do nó 'C' (AVL): ");
        System.out.println("Pré-ordem (AVL): ");
        avl.preOrderTraversal(avl.getNode());
        System.out.println();

        System.out.println("Em-ordem (AVL): ");
        avl.inOrderTraversal(avl.getNode());
        System.out.println();

        System.out.println("Pós-ordem (AVL): ");
        avl.postOrderTraversal(avl.getNode());
        System.out.println();
    }
}
