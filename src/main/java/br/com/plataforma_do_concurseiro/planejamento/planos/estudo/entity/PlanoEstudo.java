package br.com.plataforma_do_concurseiro.planejamento.planos.estudo.entity;

import br.com.plataforma_do_concurseiro.planejamento.concursos.entity.Concurso;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planos_estudo")
public class PlanoEstudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concurso_id")
    private Concurso concurso;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int metaSemanalMinutos;

    @Column(nullable = false)
    private LocalDate dataInicio;

    private LocalDate dataFim;

    private boolean ativo = true;

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    @OneToMany(mappedBy = "plano", fetch = FetchType.LAZY)
    private List<TarefaEstudo> tarefas = new ArrayList<>();

}
