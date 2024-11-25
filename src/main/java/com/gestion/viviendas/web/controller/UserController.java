package com.gestion.viviendas.web.controller;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.repository.UserRepository;
import com.gestion.viviendas.domain.service.UserService;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Iniciar sesión
    @GetMapping("/login")
    public ResponseEntity<User> iniciarSesion(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Validar que ambos campos estén presentes
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Usar el servicio para verificar las credenciales
        Optional<User> userFromDb = userService.iniciarSesion(username, password);

        // Retornar el usuario o un error 401 si no se encuentran las credenciales
        return userFromDb.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).build());
    }

    // Registrarse
    @PostMapping("/register")
    public ResponseEntity<User> registrarse(@RequestBody User user) {
        // Se usa el objeto User con todos los datos necesarios para el registro
        User newUser = userService.registrarse(user.getUserName(), user.getName(),
                user.getLastName(), user.getPhone(),
                user.getPassword());
        return ResponseEntity.ok(newUser);
    }

    // Editar datos del usuario
    @PutMapping("/edit/{userId}")
    public ResponseEntity<User> editar(@PathVariable int userId, @RequestBody User user) {
        // El ID se mantiene en la URL, pero los demás datos se pasan en el cuerpo (body)
        Optional<User> updatedUser = userService.editar(userId, user.getUserName(), user.getPhone(), user.getPassword());
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
