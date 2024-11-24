package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetLoader {
    public static List<Municipio> carregarDataset(String caminhoArquivo) {
        List<Municipio> municipios = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine(); // Ignora a primeira linha (cabeçalho)

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                // Limpar os dados, removendo espaços extras e aspas
                for (int i = 0; i < campos.length; i++) {
                    campos[i] = campos[i].trim().replace("\"", ""); // Limpa os campos
                }
 
                try {
                    // Alteração para usar 'long' para o código do município
                    long codMun = parseLong(campos[0]);  // Para 'codMun', agora usa 'long'
                    Municipio municipio = new Municipio(
                        codMun,  // codMun como long
                        campos[1],  // nome
                        parseInt(campos[3]),  // pesPBF
                        parseInt(campos[4]),  // pesCad
                        parseDouble(campos[5]), // fPBFDomi
                        parseInt(campos[6]),  // fPBFEp
                        parseDouble(campos[7]) // fCADEp
                    );
                    municipios.add(municipio);
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao processar a linha: " + linha);
                }
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }

        return municipios;
    }

    // Método atualizado para parsear 'long' para o código do município
    private static long parseLong(String value) {
        try {
            return Long.parseLong(value);  // Agora converte para long
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter para long: " + value);
            return 0L;  // Retorna 0 caso a conversão falhe
        }
    }

    // Método para parsing de int
    private static int parseInt(String value) {
        try {
            return (int) Double.parseDouble(value);  // Converte para int a partir de double
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter para int: " + value);
            return 0;  // Retorna 0 caso haja erro de formato
        }
    }

    // Método para parsing de double
    private static double parseDouble(String value) {
        try {
            return Double.parseDouble(value.replace(",", "."));  // Troca vírgula por ponto
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter para double: " + value);
            return 0.0;  // Retorna 0.0 caso haja erro de formato
        }
    }
}
