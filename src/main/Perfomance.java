package main;

import java.util.List;

public class Perfomance {

    public static void compareInsertionPerformance(List<Municipio> municipios) {
        AVL avl = new AVL();
        BST bst = new BST();

        long avlInsertTime = DataAnalysis.measureExecutionTime(() -> {
            for (Municipio municipio : municipios) {
                avl.insert(municipio);
            }
        });

        long bstInsertTime = DataAnalysis.measureExecutionTime(() -> {
            for (Municipio municipio : municipios) {
                bst.insert(municipio);
            }
        });

        System.out.println("Tempo de insercao AVL: " + avlInsertTime / 1_000_000_000.0 + " s");
        System.out.println("Tempo de insercao BST: " + bstInsertTime / 1_000_000_000.0 + " s");
    }

    public static void compareSearchPerformance(List<Municipio> municipios) {
        AVL avl = new AVL();
        BST bst = new BST();

        for (Municipio municipio : municipios) {
            avl.insert(municipio);
            bst.insert(municipio);
        }

        long avlSearchTime = DataAnalysis.measureExecutionTime(() -> {
            for (Municipio municipio : municipios) {
                avl.search(municipio.getCodMun());
            }
        });

        long bstSearchTime = DataAnalysis.measureExecutionTime(() -> {
            for (Municipio municipio : municipios) {
                bst.search(municipio.getCodMun());
            }
        });

        System.out.println("Tempo de busca AVL: " + avlSearchTime / 1_000_000_000.0 + " s");
        System.out.println("Tempo de busca BST: " + bstSearchTime / 1_000_000_000.0 + " s");
    }
}
