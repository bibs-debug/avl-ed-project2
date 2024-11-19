package node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public static List<Municipio> lerMunicipios(String caminhoArquivo) {
        List<Municipio> municipios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            
            // Pular o cabeçalho (primeira linha do CSV)
            br.readLine();

            // Ler as linhas do arquivo
            while ((linha = br.readLine()) != null) {
                // Separar os dados usando vírgula
                String[] dados = linha.split(",");

                // Certificar-se de que há dados suficientes para criar um objeto Municipio
                if (dados.length == 8) {
                    try {
                        int codMun = Integer.parseInt(dados[0]);
                        String nome = dados[1];
                        String referencia = dados[2];
                        int pesPBF = Integer.parseInt(dados[3]);
                        int pesCad = Integer.parseInt(dados[4]);
                        // Substituindo vírgula por ponto para converter os números corretamente
                        double fPBFDomi = Double.parseDouble(dados[5].replace(',', '.'));
                        int fPBFEp = Integer.parseInt(dados[6]);
                        // Também substituindo vírgula por ponto para fCADEp
                        double fCADEp = Double.parseDouble(dados[7].replace(',', '.'));

                        // Criar objeto Municipio e adicionar à lista
                        Municipio municipio = new Municipio(codMun, nome, referencia, pesPBF, pesCad, fPBFDomi, fPBFEp, fCADEp);
                        municipios.add(municipio);
                    } catch (NumberFormatException e) {
                        // Se ocorrer erro ao converter os dados para int ou double
                        System.out.println("Erro ao processar a linha: " + linha);
                    }
                } else {
                    System.out.println("Linha com número de campos inválido: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return municipios;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String caminhoArquivo = "dataset_2020.csv"; // Substitua pelo caminho do seu arquivo CSV
        List<Municipio> municipios = lerMunicipios(caminhoArquivo);

        // Imprimir os municipios lidos
        for (Municipio municipio : municipios) {
            System.out.println(municipio);
        }
    }
}
