package com.gestion.viviendas.web.controller;

import com.gestion.viviendas.domain.Property;
import com.gestion.viviendas.domain.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/all")
    public List<Property> getAll(){
        return propertyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Property> getById(@PathVariable("id") int idProperty){
        return propertyService.getById(idProperty);
    }

    @GetMapping("/user/{id}")
    public Optional<List<Property>> getByUser(@PathVariable("id") int userId) {
        return propertyService.getByUser(userId);
    }

    @GetMapping("/capacity")
    public Optional<List<Property>> getByCapacityBetween(
            @RequestParam("min") int minCapacity,
            @RequestParam("max") int maxCapacity
    ) {
        return propertyService.getByCapacityBetween(minCapacity, maxCapacity);
    }

    @GetMapping("/type/{type}")
    public Optional<List<Property>> getByType(@PathVariable("type") String type) {
        return propertyService.getByType(type);
    }

    @PostMapping("/")
    public Property save(@RequestBody Property property) {
        return propertyService.save(property);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int idProperty) {
        return propertyService.delete(idProperty);
    }
}
