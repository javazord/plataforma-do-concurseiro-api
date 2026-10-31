package br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.e;

import java.util.Arrays;
import java.util.List;

public enum EStatusTask {
    PENDING("Pendente"),
    IN_PROGRESS("Em Andamento"),
    COMPLETED("Concluida"),
    CANCELED("Cancelada");

    private String descricao;

    EStatusTask(String descricao){
        this.descricao = descricao;
    }

    public List<EStatusTask> getStatusTarefa(){
        return Arrays.stream(EStatusTask.values()).toList();
    }
}
