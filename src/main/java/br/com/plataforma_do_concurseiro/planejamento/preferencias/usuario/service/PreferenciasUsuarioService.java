package br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.service;

import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity.PreferenciasUsuario;

import java.util.Optional;

public interface PreferenciasUsuarioService {

    PreferenciasUsuario salvarPreferencias(PreferenciasUsuario preferenciasUsuario);

    PreferenciasUsuario atualizarPreferencias(PreferenciasUsuario preferenciasUsuario);

    Optional<PreferenciasUsuario> procurarPreferenciasByUsuarioId (PreferenciasUsuario preferenciasUsuario);

}
