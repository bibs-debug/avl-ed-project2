package main;

import java.util.List;

public class DataAnalysis {

    // Método para medir o tempo de execução de uma operação
    public static long measureExecutionTime(Runnable operation) {
        long startTime = System.nanoTime();
        operation.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Pergunta 1: Quantos municípios têm mais de X pessoas no PBF?
    public static long countMunicipiosWithMoreThanXPbf(List<Municipio> municipios, int x) {
        return municipios.stream()
                         .filter(m -> m.getPesPbf() > x)
                         .count();
    }

    // Pergunta 2: Qual o maior valor registrado no fPbfDomi em um determinado período?
    public static double maxFPbfDomi(List<Municipio> municipios) {
        return municipios.stream()
                         .mapToDouble(Municipio::getfPbfDomi)
                         .max()
                         .orElse(0);
    }

    // Pergunta 3: Qual o município com maior número de pessoas no Cadastro Único (PesCad)?
    public static Municipio municipioWithMaxPesCad(List<Municipio> municipios) {
        return municipios.stream()
                         .max((m1, m2) -> Integer.compare(m1.getPesCad(), m2.getPesCad()))
                         .orElse(null);
    }

    // Pergunta 4: Qual a média de famílias com renda até R$ 218,00 no Cadastro Único (fCadEp)?
    public static double averageFCadEp(List<Municipio> municipios) {
        return municipios.stream()
                         .mapToDouble(Municipio::getfCadEp)
                         .average()
                         .orElseThrow(() -> new IllegalArgumentException("Lista de municípios está vazia"));
    }

    // Pergunta 5: Quantos municípios têm fPbfDomi maior que X?
    public static long countMunicipiosWithFPbfDomiGreaterThanX(List<Municipio> municipios, double x) {
        return municipios.stream()
                         .filter(m -> m.getfPbfDomi() > x)
                         .count();
    }

    // Pergunta 6: Qual o município com a maior porcentagem de participação do PBF no total de domicílios (fPbfDomi)?
    public static Municipio municipioWithMaxFPbfDomi(List<Municipio> municipios) {
        return municipios.stream()
                         .max((m1, m2) -> Double.compare(m1.getfPbfDomi(), m2.getfPbfDomi()))
                         .orElseThrow(() -> new IllegalArgumentException("Lista de municípios está vazia"));
    }

    // Pergunta 7: Qual a soma total de pessoas no PBF em todos os municípios?
    public static int totalPesPbf(List<Municipio> municipios) {
        return municipios.stream()
                         .mapToInt(Municipio::getPesPbf)
                         .sum();
    }

    // Pergunta 8: Quantos municípios têm uma porcentagem de famílias com renda até R$ 218,00 (fCadEp) maior que 50%?
    public static long countMunicipiosWithFCadEpGreaterThan50(List<Municipio> municipios) {
        return municipios.stream()
                         .filter(m -> m.getfCadEp() > 50)
                         .count();
    }

    // Pergunta 9: Qual a diferença média de pessoas entre os municípios com maior e menor número de pessoas no PBF?
    public static double avgDifferenceInPesPbf(List<Municipio> municipios) {
        Municipio minPbf = municipios.stream()
                                     .min((m1, m2) -> Integer.compare(m1.getPesPbf(), m2.getPesPbf()))
                                     .orElseThrow(() -> new IllegalArgumentException("Lista de municípios está vazia"));
        Municipio maxPbf = municipios.stream()
                                     .max((m1, m2) -> Integer.compare(m1.getPesPbf(), m2.getPesPbf()))
                                     .orElseThrow(() -> new IllegalArgumentException("Lista de municípios está vazia"));
        return maxPbf.getPesPbf() - minPbf.getPesPbf();
    }

    // Pergunta 10: Qual a porcentagem média de famílias no Cadastro Único com renda até R$ 218,00?
    public static double averageFCadEpPercentage(List<Municipio> municipios) {
        return municipios.stream()
                         .mapToDouble(Municipio::getfCadEp)
                         .average()
                         .orElseThrow(() -> new IllegalArgumentException("Lista de municípios está vazia"));
    }
}
