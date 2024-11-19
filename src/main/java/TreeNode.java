public class TreeNode {
    protected int codMun;
    protected String nome;
    protected String referencia;
    protected int pesPBF;
    protected int pesCad;
    protected double fPBFDomi;
    protected int fPBFEp;
    protected double fCADEp;

    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(int codMun, String nome, String referencia, int pesPBF, int pesCad, double fPBFDomi, int fPBFEp, double fCADEp) {
        this.codMun = codMun;
        this.nome = nome;
        this.referencia = referencia;
        this.pesPBF = pesPBF;
        this.pesCad = pesCad;
        this.fPBFDomi = fPBFDomi;
        this.fPBFEp = fPBFEp;
        this.fCADEp = fCADEp;
        this.left = null;
        this.right = null;
    }
}
