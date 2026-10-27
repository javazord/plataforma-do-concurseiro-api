package br.com.plataforma_do_concurseiro.planejamento.revisoes.entity;

import br.com.plataforma_do_concurseiro.planejamento.revisoes.e.EResultadoRevisao;
import br.com.plataforma_do_concurseiro.planejamento.sessoes.estudo.entity.SessaoEstudo;
import br.com.plataforma_do_concurseiro.planejamento.topicos.entity.Topico;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "revisoes")
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sessao_origem_id")
    private SessaoEstudo sessaoOrigem;

    @Column(nullable = false)
    private LocalDate dataPrevista;

    private Instant dataRealizada;

    @Enumerated(EnumType.STRING)
    private EResultadoRevisao resultado;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();
}
