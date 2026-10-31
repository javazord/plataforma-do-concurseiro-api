package br.com.plataforma_do_concurseiro.planejamento.reviews.entity;

import br.com.plataforma_do_concurseiro.planejamento.reviews.e.EReviewResult;
import br.com.plataforma_do_concurseiro.planejamento.study.sessions.entity.StudySession;
import br.com.plataforma_do_concurseiro.planejamento.topics.entity.Topic;
import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_session_id")
    private StudySession sourceSession;

    @Column(nullable = false)
    private LocalDate scheduledDate;

    private Instant completedAt;

    @Enumerated(EnumType.STRING)
    private EReviewResult result;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}
