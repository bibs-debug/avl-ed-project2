package node;

public class Municipio {
    private String nome; //nome do município
    private int pesPbf;  //numero de pessoas no Programa Bolsa Família (PBF) no municipio
    private int pesCad;  //numero de pessoas cadastradas no Cadastro Único (CadUnico)
    private double fPbfDomi;   //porcentagem: participacao do Bolsa Familia no total de domicilios do municipio 
    private int fPbfEp;  //mumero de familias com renda até R$ 218,00 que recebem o Bolsa Família
    private double fCadEp;  //porcentagem: numero de familias com renda ate R$ 218,00 no Cadastro unico

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

    @Override
    public String toString() {
        return nome + " - PBF: " + pesPbf + ", Cad: " + pesCad + ", FPF: " + fPbfDomi;
    }
}
