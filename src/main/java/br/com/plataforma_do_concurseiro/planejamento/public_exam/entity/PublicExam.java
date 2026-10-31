package br.com.plataforma_do_concurseiro.planejamento.public_exam.entity;

import br.com.plataforma_do_concurseiro.planejamento.public_exam.e.EStatusExam;
import br.com.plataforma_do_concurseiro.planejamento.subject.Subjects;
import br.com.plataforma_do_concurseiro.planejamento.study.plans.entity.StudyPlans;
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
@Table(name = "public_exams")
public class PublicExam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    private String organization;
    private String examBoard;
    private LocalDate examDate;
    private String publicNoticeUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EStatusExam status = EStatusExam.IN_STUDY;

    @OneToMany(mappedBy = "publicExam", fetch = FetchType.LAZY)
    private List<Subjects> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "publicExam", fetch = FetchType.LAZY)
    private List<StudyPlans> studyPlans = new ArrayList<>();

}
