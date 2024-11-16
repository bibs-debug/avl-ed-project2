package node;

public class Municipio implements Comparable<Municipio> {
    private String id;
    private String nome;
    private String regiao;
    private int populacao;
    private double indiceDesemprego;

    public Municipio(String id, String nome, String regiao, int populacao, double indiceDesemprego) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("ID invalido");
        if (populacao < 0) throw new IllegalArgumentException("Populacao nao pode ser negativa");
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.indiceDesemprego = indiceDesemprego;
    }
    
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public int getPopulacao() {
        return populacao;
    }

    public double getIndiceDesemprego() {
        return indiceDesemprego;
    }

    @Override
    public int compareTo(Municipio other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Regiao: " + regiao + 
            ", Populacao: " + populacao + ", Indice de Desemprego: " + indiceDesemprego;
    }

}
