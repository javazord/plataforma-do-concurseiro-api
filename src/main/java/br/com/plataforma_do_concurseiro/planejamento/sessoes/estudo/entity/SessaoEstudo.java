package br.com.plataforma_do_concurseiro.planejamento.sessoes.estudo.entity;

import br.com.plataforma_do_concurseiro.planejamento.revisoes.entity.Revisao;
import br.com.plataforma_do_concurseiro.planejamento.tarefas.estudo.entity.TarefaEstudo;
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
@Table(name = "sessoes_estudo")
public class SessaoEstudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarefa_id", nullable = false)
    private TarefaEstudo tarefa;

    @Column(nullable = false)
    private Instant inicioEm;

    // Nulo enquanto a sessão estiver em andamento.
    private Instant fimEm;

    @Column(nullable = false)
    private long duracaoSegundos = 0;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();

    @OneToMany(mappedBy = "sessaoOrigem", fetch = FetchType.LAZY)
    private List<Revisao> revisoesOriginadas = new ArrayList<>();
}
