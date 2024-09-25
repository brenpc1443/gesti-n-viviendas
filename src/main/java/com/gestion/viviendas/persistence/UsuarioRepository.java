package com.gestion.viviendas.persistence;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.repository.UserRepository;
import com.gestion.viviendas.persistence.crud.UsuarioCrudRepository;
import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.mapper.UserMapper;
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
    public List<User> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> getById(int userId) {
        return usuarioCrudRepository.findById(userId).map(user -> mapper.toUser(user));
    }

    @Override
    public Optional<List<User>> findByNombreOrApellido(String filtro) {
        List<Usuario> usuarios = usuarioCrudRepository.findByNombreOrApellido(filtro);
        return Optional.of(mapper.toUsers(usuarios));
    }

    @Override
    public Optional<User> getByDni(String dni) {
        Usuario usuario = usuarioCrudRepository.findByDni(dni);
        return Optional.of(mapper.toUser(usuario));
    }

    @Override
    public Optional<List<User>> getByRol(String rol) {
        List<Usuario> usuarios = usuarioCrudRepository.findByRol(rol);
        return Optional.of(mapper.toUsers(usuarios));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }
}
