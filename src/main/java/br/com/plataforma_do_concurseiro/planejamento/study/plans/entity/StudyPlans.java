package br.com.plataforma_do_concurseiro.planejamento.study.plans.entity;

import br.com.plataforma_do_concurseiro.planejamento.public_exam.entity.PublicExam;
import br.com.plataforma_do_concurseiro.planejamento.availability.Availability;
import br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.entity.StudyTasks;
import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "study_plans")
public class StudyPlans implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "public_exam_id")
    private PublicExam publicExam;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int weeklyGoalMinutes;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    private boolean active = true;

    @OneToMany(mappedBy = "studyPlan", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Availability> availabilities = new ArrayList<>();

    @OneToMany(mappedBy = "studyPlan", fetch = FetchType.LAZY)
    private List<StudyTasks> studyTasks = new ArrayList<>();

}
