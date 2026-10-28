package br.com.plataforma_do_concurseiro.planejamento.usuario.service;

import br.com.plataforma_do_concurseiro.planejamento.usuario.dto.UsuarioDTO;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario salvarUsuario(Usuario usuario);

    UsuarioDTO autenticar(String email, String senha);

    void validar(Usuario usuario);

    Usuario atualizar(Usuario usuario);

    Optional<Usuario> findbyId(Long id);

}
