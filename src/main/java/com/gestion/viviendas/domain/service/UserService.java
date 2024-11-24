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

<<<<<<< HEAD
    public Optional<User> getByTelefonoAndContrasena(String telefono, String contrasena){
        return userRepository.getByTelefonoAndContrasena(telefono, contrasena);
=======
    // Registrar un nuevo usuario
    public User registrarse(String nombreUsuario, String nombre, String apellido, String telefono, String contraseña) {
        User newUser = new User();
        newUser.setUserName(nombreUsuario);
        newUser.setName(nombre);
        newUser.setLastName(apellido);
        newUser.setPhone(telefono);
        newUser.setPassword(contraseña);
        return userRepository.save(newUser);
>>>>>>> 1c41f1d95f922763c317c7856c09e2f301ef0d58
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
<<<<<<< HEAD

    public Optional<List<User>> findByNombreOrApellido(String nombre, String apellido){
        return userRepository.findByNombreOrApellido(
                Optional.ofNullable(nombre).orElse(""),
                Optional.ofNullable(apellido).orElse(""));
    }

    public Optional<User> getByDni(String dni){
        return userRepository.getByDni(dni);
    }

    public Optional<List<User>> getByRol(RolUser rol){
        return userRepository.getByRol(rol);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(int userId, User user) {
        return getById(userId).map(existingUser -> {
            user.setUserId(userId);
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + userId));
    }

    public boolean delete(int userId){
        return getById(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
=======
}
>>>>>>> 1c41f1d95f922763c317c7856c09e2f301ef0d58
