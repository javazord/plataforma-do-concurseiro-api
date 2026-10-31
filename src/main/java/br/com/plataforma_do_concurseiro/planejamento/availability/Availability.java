package br.com.plataforma_do_concurseiro.planejamento.availability;

import br.com.plataforma_do_concurseiro.planejamento.study.plans.entity.StudyPlans;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "availabilities")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "study_plan_id", nullable = false)
    private StudyPlans studyPlan;

    // Convenção: 1 = segunda-feira, 7 = domingo.
    @Column(nullable = false)
    private short dayOfWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;
}
