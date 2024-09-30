package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

    List<Usuario> findByNombreOrApellido(String nombre, String apellido);

    Optional<List<User>> findByTelefonoAndContraseña(String telefono, String apellido);

    Usuario findByDni(String dni);

    List<Usuario> findByRol(RolUser rol);
}
