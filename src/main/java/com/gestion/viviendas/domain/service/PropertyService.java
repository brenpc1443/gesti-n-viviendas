package com.gestion.viviendas.domain.service;

import com.gestion.viviendas.domain.Property;
import com.gestion.viviendas.domain.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAll() {
        return propertyRepository.getAll();
    }

    public Optional<Property> getById(int propertyId) {
        return propertyRepository.getById(propertyId);
    }

    public Optional<List<Property>> getByUser(int userId) {
        return propertyRepository.getByUser(userId);
    }

    public Optional<List<Property>> filter(Double price, String city, String type, Integer capacity, Integer nRooms) {
        return propertyRepository.filter(price, city, type, capacity, nRooms);
    }

    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateState(int propertyId, String availability) {
        return getById(propertyId).map(existingProperty -> {
            existingProperty.setAvailability(availability);
            return propertyRepository.save(existingProperty);
        }).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public Property update(int propertyId, Property property) {
        return getById(propertyId).map(existingProperty -> {
            property.setPropertyId(propertyId);
            return propertyRepository.save(property);
        }).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public boolean delete(int propertyId) {
        return getById(propertyId).map(property -> {
            propertyRepository.delete(propertyId);
            return true;
        }).orElse(false);
    }
}
