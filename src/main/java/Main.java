package main.java;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "c:/Projetos/uni/4 semester/estrutura de dados 2/avl-ed-project2/src/resources/dataset/dataset_2020.csv"; // add o meu caminho absoluto mas precisa alterar pra um caminho relativo
        //String filePath = "C:\\Users\\biabl\\OneDrive\\Documents\\EstruturadeDados\\avl-ed-project2\\src\\dataset\\\\dataset_2020.csv"; 
        List<Municipio> municipios = DatasetLoader.carregarDataset(filePath);
       
        BST bst = new BST();

        for (Municipio municipio : municipios) {
            bst.insert(municipio);
        }

        System.out.println("Arvore em ordem (inOrderTraversal):");
        bst.inOrderTraversal();

        String nomeMunicipioBusca = "Votorantim";
        TreeNode result = bst.search(nomeMunicipioBusca);
        if (result != null) {
            System.out.println("\nResultado da busca por '" + nomeMunicipioBusca + "': " + result.municipio);
        } else {
            System.out.println("\nMunicipio nao encontrado: " + nomeMunicipioBusca);
        }

        String nomeMunicipioRemover = "Rio de Janeiro";
        bst.remove(nomeMunicipioRemover);
        System.out.println("\nArvore apos remocao de '" + nomeMunicipioRemover + "':");
        bst.inOrderTraversal();
        System.out.println("\nNumero de comparacoes realizadas: " + bst.getComparacoes());
    }
}