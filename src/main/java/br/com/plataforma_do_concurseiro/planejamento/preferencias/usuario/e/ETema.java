package br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.e;

import br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.e.EStatusTarefa;

import java.util.Arrays;
import java.util.List;

public enum ETema {

    CLARO("Claro"),
    ESCURO("Escuro"),
    SISTEMA("Sistema");

    private String descricao;

    ETema(String descricao){
        this.descricao = descricao;
    }

    public List<ETema> getTema(){
        return Arrays.stream(ETema.values()).toList();
    }

}
