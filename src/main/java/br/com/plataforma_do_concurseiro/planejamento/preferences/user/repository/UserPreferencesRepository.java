package br.com.plataforma_do_concurseiro.planejamento.preferences.user.repository;

import br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Long> {
    Optional<UserPreferences> findUserPreferencesByUser_Id(Long userId);
}
