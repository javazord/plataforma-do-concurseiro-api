package br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.e;

import java.util.Arrays;
import java.util.List;

public enum ETypeTask {
    THEORY("Teoria"),
    REVIEW("Revisão"),
    READING("Leitura"),
    SUMMARY("Resumo"),
    OTHER("Outro");

    private String description;

    ETypeTask(String description){
        this.description = description;
    }

    public List<ETypeTask> getTypeTask(){
        return Arrays.stream(ETypeTask.values()).toList();
    }
}
