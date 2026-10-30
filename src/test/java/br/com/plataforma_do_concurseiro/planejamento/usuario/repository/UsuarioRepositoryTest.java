package br.com.plataforma_do_concurseiro.planejamento.usuario.repository;

import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    void existsByEmail_DeveRetornarTrue_QuandoEmailExistir() {
        String email = "email@email.com";
        this.criarUsuario();
        boolean existe = usuarioRepository.existsByEmail(email);
        assertTrue(existe);
    }

    @Test
    void existsByEmail_DeveRetornarFalse_QuandoEmailNaoExistir() {
        String email = "inexistente@email.com";
        this.criarUsuario();
        boolean existe = usuarioRepository.existsByEmail(email);
        assertFalse(existe);
    }

    @Test
    void findByEmail_DeveRetornarUsuario_QuandoEmailExistir(){
        Usuario user = criarUsuario();
        Optional<Usuario> resultado = usuarioRepository.findByEmail("email@email.com");

        assertTrue(resultado.isPresent());

        Usuario usuarioEncontrado = resultado.orElseThrow();

        assertEquals(user.getId(), usuarioEncontrado.getId());
        assertEquals("fulano", usuarioEncontrado.getNome());
        assertEquals("email@email.com", usuarioEncontrado.getEmail());
        assertTrue(usuarioEncontrado.isAtivo());
    }

    @Test
    void findByEmail_DeveRetornarOptionalVazio_QuandoEmailNaoExistir(){
        Optional<Usuario> resultado = usuarioRepository.findByEmail("inexistente@email.com");

        assertTrue(resultado.isEmpty());
    }

    private Usuario criarUsuario(){
        Usuario user = new Usuario(null, "fulano", "email@email.com", "123123", true, Instant.now(), Instant.now(), null, null, null, null, null, null);

        this.entityManager.persist(user);
        return user;
    }

}