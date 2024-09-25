package com.gestion.viviendas.domain.repository;

import com.gestion.viviendas.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();
    Optional<User> getById(int userId);
    Optional<List<User>> findByNombreOrApellido(String filtro);
    Optional<User> getByDni(String dni);
    Optional<List<User>> getByRol(String rol);
    User save(User user);
    void delete(int userId);

}
