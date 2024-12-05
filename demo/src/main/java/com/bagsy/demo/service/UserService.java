package com.bagsy.demo.service;

import com.bagsy.demo.domain.category.UserRepository;
import com.bagsy.demo.domain.users.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository usuarioRepository;

    public UserService(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean authenticateAdmin(String email, String senha) {
        Optional<User> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent() && usuario.get().isAdmin()) {
            return usuario.get().getSenha().equals(senha);
        }
        return false;
    }

    public String generateToken(String email) {
        return "token-" + email + "-" + System.currentTimeMillis();
    }
}
