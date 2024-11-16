package node;

public class Main {
    public static void main(String[] args) {
        // Criando os municípios
        Municipio municipio1 = new Municipio("001", "Municipio A", "Regiao 1", 100000, 0.8);
        Municipio municipio2 = new Municipio("002", "Municipio B", "Regiao 2", 200000, 1.2);
        Municipio municipio3 = new Municipio("003", "Municipio C", "Regiao 3", 300000, 0.5);
        Municipio municipio4 = new Municipio("004", "Municipio D", "Regiao 2", 150000, 0.7);

        // Criando a árvore AVL
        AVL avl = new AVL(null);

        // Inserindo os municípios
        System.out.println("Inserindo municipios na arvore AVL...");
        avl.insert(municipio1);
        avl.insert(municipio2);
        avl.insert(municipio3);
        avl.insert(municipio4);

        // Exibindo a estrutura da árvore
        System.out.println("\nEstrutura da Arvore AVL apos insercao:");
        avl.printTree();

        // Exibindo as informações detalhadas dos nós
        System.out.println("\nInformacoes dos nos da Arvore AVL:");
        avl.printInfo();

        // Deletando um município
        System.out.println("\nDeletando Municipio A...");
        avl.delete(municipio1);

        // Exibindo a estrutura da árvore após deleção
        System.out.println("\nEstrutura da Arvore AVL apos delecao de Municipio A:");
        avl.printTree();

        // Exibindo as informações detalhadas dos nós após deleção
        System.out.println("\nInformacoes dos nos da Arvore AVL apos delecao:");
        avl.printInfo();

        // Deletando outro município
        System.out.println("\nDeletando Municipio B...");
        avl.delete(municipio2);

        // Exibindo a estrutura da árvore após a segunda deleção
        System.out.println("\nEstrutura da Arvore AVL apos delecao de Municipio B:");
        avl.printTree();

        // Exibindo as informações detalhadas dos nós após a segunda deleção
        System.out.println("\nInformacoes dos nos da Arvore AVL apos a segunda delecao:");
        avl.printInfo();
    }
}

