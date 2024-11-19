public class Main {
    public static void main(String[] args) {
        System.out.println("Teste com BST:");
        BST bst = new BST();
        bst.insert(30, "A", "", 0, 0, 0.0, 0, 0.0);
        bst.insert(20, "B", "", 0, 0, 0.0, 0, 0.0);
        bst.insert(40, "C", "", 0, 0, 0.0, 0, 0.0);
        bst.insert(10, "D", "", 0, 0, 0.0, 0, 0.0);
        bst.insert(25, "E", "", 0, 0, 0.0, 0, 0.0);

        bst.inOrderTraversal();

        System.out.println("\nBST Tree Structure:");
        bst.printTree();

        System.out.println("\nTeste com AVL:");
        AVL avl = new AVL();
        avl.insert(30, "A", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(20, "B", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(40, "C", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(10, "D", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(25, "E", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(15, "G", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(17, "I", "", 0, 0, 0.0, 0, 0.0);
        avl.insert(22, "O", "", 0, 0, 0.0, 0, 0.0);

        avl.inOrderTraversal();

        System.out.println("\nAVL Tree Structure:");
        avl.printTree();

        String file_path = "src/main/resources/dataset/dataset_2020.csv";
        DatasetLoader.carregarDataset(file_path);
    }
}
