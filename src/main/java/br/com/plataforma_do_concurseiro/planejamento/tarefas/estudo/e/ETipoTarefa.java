package br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.e;

import java.util.Arrays;
import java.util.List;

public enum ETipoTarefa {
    TEORIA("Teoria"),
    REVISAO("Revisão"),
    LEITURA("Leitura"),
    RESUMO("Resumo"),
    OUTRO("Outro");

    private String descricao;

    ETipoTarefa(String descricao){
        this.descricao = descricao;
    }

    public List<ETipoTarefa> getTarefas(){
        return Arrays.stream(ETipoTarefa.values()).toList();
    }
}
