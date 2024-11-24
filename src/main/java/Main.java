package main.java;


// C:\Users\biabl\OneDrive\Documents\EstruturadeDados\avl-ed-project2\src\dataset\\dataset_2020.csv

import java.util.List;

public class Main {
    public static void main(String[] args) {
      
        String caminhoArquivo = "C:\\Users\\biabl\\OneDrive\\Documents\\EstruturadeDados\\avl-ed-project2\\src\\dataset\\\\dataset_2020.csv"; // Coloque o caminho correto do seu arquivo CSV
        List<Municipio> municipios = DatasetLoader.carregarDataset(caminhoArquivo);
       
        BST bst = new BST();

        for (Municipio municipio : municipios) {
            bst.insert(municipio);
        }

        System.out.println("Árvore em ordem (inOrderTraversal):");
        bst.inOrderTraversal();

        String nomeMunicipioBusca = "São Paulo";
        TreeNode result = bst.search(nomeMunicipioBusca);
        if (result != null) {
            System.out.println("\nResultado da busca por '" + nomeMunicipioBusca + "': " + result.municipio);
        } else {
            System.out.println("\nMunicípio não encontrado: " + nomeMunicipioBusca);
        }

        String nomeMunicipioRemover = "Rio de Janeiro";
        bst.remove(nomeMunicipioRemover);
        System.out.println("\nÁrvore após remoção de '" + nomeMunicipioRemover + "':");
        bst.inOrderTraversal();
        System.out.println("\nNúmero de comparações realizadas: " + bst.getComparacoes());
    }
}


/*import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Carregar o dataset
        String caminhoArquivo = "path_to_your_data.csv"; // Coloque o caminho correto do seu arquivo CSV
        List<Municipio> municipios = DatasetLoader.carregarDataset(caminhoArquivo);
        
        // Criar a árvore binária de busca (BST)
        BST bst = new BST();

        // Inserir os municípios na BST
        for (Municipio municipio : municipios) {
            bst.insert(municipio);
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\nMenu de Operações:");
            System.out.println("1. Buscar por Município");
            System.out.println("2. Remover Município");
            System.out.println("3. Filtrar Municípios com Participação no Bolsa Família acima de 10%");
            System.out.println("4. Quantidade de Municípios com Participação no Bolsa Família acima de 10%");
            System.out.println("5. Média de Participação do Bolsa Família");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer de entrada
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do município para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    TreeNode result = bst.search(nomeBusca);
                    if (result != null) {
                        System.out.println("\nResultado da busca: " + result.municipio);
                    } else {
                        System.out.println("\nMunicípio não encontrado: " + nomeBusca);
                    }
                    break;
                
                case 2:
                    System.out.print("Digite o nome do município para remover: ");
                    String nomeRemover = scanner.nextLine();
                    bst.remove(nomeRemover);
                    System.out.println("\nÁrvore após remoção de '" + nomeRemover + "'.");
                    break;
                
                case 3:
                    System.out.println("\nFiltrando municípios com participação do Bolsa Família acima de 10%...");
                    for (Municipio municipio : municipios) {
                        if (municipio.getPesPBF() > 10) {
                            System.out.println(municipio.getNome() + " - PBF: " + municipio.getPesPBF() + "%");
                        }
                    }
                    break;
                
                case 4:
                    long countAbove10 = municipios.stream()
                        .filter(municipio -> municipio.getPesPBF() > 10)
                        .count();
                    System.out.println("\nQuantidade de Municípios com Participação no Bolsa Família acima de 10%: " + countAbove10);
                    break;
                
                case 5:
                    double mediaPBF = municipios.stream()
                        .mapToDouble(Municipio::getPesPBF)
                        .average()
                        .orElse(0.0);
                    System.out.println("\nMédia de Participação do Bolsa Família: " + mediaPBF + "%");
                    break;
                
                case 6:
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        } while (opcao != 6);

        scanner.close();
    }
}
*/

/*public class Main {
    public static void main(String[] args) {
        
        String caminhoArquivoCSV = "C:\\Users\\biabl\\OneDrive\\Documents\\EstruturadeDados\\avl-ed-project2\\src\\dataset\\dataset_2020.csv"; // Caminho do arquivo
        
        List<Municipio> municipios = DatasetLoader.carregarDataset(caminhoArquivoCSV);
        
        if (municipios.isEmpty()) {
            System.out.println("Nenhum municipio foi carregado. Verifique o arquivo CSV.");
            return;
        }
        
        System.out.println("Dataset carregado com sucesso! " + municipios.size() + " municipios foram carregados.");

        // Insercao na arvore BST
        BST bst = new BST();
        long tempoInicioBST = System.nanoTime();
        for (Municipio municipio : municipios) {
            bst.insert(municipio);
        }
        long tempoFimBST = System.nanoTime();
        System.out.println("Insercao na arvore BST levou " + (tempoFimBST - tempoInicioBST) / 1000000 + " ms.");
        
        System.out.println("Altura da arvore BST: " + bst.getHeight());

        // Insercao na arvore AVL
        AVL avl = new AVL();
        long tempoInicioAVL = System.nanoTime();
        for (Municipio municipio : municipios) {
            avl.insert(municipio);
        }
        long tempoFimAVL = System.nanoTime();
        System.out.println("Insercao na arvore AVL levou " + (tempoFimAVL - tempoInicioAVL) / 1000000 + " ms.");
        
        System.out.println("Altura da arvore AVL: " + avl.getHeight());
    }
}
*/