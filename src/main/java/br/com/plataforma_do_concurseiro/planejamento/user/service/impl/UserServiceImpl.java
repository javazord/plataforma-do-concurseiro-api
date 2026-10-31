package br.com.plataforma_do_concurseiro.planejamento.user.service.impl;

import br.com.plataforma_do_concurseiro.planejamento.user.dto.UserDTO;
import br.com.plataforma_do_concurseiro.planejamento.user.entity.User;
import br.com.plataforma_do_concurseiro.planejamento.user.repository.UserRepository;
import br.com.plataforma_do_concurseiro.planejamento.user.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        validator(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDTO authenticate(String email, String password) {
        Optional<User> usuarioOptional = userRepository.findByEmail(email);

        if (!verifyPassword(password, usuarioOptional.get().getPassword())){
            throw new RuntimeException("E-mail ou password incorretos!");
        }

        UserDTO userDTO = new UserDTO(usuarioOptional.get());
        return userDTO;
    }

    @Override
    public void validator(User user) {
        boolean existeUsuario = userRepository.existsByEmail(user.getEmail());

        if (existeUsuario){
            throw new RuntimeException("Já existe um usuário com este e-mail");
        } if (user.getEmail().isBlank() || user.getPassword().isBlank()) {
            throw new RuntimeException("Informe um e-mail ou password válidos");
        }
    }

    @Override
    public User update(User user) {
        user.setPassword(user.getPassword() != null ? passwordEncoder.encode(user.getPassword()) : null);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findbyId(Long id) {
        return userRepository.findById(id);
    }

    private boolean verifyPassword(String password, String encode){
        return passwordEncoder.matches(password, encode);
    }
}
