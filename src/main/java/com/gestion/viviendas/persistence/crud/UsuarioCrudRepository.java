package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

    List<Usuario> findByNombreOrApellido(String nombre, String apellido);

    Usuario getByTelefonoAndContrasena(String telefono, String apellido);

    Usuario findByDni(String dni);

    List<Usuario> findByRol(RolUser rol);
}
