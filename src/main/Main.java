
 //"C:\\Users\\biabl\\OneDrive\\Documents\\EstruturadeDados\\avl-ed-project2-bia-lima\\avl-ed-project2-bia-lima\\src\\resources\\dataset\\\\dataset_2020.csv";
 package main;

 public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        
        // Criação de alguns objetos Municipio
        Municipio municipio1 = new Municipio(350100401, "São Paulo", 1000, 1500, 80.0, 1200, 50.0);
        Municipio municipio2 = new Municipio(350100402, "Rio de Janeiro", 2000, 2500, 75.0, 2200, 60.0);
        Municipio municipio3 = new Municipio(350100403, "Belo Horizonte", 500, 700, 85.0, 600, 45.0);

        // Inserção na árvore
        bst.insert(municipio1);
        bst.insert(municipio2);
        bst.insert(municipio3);
}
 }