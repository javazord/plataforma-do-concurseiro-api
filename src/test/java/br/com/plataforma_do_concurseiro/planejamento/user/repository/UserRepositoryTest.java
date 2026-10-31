package br.com.plataforma_do_concurseiro.planejamento.user.repository;

import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;
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
class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    void existsByEmail_DeveRetornarTrue_QuandoEmailExistir() {
        String email = "email@email.com";
        this.createUser();
        boolean exist = userRepository.existsByEmail(email);
        assertTrue(exist);
    }

    @Test
    void existsByEmail_DeveRetornarFalse_QuandoEmailNaoExistir() {
        String email = "inexistente@email.com";
        this.createUser();
        boolean exist = userRepository.existsByEmail(email);
        assertFalse(exist);
    }

    @Test
    void findByEmail_DeveRetornarUsuario_QuandoEmailExistir(){
        User user = createUser();
        Optional<User> result = userRepository.findByEmail("email@email.com");

        assertTrue(result.isPresent());

        User findUser = result.orElseThrow();

        assertEquals(user.getId(), findUser.getId());
        assertEquals("fulano", findUser.getName());
        assertEquals("email@email.com", findUser.getEmail());
        assertTrue(findUser.isAtivo());
    }

    @Test
    void findByEmail_DeveRetornarOptionalVazio_QuandoEmailNaoExistir(){
        Optional<User> result = userRepository.findByEmail("inexistente@email.com");

        assertTrue(result.isEmpty());
    }

    private User createUser(){
        User user = new User(null, "fulano", "email@email.com", "123123", true, Instant.now(), Instant.now(), null, null, null, null, null, null);

        this.entityManager.persist(user);
        return user;
    }

}