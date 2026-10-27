package br.com.plataforma_do_concurseiro.planejamento.usuario.entity;

import br.com.plataforma_do_concurseiro.planejamento.concursos.entity.Concurso;
import br.com.plataforma_do_concurseiro.planejamento.metas.entity.Meta;
import br.com.plataforma_do_concurseiro.planejamento.notificacoes.entity.Notificacao;
import br.com.plataforma_do_concurseiro.planejamento.planos.estudo.entity.PlanoEstudo;
import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity.PreferenciasUsuario;
import br.com.plataforma_do_concurseiro.planejamento.revisoes.entity.Revisao;
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
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, unique = true, length = 180)
    private String email;

    @Column(name = "senha_hash", nullable = false)
    private String senhaHash;

    private boolean ativo = true;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();

    @Column(name = "atualizado_em", nullable = false)
    private Instant atualizadoEm = Instant.now();

    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private PreferenciasUsuario preferencias;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Concurso> concursos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<PlanoEstudo> planosEstudo = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Revisao> revisoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Meta> metas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Notificacao> notificacoes = new ArrayList<>();

    @PreUpdate
    public void atualizarDataModificacao() {
        atualizadoEm = Instant.now();
    }

}
