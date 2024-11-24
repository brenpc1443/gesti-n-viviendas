package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

    Optional<Usuario> findByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña);
    Optional<Usuario> findById(int id);
}
