package com.gestion.viviendas.web.controller;

import com.gestion.viviendas.domain.Property;
import com.gestion.viviendas.domain.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/all")
    public List<Property> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Property> getById(@PathVariable("id") int idProperty) {
        return propertyService.getById(idProperty);
    }

    @GetMapping("/user/{id}")
    public Optional<List<Property>> getByUser(@PathVariable("id") int userId) {
        return propertyService.getByUser(userId);
    }

    @GetMapping("/filter")
    public Optional<List<Property>> filter(
            @Param("price") Double price,
            @Param("city") String city,
            @Param("type") String type,
            @Param("capacity") Integer capacity,
            @Param("nRooms") Integer nRooms) {
        return propertyService.filter(price, city, type, capacity, nRooms);
    }

    @PostMapping("/")
    public Property save(@RequestBody Property property) {
        return propertyService.save(property);
    }

    @PutMapping("/{id}")
    public Property update(@PathVariable("id") int idProperty, @RequestBody Property property) {
        return propertyService.update(idProperty, property);
    }

    @PutMapping("/estado/{estado}/{id}")
    public Property update(@PathVariable("id") int idProperty, @PathVariable("estado") String availibilty) {
        return propertyService.updateState(idProperty, availibilty);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idProperty) {
        return propertyService.delete(idProperty);
    }
}
