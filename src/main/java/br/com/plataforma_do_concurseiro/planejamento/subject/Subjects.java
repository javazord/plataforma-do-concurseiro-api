package br.com.plataforma_do_concurseiro.planejamento.subject;

import br.com.plataforma_do_concurseiro.planejamento.public_exam.entity.PublicExam;
import br.com.plataforma_do_concurseiro.planejamento.topics.entity.Topic;
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
@Table(name = "subjects")
public class Subjects implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "public_exam_id", nullable = false)
    private PublicExam publicExam;

    @Column(nullable = false)
    private String name;

    private BigDecimal weight;
    private int displayOrder;

    @Column(nullable = false)
    private String status = "ACTIVE";

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Topic> topics = new ArrayList<>();

}
