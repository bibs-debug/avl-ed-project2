import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.List;
import java.util.ArrayList;


public class DatasetLoader {
    public static List<Municipio> carregarDataset(String caminhoArquivo) {
        List<Municipio> municipios = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
            String[] linha;
            reader.readNext(); // Ignorar cabeçalho
            while ((linha = reader.readNext()) != null) {
                Municipio municipio = new Municipio(
                    linha[1],  // Nome do Município
                    Integer.parseInt(linha[3]),  // Pes_PBF
                    Integer.parseInt(linha[4]),  // Pes_Cad
                    Double.parseDouble(linha[5].replace(",", ".")), // F_PBF_Domi
                    Integer.parseInt(linha[6]),  // F_PBF_EP
                    Double.parseDouble(linha[7]) // F_CAD_EP
                );
                municipios.add(municipio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return municipios;
    }
}
