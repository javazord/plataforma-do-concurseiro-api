package br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.service.impl;

import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity.PreferenciasUsuario;
import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.repository.PreferenciasUsuarioRepository;
import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.service.PreferenciasUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PreferenciasUsuarioImpl implements PreferenciasUsuarioService {

    private final PreferenciasUsuarioRepository preferenciasUsuarioRepository;

    public PreferenciasUsuarioImpl(PreferenciasUsuarioRepository preferenciasUsuarioRepository){
        this.preferenciasUsuarioRepository = preferenciasUsuarioRepository;
    }

    @Override
    @Transactional
    public PreferenciasUsuario salvarPreferencias(PreferenciasUsuario preferenciasUsuario) {
        return preferenciasUsuarioRepository.save(preferenciasUsuario);
    }

    @Override
    public PreferenciasUsuario atualizarPreferencias(PreferenciasUsuario preferenciasUsuario) {
        return preferenciasUsuarioRepository.save(preferenciasUsuario);
    }

    @Override
    public Optional<PreferenciasUsuario> procurarPreferenciasByUsuarioId(PreferenciasUsuario preferenciasUsuario) {
        return preferenciasUsuarioRepository.findPreferenciasUsuarioByUsuario_Id(preferenciasUsuario.getUsuario().getId());
    }

}
