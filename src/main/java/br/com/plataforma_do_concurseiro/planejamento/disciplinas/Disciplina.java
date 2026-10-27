package br.com.plataforma_do_concurseiro.planejamento.disciplinas;

import br.com.plataforma_do_concurseiro.planejamento.concursos.entity.Concurso;
import br.com.plataforma_do_concurseiro.planejamento.topicos.entity.Topico;
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
@Table(name = "disciplinas")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "concurso_id", nullable = false)
    private Concurso concurso;

    @Column(nullable = false)
    private String nome;

    private BigDecimal peso;
    private int ordem;

    @Column(nullable = false)
    private String status = "ATIVA";

    @OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
    private List<Topico> topicos = new ArrayList<>();

}
