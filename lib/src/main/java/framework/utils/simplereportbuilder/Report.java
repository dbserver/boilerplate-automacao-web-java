package framework.utils.simplereportbuilder;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Report {
    private String descricao;
    private LocalDateTime criacao;
    private LinkedList<Step> steps;

    public Report(String descricao) {
        this.descricao = descricao;

        this.criacao = LocalDateTime.now();

        this.steps = new LinkedList<>();
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDateTime getCriacao() {
        return this.criacao;
    }

    public LinkedList<Step> getSteps() {
        return this.steps;
    }

    public void addStep(String descricao) {
        this.steps.addLast(new Step(descricao));
    }
}
