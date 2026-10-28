package br.com.plataforma_do_concurseiro.planejamento.usuario.repository;

import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
