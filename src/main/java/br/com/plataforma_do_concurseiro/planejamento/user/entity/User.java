package br.com.plataforma_do_concurseiro.planejamento.user.entity;

import br.com.plataforma_do_concurseiro.planejamento.public_exam.entity.PublicExam;
import br.com.plataforma_do_concurseiro.planejamento.goals.entity.Goal;
import br.com.plataforma_do_concurseiro.planejamento.notificacoes.entity.Notification;
import br.com.plataforma_do_concurseiro.planejamento.study.plans.entity.StudyPlans;
import br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity.UserPreferences;
import br.com.plataforma_do_concurseiro.planejamento.reviews.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, unique = true, length = 180)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    private boolean ativo = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant created_at = Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updated_at = Instant.now();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private UserPreferences preferences;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PublicExam> publicExams = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<StudyPlans> studyPlans = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Goal> goals = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Notification> notifications = new ArrayList<>();

    @PreUpdate
    public void atualizarDataModificacao() {
        updated_at = Instant.now();
    }

}
