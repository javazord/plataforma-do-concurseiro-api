package br.com.plataforma_do_concurseiro.planejamento.user.service;

import br.com.plataforma_do_concurseiro.planejamento.user.dto.UserDTO;
import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    UserDTO authenticate(String email, String password);

    void validator(User user);

    User update(User user);

    Optional<User> findbyId(Long id);

}
