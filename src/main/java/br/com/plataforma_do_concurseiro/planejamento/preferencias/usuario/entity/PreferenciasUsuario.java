package br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity;

import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.e.ETema;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "preferencias_usuario")
public class PreferenciasUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "foto_url", length = 1000)
    private String fotoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETema tema = ETema.SISTEMA;

    @Column(nullable = false)
    private int duracaoFocoMinutos = 25;

    @Column(nullable = false)
    private int duracaoPausaMinutos = 5;

    private boolean notificacoesAtivas = true;

}
