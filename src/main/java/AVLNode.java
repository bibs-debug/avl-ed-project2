public class AVLNode extends TreeNode {
    protected int height; // Atributo adicional para AVL

    public AVLNode(int codMun, String nome, String referencia, int pesPBF, int pesCad, double fPBFDomi, int fPBFEp, double fCADEp) {
        super(codMun, nome, referencia, pesPBF, pesCad, fPBFDomi, fPBFEp, fCADEp);
        this.height = 1; // Altura inicial do nó
    }
}
