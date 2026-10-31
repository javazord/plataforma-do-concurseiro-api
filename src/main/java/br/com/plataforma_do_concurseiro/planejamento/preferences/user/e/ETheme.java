package br.com.plataforma_do_concurseiro.planejamento.preferences.user.e;

import java.util.Arrays;
import java.util.List;

public enum ETheme {

    CLEAR("Claro"),
    DARK("Escuro"),
    SYSTEM("Sistema");

    private String description;

    ETheme(String description){
        this.description = description;
    }

    public List<ETheme> getTheme(){
        return Arrays.stream(ETheme.values()).toList();
    }

}
