package com.gestion.viviendas.domain.repository;

import com.gestion.viviendas.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserNameAndPassword(String userName, String password);

    User save(User user);


    Optional<User> getByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña);

    Optional<User> getById(int userId);
}
