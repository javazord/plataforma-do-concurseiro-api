package br.com.plataforma_do_concurseiro.planejamento.study.sessions.entity;

import br.com.plataforma_do_concurseiro.planejamento.reviews.entity.Review;
import br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.entity.StudyTasks;
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
@Table(name = "study_sessions")
public class StudySession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "study_task_id", nullable = false)
    private StudyTasks studyTask;

    @Column(nullable = false)
    private Instant startedAt;

    // Nulo enquanto a sessão estiver em andamento.
    private Instant endedAt;

    @Column(nullable = false)
    private long durationSeconds = 0;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @OneToMany(mappedBy = "sourceSession", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();
}
