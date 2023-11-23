package framework.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileOperations {
    private static final String DiretorioBase = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "main";

    public static final String DiretorioMain = FileOperations.DiretorioBase + File.separator + "java";

    public static final String DiretorioResources = FileOperations.DiretorioBase + File.separator + "resources";

    public static Properties getProperties(String nomeArquivo) {
        Properties properties = new Properties();

        String diretorioArquivoProperties = FileOperations.DiretorioResources
                + File.separator + "properties"
                + File.separator + String.format("%s.properties", nomeArquivo);

        try (FileReader leitor = new FileReader(diretorioArquivoProperties)) {
            properties.load(leitor);
        } catch (IOException e) {
            System.out.printf("Ocorreu uma falha durante a leitura do arquivo de propriedades %s%n", nomeArquivo);

            e.printStackTrace();
        }

        return properties;
    }
}
