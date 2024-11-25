package com.gestion.viviendas.domain.repository;

import com.gestion.viviendas.domain.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository{

    List<Property> getAll();
    Optional<Property> getById(int propertyId);
    Optional<List<Property>> getByUser(int userId);
    Optional<List<Property>> filter(Double price, String city, String type,
    Integer capacity, Integer nRooms);
    Property save(Property property);
    void delete(int propertyId);

}
