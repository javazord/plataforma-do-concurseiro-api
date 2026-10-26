package br.com.plataforma_do_concurseiro.planejamento.concursos.e;

import java.util.Arrays;
import java.util.List;

public enum EStatusConcurso {

    EM_ESTUDO("Em Estudo"),
    INSCRICAO_ABERTA("Inscrição Aberta"),
    REALIZADO("Realizado"),
    ARQUIVADO("Arquivado");

    private String descricao;

    EStatusConcurso(String descricao){
        this.descricao = descricao;
    }

    public List<EStatusConcurso> getTema(){
        return Arrays.stream(EStatusConcurso.values()).toList();
    }
}
