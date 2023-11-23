package framework.utils.simplereportbuilder;

import java.time.format.DateTimeFormatter;

public class ReportBuilder {
    private static final DateTimeFormatter FormatoPadrao = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS");

    public static Report report;

    public static void criar(String descricao) {
        ReportBuilder.report = new Report(descricao);
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
        // TODO: Gerar HTMLs no output de FileOperations.DiretorioResources + "reports"

        System.out.println("- " + report.getDescricao()
                + " " + report.getCriacao().format(FormatoPadrao));

        for (Step step : report.getSteps()) {
            System.out.println("- - " + step.getDescricao());

            for (Registro registro : step.getRegistros()) {
                System.out.println("- - - " + registro.getTipo() + " - " + registro.getDescricao());
            }
        }

        report = null;
    }
}
