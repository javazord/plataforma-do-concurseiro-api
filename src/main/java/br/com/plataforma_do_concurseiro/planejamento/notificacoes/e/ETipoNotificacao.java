package br.com.plataforma_do_concurseiro.planejamento.notificacoes.e;

import java.util.Arrays;
import java.util.List;

public enum ETipoNotificacao {
    LEMBRETE_ESTUDO("Lembrete de Estudo"),
    REVISAO_PENDENTE("Revisão Pendente"),
    META("Meta"),
    PRAZO_CONCURSO("Prazo do Concurso"),
    SISTEMA("Sistema");

    private String descricao;

    ETipoNotificacao(String descricao){
        this.descricao = descricao;
    }

    public List<ETipoNotificacao> getTema(){
        return Arrays.stream(ETipoNotificacao.values()).toList();
    }
}
