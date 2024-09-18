package com.gestion.viviendas.persistence;

import com.gestion.viviendas.persistence.crud.UsuarioCrudRepository;
import com.gestion.viviendas.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    public Optional<Usuario> getById(int idUsuario) {
        return (Optional<Usuario>) usuarioCrudRepository.findById(idUsuario);
    }

    public Optional<Usuario> getByDni(String dni) {
        return (Optional<Usuario>) usuarioCrudRepository.findByDni(dni);
    }

    public List<Usuario> getByRol(String rol) {
        return (List<Usuario>) usuarioCrudRepository.findByRol(rol);
    }

    public Usuario save(Usuario usuario) {
        return usuarioCrudRepository.save(usuario);
    }

    public void delete(int idUsuario) {
        usuarioCrudRepository.deleteById(idUsuario);
    }
}
