package br.com.plataforma_do_concurseiro.planejamento.revisoes.e;

import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.e.ETema;

import java.util.Arrays;
import java.util.List;

public enum EResultadoRevisao {
    DIFICIL("Dificil"),
    RAZOAVEL("Razoavel"),
    FACIL("Fácil");

    private String descricao;

    EResultadoRevisao(String descricao){
        this.descricao = descricao;
    }

    public List<EResultadoRevisao> getTema(){
        return Arrays.stream(EResultadoRevisao.values()).toList();
    }
}
