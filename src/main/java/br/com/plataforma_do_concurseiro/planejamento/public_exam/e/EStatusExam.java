package br.com.plataforma_do_concurseiro.planejamento.public_exam.e;

import java.util.Arrays;
import java.util.List;

public enum EStatusExam {

    IN_STUDY("Em Estudo"),
    OPEN_ENROLLMENT("Inscrição Aberta"),
    REALIZED("Realizado"),
    ARCHIVED("Arquivado");

    private String description;

    EStatusExam(String description){
        this.description = description;
    }

    public List<EStatusExam> getStatusExam(){
        return Arrays.stream(EStatusExam.values()).toList();
    }
}
