package br.com.plataforma_do_concurseiro.planejamento.topicos.entity;

import br.com.plataforma_do_concurseiro.planejamento.disciplinas.Disciplina;
import br.com.plataforma_do_concurseiro.planejamento.revisoes.entity.Revisao;
import br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.entity.TarefaEstudo;
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
@Table(name = "topicos")
public class Topico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_pai_id")
    private Topico topicoPai;

    @OneToMany(mappedBy = "topicoPai", fetch = FetchType.LAZY)
    private List<Topico> subtopicos = new ArrayList<>();

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private int ordem;
    private BigDecimal peso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<TarefaEstudo> tarefas = new ArrayList<>();

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<Revisao> revisoes = new ArrayList<>();

}
