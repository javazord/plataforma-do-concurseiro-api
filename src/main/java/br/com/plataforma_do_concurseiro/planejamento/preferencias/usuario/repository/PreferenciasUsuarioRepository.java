package br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.repository;

import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity.PreferenciasUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferenciasUsuarioRepository extends JpaRepository<PreferenciasUsuario, Long> {
    Optional<PreferenciasUsuario> findPreferenciasUsuarioByUsuario_Id(Long usuarioId);
}
