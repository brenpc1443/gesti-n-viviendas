package com.gestion.viviendas.domain.service;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Iniciar sesión (devuelve la ID del usuario)
    public Optional<User> iniciarSesion(String nombreUsuario, String contraseña) {
        return userRepository.getByNombreUsuarioAndContraseña(nombreUsuario, contraseña);
    }

    // Registrar un nuevo usuario
    public User registrarse(String nombreUsuario, String nombre, String apellido, String telefono, String contraseña) {
        User newUser = new User();
        newUser.setUserName(nombreUsuario);
        newUser.setName(nombre);
        newUser.setLastName(apellido);
        newUser.setPhone(telefono);
        newUser.setPassword(contraseña);
        return userRepository.save(newUser);
    }

    // Editar datos del usuario
    public Optional<User> editar(int userId, String nombreUsuario, String telefono, String contraseña) {
        Optional<User> existingUser = userRepository.getById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUserName(nombreUsuario);
            user.setPhone(telefono);
            user.setPassword(contraseña);
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }
}