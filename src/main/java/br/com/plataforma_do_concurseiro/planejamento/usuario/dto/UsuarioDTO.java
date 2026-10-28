package br.com.plataforma_do_concurseiro.planejamento.usuario.dto;

import br.com.plataforma_do_concurseiro.planejamento.notificacoes.entity.Notificacao;
import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity.PreferenciasUsuario;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;

import java.util.Collections;
import java.util.List;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private List<PreferenciasUsuario> preferenciasUsuario;
    private List<Notificacao> notificacoes;

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.preferenciasUsuario = Collections.singletonList(usuario.getPreferencias());
        this.notificacoes = usuario.getNotificacoes().stream().toList();
    }

}
