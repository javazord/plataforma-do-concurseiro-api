package br.com.plataforma_do_concurseiro.planejamento.preferences.user.service.impl;

import br.com.plataforma_do_concurseiro.planejamento.preferences.user.entity.UserPreferences;
import br.com.plataforma_do_concurseiro.planejamento.preferences.user.repository.UserPreferencesRepository;
import br.com.plataforma_do_concurseiro.planejamento.preferences.user.service.UserPreferencesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserPreferencesImpl implements UserPreferencesService {

    private final UserPreferencesRepository userPreferencesRepository;

    public UserPreferencesImpl(UserPreferencesRepository userPreferencesRepository){
        this.userPreferencesRepository = userPreferencesRepository;
    }

    @Override
    @Transactional
    public UserPreferences savePreferences(UserPreferences userPreferences) {
        return userPreferencesRepository.save(userPreferences);
    }

    @Override
    public UserPreferences updatePreferences(UserPreferences userPreferences) {
        return userPreferencesRepository.save(userPreferences);
    }

    @Override
    public Optional<UserPreferences> searchPreferencesByUserId(UserPreferences userPreferences) {
        return userPreferencesRepository.findUserPreferencesByUser_Id(userPreferences.getUser().getId());
    }

}
