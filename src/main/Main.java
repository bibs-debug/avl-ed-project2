package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Carregar dataset
        List<Municipio> municipios = DatasetLoader.carregarDataset("src/resources/dataset/dataset_2020_cleaned.csv");

        // Inserção na árvore
        for (Municipio municipio : municipios) {
            bst.insert(municipio);
        }

        // Busca na árvore
        TreeNode foundNode = bst.search(350100402); // Exemplo de busca
        if (foundNode != null) {
            System.out.println("Municipio encontrado: " + foundNode.municipio);
        } else {
            System.out.println("Municipio nao encontrado.");
        }

        // Comparação de desempenho entre AVL e BST
        Perfomance.compareInsertionPerformance(municipios);
        Perfomance.compareSearchPerformance(municipios);

        // Análise de dados
        long count = DataAnalysis.countMunicipiosWithMoreThanXPbf(municipios, 1000);
        System.out.println("Numero de municcpios com mais de 1000 pessoas no PBF: " + count);

        double maxFPbfDomi = DataAnalysis.maxFPbfDomi(municipios);
        System.out.println("Maior valor registrado no fPbfDomi: " + maxFPbfDomi);

        Municipio maxPesCadMunicipio = DataAnalysis.municipioWithMaxPesCad(municipios);
        System.out.println("Municipio com maior numero de pessoas no Cadastro unico: " + maxPesCadMunicipio.getNome());
    }
}