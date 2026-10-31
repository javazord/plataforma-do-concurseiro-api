package br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity;

import br.com.plataforma_do_concurseiro.planejamento.preferences.user.e.ETheme;
import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_preferences")
public class UserPreferences implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "photo_url", length = 1000)
    private String photo_url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETheme theme = ETheme.SYSTEM;

    @Column(nullable = false)
    private int focusDurationMinutes = 25;

    @Column(nullable = false)
    private int breakDurationMinutes = 5;

    private boolean notificationsEnabled = true;

}
