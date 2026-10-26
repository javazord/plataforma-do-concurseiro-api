package br.com.plataforma_do_concurseiro.planejamento.concursos.entity;

import br.com.plataforma_do_concurseiro.planejamento.concursos.e.EStatusConcurso;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "concursos")
public class Concurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nome;

    private String orgao;
    private String banca;
    private LocalDate dataProva;
    private String editalUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EStatusConcurso status = EStatusConcurso.EM_ESTUDO;

    @OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas = new ArrayList<>();

    @OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY)
    private List<PlanoEstudo> planosEstudo = new ArrayList<>();

}
