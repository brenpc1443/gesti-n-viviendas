package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

<<<<<<< HEAD
    List<Usuario> findByNombreOrApellido(String nombre, String apellido);

    Usuario findByTelefonoAndContraseña(String telefono, String apellido);

    Usuario findByDni(String dni);

    List<Usuario> findByRol(RolUser rol);
=======
    Optional<Usuario> findByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña);
    Optional<Usuario> findById(int id);
>>>>>>> 1c41f1d95f922763c317c7856c09e2f301ef0d58
}
