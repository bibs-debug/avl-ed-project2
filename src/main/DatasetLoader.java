package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetLoader {
    public static List<Municipio> carregarDataset(String filePath) {
        List<Municipio> municipios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                long codMun = Long.parseLong(values[0]);
                String nome = values[1];
                // Skip the 'Referência' column (values[2])
                int pesPbf = (int) Double.parseDouble(values[3]);
                int pesCad = (int) Double.parseDouble(values[4]);
                double fPbfDomi = Double.parseDouble(values[5]);
                int fPbfEp = (int) Double.parseDouble(values[6]);
                double fCadEp = Double.parseDouble(values[7]);
                Municipio municipio = new Municipio(codMun, nome, pesPbf, pesCad, fPbfDomi, fPbfEp, fCadEp);
                municipios.add(municipio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return municipios;
    }
}
