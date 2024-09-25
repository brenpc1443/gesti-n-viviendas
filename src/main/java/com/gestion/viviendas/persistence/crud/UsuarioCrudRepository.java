package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

    List<Usuario> findByNombreOrApellido(String filtro);

    Usuario findByDni(String dni);

    List<Usuario> findByRol(String rol);
}
