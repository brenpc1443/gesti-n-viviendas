package com.gestion.viviendas.persistence;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.repository.UserRepository;
import com.gestion.viviendas.persistence.crud.UsuarioCrudRepository;
import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.mapper.UserMapper;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public Optional<User> findByUserNameAndPassword(String userName, String password) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByNombreUsuarioAndContraseña(userName, password);
        return usuario.map(mapper::toUser);
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public Optional<User> getByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña) {
        // Buscar usuario por nombre de usuario y contraseña
        Optional<Usuario> usuario = usuarioCrudRepository.findByNombreUsuarioAndContraseña(nombreUsuario, contraseña);
        return usuario.map(mapper::toUser); // Convertir de entidad a DTO
    }

    @Override
    public Optional<User> getById(int userId) {
        // Buscar usuario por ID
        Optional<Usuario> usuario = usuarioCrudRepository.findById(userId);
        return usuario.map(mapper::toUser); // Convertir de entidad a DTO
    }
}
