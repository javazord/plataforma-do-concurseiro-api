package br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.entity;

import br.com.plataforma_do_concurseiro.planejamento.study.plans.entity.StudyPlans;
import br.com.plataforma_do_concurseiro.planejamento.study.sessions.entity.StudySession;
import br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.e.EStatusTask;
import br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.e.ETypeTask;
import br.com.plataforma_do_concurseiro.planejamento.topics.entity.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "study_tasks")
public class StudyTasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "study_plan_id", nullable = false)
    private StudyPlans studyPlan;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETypeTask type = ETypeTask.THEORY;

    @Column(nullable = false)
    private LocalDate plannedDate;

    private LocalTime startTime;

    @Column(nullable = false)
    private int plannedDurationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EStatusTask status = EStatusTask.PENDING;

    private Instant completedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private List<StudySession> studySessions = new ArrayList<>();
}
