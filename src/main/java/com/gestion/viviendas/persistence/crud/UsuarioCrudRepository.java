package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

    Usuario findByNombreOrApellido(String filtro);

    Optional<Usuario> findByDni(String dni);

    List<Usuario> findByRol(String rol);

}
