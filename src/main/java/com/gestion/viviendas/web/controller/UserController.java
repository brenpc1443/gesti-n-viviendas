package com.gestion.viviendas.web.controller;

import com.gestion.viviendas.domain.User;
import com.gestion.viviendas.domain.service.UserService;
import com.gestion.viviendas.persistence.type.RolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/login")
    public Optional<User> getLogin(@RequestParam(value = "telefono") String telefono, @RequestParam (value = "contrasena") String contrasena){
        return userService.getByTelefonoAndContrasena(telefono, contrasena);
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") int userId){
        return userService.getById(userId);
    }

    @GetMapping("/filtro")
    public Optional<List<User>> findByNombreOrApellido(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "apellido", required = false) String apellido
    ){
        return userService.findByNombreOrApellido(nombre, apellido);
    }

    @GetMapping("/dni/{dni}")
    public Optional<User> getByDni(@PathVariable("dni") String dni){
        return userService.getByDni(dni);
    }

    @GetMapping("/rol/{rol}")
    public Optional<List<User>> getByRol(@PathVariable("rol") RolUser rol) {
        return userService.getByRol(rol);
    }

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") int userId, @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int userId){
        return userService.delete(userId);
    }
}
