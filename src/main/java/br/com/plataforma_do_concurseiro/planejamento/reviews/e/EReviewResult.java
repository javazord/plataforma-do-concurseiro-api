package br.com.plataforma_do_concurseiro.planejamento.reviews.e;

import java.util.Arrays;
import java.util.List;

public enum EReviewResult {
    DIFFICULT("Dificil"),
    REASONABLE("Razoavel"),
    EASY("Fácil");

    private String description;

    EReviewResult(String description){
        this.description = description;
    }

    public List<EReviewResult> getReviewResult(){
        return Arrays.stream(EReviewResult.values()).toList();
    }
}
