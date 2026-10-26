package br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.e;

import java.util.Arrays;
import java.util.List;

public enum EStatusTarefa {
    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDA("Concluida"),
    CANCELADA("Cancelada");

    private String descricao;

    EStatusTarefa(String descricao){
        this.descricao = descricao;
    }

    public List<EStatusTarefa> getStatusTarefa(){
        return Arrays.stream(EStatusTarefa.values()).toList();
    }
}
