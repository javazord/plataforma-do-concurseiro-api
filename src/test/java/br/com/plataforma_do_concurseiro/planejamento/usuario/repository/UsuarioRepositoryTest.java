package br.com.plataforma_do_concurseiro.planejamento.usuario.repository;

import br.com.plataforma_do_concurseiro.planejamento.usuario.entity.Usuario;
import jakarta.persistence.EntityManager;
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

    private Usuario criarUsuario(){
        Usuario user = new Usuario(null, "fulano", "email@email.com", "123123", true, Instant.now(), Instant.now(), null, null, null, null, null, null);

        this.entityManager.persist(user);
        return user;
    }

}