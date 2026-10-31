package br.com.plataforma_do_concurseiro.planejamento.topics.entity;

import br.com.plataforma_do_concurseiro.planejamento.subject.Subjects;
import br.com.plataforma_do_concurseiro.planejamento.reviews.entity.Review;
import br.com.plataforma_do_concurseiro.planejamento.tasks.estudo.entity.StudyTasks;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topics")
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subjects_id", nullable = false)
    private Subjects subjects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_topic_id")
    private Topic parentTopic;

    @OneToMany(mappedBy = "parentTopic", fetch = FetchType.LAZY)
    private List<Topic> childTopics = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int displayOrder;
    private BigDecimal weight;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<StudyTasks> studyTasks = new ArrayList<>();

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

}
