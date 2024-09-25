package com.gestion.viviendas.persistence.mapper;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "dni", target = "dni"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "direccion", target = "direction"),
            @Mapping(source = "contraseña", target = "password"),
            @Mapping(source = "rol", target = "rol"),
    })

    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "alquileres", ignore = true)
    @Mapping(target = "propiedades", ignore = true)
    Usuario toUsuario(User user);
}
