package node;

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
            br.readLine(); 

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                for (int i = 0; i < campos.length; i++) {
                    campos[i] = campos[i].trim().replace("\"", ""); 
                }

                try {
                    Municipio municipio = new Municipio(
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

    private static int parseInt(String value) {
        try {
            return (int) Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0; 
        }
    }

    private static double parseDouble(String value) {
        try {
            return Double.parseDouble(value.replace(",", "."));
        } catch (NumberFormatException e) {
            return 0.0; 
        }
    }
}
