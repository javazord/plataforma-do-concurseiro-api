package br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.repository;

import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.e.ETema;
import br.com.plataforma_do_concurseiro.planejamento.preferencias.usuario.entity.PreferenciasUsuario;
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

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PreferenciasUsuarioRepositoryTest {

    @Autowired
    PreferenciasUsuarioRepository preferenciasUsuarioRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void findPreferenciasUsuarioByUsuario_Id_DeveRetornarPreferenciasDeUmUsuario() {
        Usuario user = criarUsuario();
        Optional<PreferenciasUsuario> preferenciasUsuario = preferenciasUsuarioRepository.findPreferenciasUsuarioByUsuario_Id(user.getId());
        assertTrue(preferenciasUsuario.isPresent());
    }

    @Test
    void findPreferenciasUsuarioByUsuario_Id_DeveRetornarOptionalVazio_QuandoPreferenciasNaoExistir(){
        Optional<PreferenciasUsuario> preferenciasUsuario = preferenciasUsuarioRepository.findPreferenciasUsuarioByUsuario_Id(2L);
        assertTrue(preferenciasUsuario.isEmpty());
    }

    private Usuario criarUsuario(){
        Usuario user = new Usuario(null, "fulano", "email@email.com", "123123", true, Instant.now(), Instant.now(), null, null, null, null, null, null);
        PreferenciasUsuario preferenciasUsuario = new PreferenciasUsuario(null, user, "", ETema.SISTEMA, 25, 10, false);

        this.entityManager.persist(user);
        this.entityManager.persist(preferenciasUsuario);

        return user;
    }
}