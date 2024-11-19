public class Municipio {
    private String nome; // Nome do município
    private int pesPbf;  // Número de pessoas beneficiárias do Bolsa Família
    private int pesCad;  // Número de pessoas inscritas no Cadastro Único
    private double fPbfDomi;  // Participação das famílias beneficiárias no total de domicílios
    private int fPbfEp;  // Número de famílias com renda até R$ 218
    private double fCadEp;  // Número de famílias com renda até R$ 218 no CadÚnico

    // Construtor
    public Municipio(String nome, int pesPbf, int pesCad, double fPbfDomi, int fPbfEp, double fCadEp) {
        this.nome = nome;
        this.pesPbf = pesPbf;
        this.pesCad = pesCad;
        this.fPbfDomi = fPbfDomi;
        this.fPbfEp = fPbfEp;
        this.fCadEp = fCadEp;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPesPbf() {
        return pesPbf;
    }

    public void setPesPbf(int pesPbf) {
        this.pesPbf = pesPbf;
    }

    public int getPesCad() {
        return pesCad;
    }

    public void setPesCad(int pesCad) {
        this.pesCad = pesCad;
    }

    public double getfPbfDomi() {
        return fPbfDomi;
    }

    public void setfPbfDomi(double fPbfDomi) {
        this.fPbfDomi = fPbfDomi;
    }

    public int getfPbfEp() {
        return fPbfEp;
    }

    public void setfPbfEp(int fPbfEp) {
        this.fPbfEp = fPbfEp;
    }

    public double getfCadEp() {
        return fCadEp;
    }

    public void setfCadEp(double fCadEp) {
        this.fCadEp = fCadEp;
    }

    // Método para representar o objeto como uma String
    @Override
    public String toString() {
        return "Município: " + nome + "\n" +
               "Pessoas PBF: " + pesPbf + "\n" +
               "Pessoas CadÚnico: " + pesCad + "\n" +
               "Participação no total de domicílios: " + fPbfDomi + "\n" +
               "Famílias com renda até R$ 218 (PBF): " + fPbfEp + "\n" +
               "Famílias com renda até R$ 218 (CadÚnico): " + fCadEp;
    }
}
