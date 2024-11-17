package node;

public class Municipio implements Comparable<Municipio> {
    
    private int codMun;
    private String nome;
    private String referencia;
    private int pesPBF;
    private int pesCad;
    private double fPBFDomi;
    private int fPBFEp;
    private int fCADEp;

    // Construtor completo
    public Municipio(int codMun, String nome, String referencia, int pesPBF, int pesCad, double fPBFDomi, int fPBFEp, int fCADEp) {
        if (codMun <= 0) {
            throw new IllegalArgumentException("Codigo do municipio deve ser maior que zero.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do município não pode ser vazio.");
        }
        if (referencia == null || referencia.trim().isEmpty()) {
            throw new IllegalArgumentException("Referencia não pode ser vazia.");
        }
        if (pesPBF < 0 || pesCad < 0 || fPBFDomi < 0 || fPBFEp < 0 || fCADEp < 0) {
            throw new IllegalArgumentException("Pesos e valores não podem ser negativos.");
        }
        
        this.codMun = codMun;
        this.nome = nome;
        this.referencia = referencia;
        this.pesPBF = pesPBF;
        this.pesCad = pesCad;
        this.fPBFDomi = fPBFDomi;
        this.fPBFEp = fPBFEp;
        this.fCADEp = fCADEp;
    }

    // Método compareTo
    @Override
    public int compareTo(Municipio outro) {
        return Integer.compare(this.codMun, outro.codMun);
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "codMun=" + codMun +
                ", nome='" + nome + '\'' +
                ", referencia='" + referencia + '\'' +
                ", pesPBF=" + pesPBF +
                ", pesCad=" + pesCad +
                ", fPBFDomi=" + fPBFDomi +
                ", fPBFEp=" + fPBFEp +
                ", fCADEp=" + fCADEp +
                '}';
    }
}
