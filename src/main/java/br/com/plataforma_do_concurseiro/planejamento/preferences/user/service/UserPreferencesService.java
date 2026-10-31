package br.com.plataforma_do_concurseiro.planejamento.preferences.user.service;

import br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity.UserPreferences;

import java.util.Optional;

public interface UserPreferencesService {

    UserPreferences savePreferences(UserPreferences userPreferences);

    UserPreferences updatePreferences(UserPreferences userPreferences);

    Optional<UserPreferences> searchPreferencesByUserId(UserPreferences userPreferences);

}
