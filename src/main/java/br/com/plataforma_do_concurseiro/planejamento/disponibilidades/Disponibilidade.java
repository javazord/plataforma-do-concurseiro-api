package br.com.plataforma_do_concurseiro.planejamento.disponibilidades;

import br.com.plataforma_do_concurseiro.planejamento.planos.estudo.entity.PlanoEstudo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disponibilidades")
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plano_id", nullable = false)
    private PlanoEstudo plano;

    // Convenção: 1 = segunda-feira, 7 = domingo.
    @Column(nullable = false)
    private short diaSemana;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFim;
}
