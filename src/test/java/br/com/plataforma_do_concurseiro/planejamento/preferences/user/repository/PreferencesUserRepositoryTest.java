package br.com.plataforma_do_concurseiro.planejamento.preferences.user.repository;

import br.com.plataforma_do_concurseiro.planejamento.preferences.user.e.ETheme;
import br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity.UserPreferences;
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

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PreferencesUserRepositoryTest {

    @Autowired
    UserPreferencesRepository userPreferencesRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void findPreferenciasUsuarioByUsuario_Id_DeveRetornarPreferenciasDeUmUsuario() {
        User user = createUser();
        Optional<UserPreferences> userPreferences = userPreferencesRepository.findUserPreferencesByUser_Id(user.getId());
        assertTrue(userPreferences.isPresent());
    }

    @Test
    void findPreferenciasUsuarioByUsuario_Id_DeveRetornarOptionalVazio_QuandoPreferenciasNaoExistir(){
        Optional<UserPreferences> userPreferences = userPreferencesRepository.findUserPreferencesByUser_Id(2L);
        assertTrue(userPreferences.isEmpty());
    }

    private User createUser(){
        User user = new User(null, "fulano", "email@email.com", "123123", true, Instant.now(), Instant.now(), null, null, null, null, null, null);
        UserPreferences userPreferences = new UserPreferences(null, user, "", ETheme.SYSTEM, 25, 10, false);

        this.entityManager.persist(user);
        this.entityManager.persist(userPreferences);

        return user;
    }
}