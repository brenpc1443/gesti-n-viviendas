package com.gestion.viviendas.domain.repository;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.persistence.type.RolUser;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

<<<<<<< HEAD
    List<User> getAll();
    Optional <User> getByTelefonoAndContrasena(String telefono, String contrasena);
    Optional<User> getById(int userId);
    Optional<List<User>> findByNombreOrApellido(String name, String lastName);
    Optional<User> getByDni(String dni);
    Optional<List<User>> getByRol(RolUser rol);
    User save(User user);
    void delete(int userId);
=======
    Optional<User> findByUserNameAndPassword(String userName, String password);
>>>>>>> 1c41f1d95f922763c317c7856c09e2f301ef0d58

    User save(User user);


    Optional<User> getByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña);

    Optional<User> getById(int userId);
}
