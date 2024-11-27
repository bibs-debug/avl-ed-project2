package main;
/*mudanca: 
- insercao de codMun
- validacao no construtor 
- compareTo*/
public class Municipio {
    private Long codMun;
    private String nome; //nome do município
    private int pesPbf;  //numero de pessoas no Programa Bolsa Família (PBF) no municipio
    private int pesCad;  //numero de pessoas cadastradas no Cadastro Único (CadUnico)
    private double fPbfDomi;   //porcentagem: participacao do Bolsa Familia no total de domicilios do municipio 
    private int fPbfEp;  //mumero de familias com renda até R$ 218,00 que recebem o Bolsa Família
    private double fCadEp;  //porcentagem: numero de familias com renda ate R$ 218,00 no Cadastro unico

    // Construtor
    public Municipio(long codMun,String nome, int pesPbf, int pesCad, double fPbfDomi, int fPbfEp, double fCadEp) {
        if (!isValidCodMun(codMun)) {
            throw new IllegalArgumentException("Código do município deve ser maior ou igual a 0");
        }

        if (!isValidNome(nome)) {
            throw new IllegalArgumentException("Nome do município inválido");
        }
        if (!isValidPesPbf(pesPbf)) {
            throw new IllegalArgumentException("Número de pessoas no PBF deve ser maior ou igual a 0");
        }
        if (!isValidPesCad(pesCad)) {
            throw new IllegalArgumentException("Número de pessoas no Cadastro Único deve ser maior ou igual a 0");
        }
        if (!isValidFPbfDomi(fPbfDomi)) {
            throw new IllegalArgumentException("Porcentagem de participação do PBF no total de domicílios deve ser entre 0 e 100");
        }
        if (!isValidFPbfEp(fPbfEp)) {
            throw new IllegalArgumentException("Número de famílias com renda até R$ 218,00 deve ser maior ou igual a 0");
        }
        /*if (!isValidFCadEp(fCadEp)) {
            throw new IllegalArgumentException("Porcentagem de famílias com renda até R$ 218,00 no Cadastro Único deve ser entre 0 e 100");
        }
        */
        this.codMun = codMun; // Ensure codMun is initialized
        this.nome = nome;
        this.pesPbf = pesPbf;
        this.pesCad = pesCad;
        this.fPbfDomi = fPbfDomi;
        this.fPbfEp = fPbfEp;
        this.fCadEp = fCadEp;
    }
 
    // Validadores
    private boolean isValidCodMun(long codMun) {
        return codMun >= 0;
    }

    private boolean isValidNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    private boolean isValidPesPbf(int pesPbf) {
        return pesPbf >= 0;
    }

    private boolean isValidPesCad(int pesCad) {
        return pesCad >= 0;
    }

    private boolean isValidFPbfDomi(double fPbfDomi) {
        return fPbfDomi >= 0.0 && fPbfDomi <= 100.0;
    }

    private boolean isValidFPbfEp(int fPbfEp) {
        return fPbfEp >= 0;
    }

    private boolean isValidFCadEp(double fCadEp) {
        return fCadEp >= 0.0 && fCadEp <= 100.0;
    }
    // Getters e setters

    public long getCodMun() {
        return codMun;
    }

    public void setCodMun(Long codMun) {
        this.codMun = codMun;
    }

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
