package br.com.plataforma_do_concurseiro.planejamento.notificacoes.entity;

import br.com.plataforma_do_concurseiro.planejamento.notificacoes.e.ETipoNotificacao;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notificacoes")
public class Notificacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoNotificacao tipo;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Column(nullable = false, updatable = false)
    private Instant criadaEm = Instant.now();

    private Instant lidaEm;

    private String linkDestino;

}
