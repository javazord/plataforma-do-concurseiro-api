package br.com.plataforma_do_concurseiro.planejamento.notificacoes.e;

import java.util.Arrays;
import java.util.List;

public enum ETypeNotification {
    STUDY_REMINDER("Lembrete de Estudo"),
    PENDING_REVIEW("Revisão Pendente"),
    GOAL("Goal"),
    COMPETITION_DEADLINE("Prazo do PublicExam"),
    SYSTEM("Sistema");

    private String description;

    ETypeNotification(String description) {
        this.description = description;
    }

    public List<ETypeNotification> getTypeNotification() {
        return Arrays.stream(ETypeNotification.values()).toList();
    }
}
