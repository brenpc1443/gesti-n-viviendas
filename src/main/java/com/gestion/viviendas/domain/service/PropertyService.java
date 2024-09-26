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

    public Optional<List<Property>> getByCapacityBetween(int min, int max) {
        return propertyRepository.getByCapacityBetween(min, max);
    }

    public Optional<List<Property>> getByType(String type) {
        return propertyRepository.getByType(type);
    }

    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public boolean delete(int propertyId) {
        return getById(propertyId).map(property -> {
            propertyRepository.delete(propertyId);
            return true;
        }).orElse(false);
    }
}
