package br.com.plataforma_do_concurseiro.planejamento.user.dto;

import br.com.plataforma_do_concurseiro.planejamento.notificacoes.entity.Notification;
import br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity.UserPreferences;
import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;

import java.util.Collections;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private List<UserPreferences> userPreferences;
    private List<Notification> notifications;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.userPreferences = Collections.singletonList(user.getPreferences());
        this.notifications = user.getNotifications().stream().toList();
    }

}
