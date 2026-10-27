package br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.entity;

import br.com.plataforma_do_concurseiro.planejamento.planos.estudo.entity.PlanoEstudo;
import br.com.plataforma_do_concurseiro.planejamento.sessoes.estudo.entity.SessaoEstudo;
import br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.e.EStatusTarefa;
import br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.e.ETipoTarefa;
import br.com.plataforma_do_concurseiro.planejamento.topicos.entity.Topico;
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
@Table(name = "tarefas_estudo")
public class TarefaEstudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plano_id", nullable = false)
    private PlanoEstudo plano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @Column(nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoTarefa tipo = ETipoTarefa.TEORIA;

    @Column(nullable = false)
    private LocalDate dataPlanejada;

    private LocalTime horaInicio;

    @Column(nullable = false)
    private int duracaoPlanejadaMinutos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EStatusTarefa status = EStatusTarefa.PENDENTE;

    private Instant concluidaEm;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();

    @OneToMany(mappedBy = "tarefa", fetch = FetchType.LAZY)
    private List<SessaoEstudo> sessoes = new ArrayList<>();
}
