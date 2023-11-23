package framework.utils.simplereportbuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import framework.utils.FileOperations;

public class ReportBuilder {
    private static final String DiretorioTemplate = FileOperations.DiretorioResources + File.separator
            + "simplereportbuilder" + File.separator + "template.html";
    private static final String DiretorioRelatorios = FileOperations.DiretorioResources + File.separator + "relatorios";
    private static final String PlaceholderTitulo = "{title}";
    private static final String PlaceholderConteudo = "{body}";

    public static Report report;

    public static void criar(String nome, String descricao) {
        ReportBuilder.report = new Report(nome, descricao);
    }

    public static void addStep(String descricao) {
        ReportBuilder.report.addStep(descricao);
    }

    public static void addRegistro(TipoRegistro tipo, String descricao) {
        ReportBuilder.report.getSteps().getLast().addRegistro(tipo, descricao);
    }

    public static void addRegistro(TipoRegistro tipo, String descricao, byte[] arquivo) {
        ReportBuilder.report.getSteps().getLast().addRegistro(tipo, descricao, arquivo);
    }

    public static void concluir() {
        criarPastaRelatorios(ReportBuilder.DiretorioRelatorios);

        String templateHtml = null;
        try {
            templateHtml = ReportBuilder.lerTemplateHtml(ReportBuilder.DiretorioTemplate);
        } catch (IOException e) {
            System.out.printf(
                    "Ocorreu uma falha durante a leitura do arquivo de template para geração do relatório %s%n",
                    ReportBuilder.report.getNome());

            e.printStackTrace();
        }

        if (templateHtml == null)
            return;

        String diretorioRelatorio = ReportBuilder.DiretorioRelatorios + File.separator + report.getNome() + ".html";

        StringBuilder relatorioHtml = new StringBuilder(templateHtml);

        // int placeholderTituloIndex = templateHtml.indexOf(PlaceholderTitulo);
        // int placeholderConteudoIndex = templateHtml.indexOf(PlaceholderConteudo);

        // System.out.println("- " + report.getNome());

        for (Step step : report.getSteps()) {
            // System.out.println("- - " + step.getDescricao());

            for (Registro registro : step.getRegistros()) {
                // System.out.println("- - - " + registro.getTipo() + " - " +
                // registro.getDescricao());
            }
        }

        try (FileWriter fileWriter = new FileWriter(diretorioRelatorio)) {
            fileWriter.write(relatorioHtml.toString());
        } catch (IOException e) {
            System.out.printf(
                    "Ocorreu uma falha durante a geração do relatório %s%n",
                    ReportBuilder.report.getNome());

            e.printStackTrace();
        }

        report = null;
    }

    private static void criarPastaRelatorios(String diretorio) {
        File diretorioRelatorios = new File(diretorio);

        if (!diretorioRelatorios.exists()) {
            diretorioRelatorios.mkdir();
        }
    }

    private static String lerTemplateHtml(String templatePath) throws IOException {
        byte[] conteudo = Files.readAllBytes(Paths.get(DiretorioTemplate));

        return new String(conteudo, StandardCharsets.UTF_8);
    }
}
