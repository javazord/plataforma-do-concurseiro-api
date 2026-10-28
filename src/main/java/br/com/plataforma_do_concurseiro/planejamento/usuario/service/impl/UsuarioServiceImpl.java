package br.com.plataforma_do_concurseiro.planejamento.usuario.service.impl;

import br.com.plataforma_do_concurseiro.planejamento.usuario.dto.UsuarioDTO;
import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import br.com.plataforma_do_concurseiro.planejamento.usuario.repository.UsuarioRepository;
import br.com.plataforma_do_concurseiro.planejamento.usuario.service.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validar(usuario);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO autenticar(String email, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if (!verificarSenha(senha, usuarioOptional.get().getSenha())){
            throw new RuntimeException("E-mail ou senha incorretos!");
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioOptional.get());
        return usuarioDTO;
    }

    @Override
    public void validar(Usuario usuario) {
        boolean existeUsuario = usuarioRepository.existsByEmail(usuario.getEmail());

        if (existeUsuario){
            throw new RuntimeException("Já existe um usuário com este e-mail");
        } if (usuario.getEmail().isBlank() || usuario.getSenha().isBlank()) {
            throw new RuntimeException("Informe um e-mail ou senha válidos");
        }
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        usuario.setSenha(usuario.getSenha() != null ? passwordEncoder.encode(usuario.getSenha()) : null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findbyId(Long id) {
        return usuarioRepository.findById(id);
    }

    private boolean verificarSenha(String senha, String encode){
        return passwordEncoder.matches(senha, encode);
    }
}
