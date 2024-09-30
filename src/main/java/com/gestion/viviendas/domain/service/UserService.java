package com.gestion.viviendas.domain.service;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.repository.UserRepository;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> findByTelefonoAndContraseña(String phone, String password) {
        return userRepository.findByTelefonoAndContraseña(phone, password);
    }

    public Optional<User> getById(int userId){
        return userRepository.getById(userId);
    }

    public Optional<List<User>> findByNombreOrApellido(String nombre, String apellido){
        return userRepository.findByNombreOrApellido(
                Optional.ofNullable(nombre).orElse(""),
                Optional.ofNullable(apellido).orElse(""));
    }

    public Optional<User> getByDni(String dni){
        return userRepository.getByDni(dni);
    }

    public Optional<List<User>> getByRol(RolUser rol){
        return userRepository.getByRol(rol);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(int userId, User user) {
        return getById(userId).map(existingUser -> {
            user.setUserId(userId);
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + userId));
    }

    public boolean delete(int userId){
        return getById(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
