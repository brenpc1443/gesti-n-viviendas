package com.gestion.viviendas.domain.repository;

import com.gestion.viviendas.domain.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository{

    List<Property> getAll();
    Optional<Property> getById(int propertyId);
    Optional<List<Property>> getByUser(int userId);
    //List<Property> getByAvailability(String availability);
    Optional<List<Property>> getByCapacityBetween(int min, int max);
    Optional<List<Property>> getByType(String type);
    Property save(Property property);
    void delete(int propertyId);

}
