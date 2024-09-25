package com.gestion.viviendas.domain.service;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<User> getById(int userId){
        return userRepository.getById(userId);
    }

    public Optional<List<User>> findByNombreOrApellido(String filtro){
        return userRepository.findByNombreOrApellido(filtro);
    }

    public Optional<User> getByDni(String dni){
        return userRepository.getByDni(dni);
    }

    Optional<List<User>> getByRol(String rol){
        return userRepository.getByRol(rol);
    }

    public User save(User user){
        return userRepository.save(user);
    }
    public boolean delete(int userId){
        return getById(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
